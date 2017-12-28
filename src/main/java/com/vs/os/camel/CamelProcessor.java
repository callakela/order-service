package com.vs.os.camel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.ConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vs.os.configuration.JmsConfiguration;

@Component
public class CamelProcessor {

	private CamelContext camelContext;

	@Autowired
	private ConnectionFactory connectionFactory;

	@Autowired
	@Qualifier("StockValidationQueueProcessor")
	private Processor stockValidationQueueProcessor;

	@Autowired
	@Qualifier("PaymentValidationQueueProcessor")
	private Processor paymentValidationQueueProcessor;

	@Autowired
	@Qualifier("StockValidationFailureQueueProcessor")
	private Processor stockValidationFailureQueueProcessor;

	@Autowired
	@Qualifier("PaymentValidationFailureQueueProcessor")
	private Processor paymentValidationFailureQueueProcessor;

	@Autowired
	@Qualifier("OrderConfirmationQueueProcessor")
	private Processor orderConfirmationQueueProcessor;

	public CamelProcessor() {
		camelContext = new DefaultCamelContext();
	}

	@PostConstruct
	public void initializeCamelProcessor() throws Exception {

		camelContext.addComponent("stock-validation-flow",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		camelContext.addComponent("payment-processor-flow",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		camelContext.addComponent("stock-validation-fail-flow",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		camelContext.addComponent("payment-failed-flow",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		camelContext.addComponent("order-confirmation-flow",
				JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		addStockValidationRoute();
		addPaymentValidationRouter();
		addStockValidationFailureRoute();
		addPaymentValidationFailureRouter();
		addOrderConfirmationRouter();

		camelContext.start();

	}

	private void addStockValidationRoute() throws Exception {
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				from(
						"stock-validation-flow:queue:"
								+ JmsConfiguration.STOCK_VALIDATION_QUEUE)
						.process(stockValidationQueueProcessor)
						.choice()
						.when(header("validation-status").isEqualTo("pass"))
						.to("stock-validation-flow:queue:payment-validation-queue")
						.otherwise()
						.to("stock-validation-flow:queue:stock-validation-failure-queue");
			}
		});
	}

	private void addPaymentValidationRouter() throws Exception {
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				from("payment-processor-flow:queue:payment-validation-queue")
						.process(paymentValidationQueueProcessor)
						.choice()
						.when(header("payment-status").isEqualTo("pass"))
						.to("payment-processor-flow:queue:order-confirmation-queue")
						.otherwise()
						.to("payment-processor-flow:queue:payment-validation-failure-queue");
			}
		});
	}

	private void addStockValidationFailureRoute() throws Exception {
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				from(
						"stock-validation-fail-flow:queue:stock-validation-failure-queue")
						.process(stockValidationFailureQueueProcessor);
			}
		});
	}

	private void addPaymentValidationFailureRouter() throws Exception {
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				from(
						"payment-failed-flow:queue:payment-validation-failure-queue")
						.process(paymentValidationFailureQueueProcessor);
			}
		});
	}

	private void addOrderConfirmationRouter() throws Exception {
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {

				from("order-confirmation-flow:queue:order-confirmation-queue")
						.process(orderConfirmationQueueProcessor);
			}
		});
	}

	@PreDestroy
	public void shutdown() throws Exception {

		camelContext.stop();

	}
}

package com.vs.os.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.vs.os.model.Order;

@Component("PaymentValidationFailureQueueProcessor")
public class PaymentValidationFailureQueueProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Order order = new Order()
				.getObject((String) exchange.getIn().getBody());

		System.out.println("***********Order Failed Due Payment Issue:"
				+ order.getEmail());

	}

}

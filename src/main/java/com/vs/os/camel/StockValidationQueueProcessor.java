package com.vs.os.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.vs.os.model.Order;

@Component("StockValidationQueueProcessor")
public class StockValidationQueueProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Order order = new Order()
				.getObject((String) exchange.getIn().getBody());

		if (order.getEmail().equalsIgnoreCase("write2ptiwari@gmail.com")) {

			exchange.getOut().setHeader("validation-status", "pass");
		} else {

			exchange.getOut().setHeader("validation-status", "fail");
		}

		exchange.getOut().setBody(exchange.getIn().getBody());

	}

}

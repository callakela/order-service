package com.vs.os.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.vs.os.model.Order;

@Component("OrderConfirmationQueueProcessor")
public class OrderConfirmationQueueProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Order order = new Order()
				.getObject((String) exchange.getIn().getBody());

		System.out
				.println("***********Order Confirmed for:" + order.getEmail());

	}

}

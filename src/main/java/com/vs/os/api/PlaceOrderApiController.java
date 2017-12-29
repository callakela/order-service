package com.vs.os.api;

import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.vs.os.configuration.JmsConfiguration;
import com.vs.os.dao.OrderDAO;
import com.vs.os.model.Order;

@Controller
public class PlaceOrderApiController implements PlaceOrderApi {

	@Autowired
	@Qualifier(JmsConfiguration.JMS_TEMPLATE)
	private JmsTemplate jmsTemplate;

	@Autowired
	private OrderDAO orderDAO;

	public ResponseEntity<Integer> placeOrder(
			@ApiParam(value = "Create aproduct") @RequestBody Order order) {

		orderDAO.persist(order);
		jmsTemplate.convertAndSend(JmsConfiguration.STOCK_VALIDATION_QUEUE,
				order.getJson());

		return new ResponseEntity<Integer>(order.getOrderId(), HttpStatus.OK);

	}

}

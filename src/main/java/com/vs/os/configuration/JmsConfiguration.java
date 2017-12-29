package com.vs.os.configuration;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfiguration {

	public static final String STOCK_VALIDATION_FAILUR_QUEUE = "stock-validation-failure-queue";
	public static final String STOCK_VALIDATION_QUEUE = "stock-validation-queue";
	public static final String PLACE_ORDER_QUEUE = "place-order-queue";
	public static final String JMS_TEMPLATE = "jmsTemplate";
	public static final String ACTIVE_MQ_CONNECTION_FACTORY = "activeMQConnectionFactory";

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {

		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean(name = ACTIVE_MQ_CONNECTION_FACTORY)
	public ConnectionFactory jsmConnectionFactory() {
		return new ActiveMQConnectionFactory("admin", "admin",
				"tcp://IMPETUS-NL133:61616");
	}

	@Bean(name = JMS_TEMPLATE)
	public JmsTemplate jsmTemplate(
			@Qualifier(ACTIVE_MQ_CONNECTION_FACTORY) ConnectionFactory connectionFactory) {
		return new JmsTemplate(connectionFactory);
	}

	@Bean(name = PLACE_ORDER_QUEUE)
	public Queue placeOrderQueue() {
		return new ActiveMQQueue("place-order-queue");
	}

	@Bean(name = STOCK_VALIDATION_QUEUE)
	public Queue stockValidationQueue() {
		return new ActiveMQQueue("stock-validation-queue");
	}

	@Bean(name = STOCK_VALIDATION_FAILUR_QUEUE)
	public Queue stockValidationFailueQueue() {
		return new ActiveMQQueue("stock-validation-failure-queue");
	}

}

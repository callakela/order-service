package com.vs.os.service;

import java.util.List;

import com.vs.os.model.Order;

public interface OrderService {
	
	void persist(Order order);

	List<Order> getByEmailId(String email);

	List<Order> getByEmailIdAndStatus(String email, String status);
}

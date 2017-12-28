package com.vs.os.dao;

import java.util.List;

import com.vs.os.model.Order;

public interface OrderDAO {

	void persist(Order order);

	List<Order> getByEmailId(String email);

	List<Order> getByEmailIdAndStatus(String email, String status);
}

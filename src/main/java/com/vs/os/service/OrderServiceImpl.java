package com.vs.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vs.os.dao.OrderDAO;
import com.vs.os.model.Order;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public void persist(Order order) {
	
		orderDAO.persist(order);
		
	}

	@Override
	public List<Order> getByEmailId(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getByEmailIdAndStatus(String email, String status) {
		// TODO Auto-generated method stub
		return null;
	}

}

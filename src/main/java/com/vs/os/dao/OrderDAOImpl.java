package com.vs.os.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vs.os.model.Order;

@Repository
@Transactional
public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

	@Override
	public void persist(Order order) {
		order.setOrderId(null);
		entityManager.persist(order);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getByEmailId(String email) {
		return entityManager.createQuery(" from Order O WHERE O.email :email")
				.setParameter("email", email).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getByEmailIdAndStatus(String email, String status) {
		return entityManager
				.createQuery(
						" from Order O WHERE O.email :email AND O.status :status")
				.setParameter("email", email).setParameter("status", status)
				.getResultList();
	}

}

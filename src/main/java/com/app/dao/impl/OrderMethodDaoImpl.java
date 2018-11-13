package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao{
    @Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		return (Integer)ht.save(orderMethod);
	}

	@Override
	public void updateOrderMethod(OrderMethod orderMethod) {
		ht.update(orderMethod);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod orderMethod=new OrderMethod();
		orderMethod.setId(id);
		ht.delete(orderMethod);
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMethod> getOrderMethodByMode(String mode) {
		String hql=" from " 
							+ OrderMethod.class.getName()
							+ "  where mode=? ";
		@SuppressWarnings("deprecation")
		List<OrderMethod>oms=(List<OrderMethod>) ht.find(hql, mode);
		return oms;
	}

}

package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveCustomer(Customer customer) {
		return (Integer)ht.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		ht.update(customer);		
	}

	@Override
	public void deleteCustomer(Integer custId) {
		Customer customer=new Customer();
		customer.setCustId(custId);
		ht.delete(custId);		
	}

	@Override
	public Customer getOneCustomer(Integer custId) {
		return ht.get(Customer.class, custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return ht.loadAll(Customer.class);
	}

}

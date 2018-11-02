package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerDao {

	public Integer saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Integer custId);
	public Customer getOneCustomer(Integer custId);
	public List<Customer>getAllCustomers();
}

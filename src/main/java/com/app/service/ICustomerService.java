package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	public Integer saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Integer custId);
	public Customer getOneCustomer(Integer custId);
	public List<Customer>getAllCustomers();


}

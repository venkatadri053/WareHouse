package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.app.model.Customer;
import com.app.model.Vendor;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {
@Autowired
private ICustomerService service;
@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	map.addAttribute("vendor",new Vendor());
	return"VendorRegister";
}
@RequestMapping(value="/register", method=RequestMethod.POST)
public String saveData(@ModelAttribute Customer customer,ModelMap map) {
	Integer id=service.saveCustomer(customer);
	String msg = "Vendor '" + id + "' saved successfully";
	map.addAttribute("message", msg);
	map.addAttribute("vendor", new Vendor());
	return "VendorRegister";

}

}

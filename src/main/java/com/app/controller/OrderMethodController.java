package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.view.OrderMethodExcelView;
import com.app.controller.view.OrderMethodPdfView;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Controller
@RequestMapping("/OrderMethod")
public class OrderMethodController {
	@Autowired
private IOrderMethodService service;
	@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	map.addAttribute("orderMethod", new OrderMethod());
	return "OrderRegister";
}
@RequestMapping(value="/insert", method=RequestMethod.POST)
public String saveData(
		@ModelAttribute OrderMethod orderMethod, ModelMap map) {
	
	Integer id=service.saveOrderMethod(orderMethod);
	String msg="orderMethod '"+id+"' saved";
	map.addAttribute("message",msg);
	map.addAttribute("orderMethod", new OrderMethod());
	return "OrderRegister";
}
//3 Get data from Db to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<OrderMethod> orderMethods=service.getAllOrderMethods();
	map.addAttribute("list", orderMethods);
	return "OrderData";
}
//$.delete OrderMethod by id
@RequestMapping("/delete")
public String deleteOrderMethod(@RequestParam("id")Integer id,ModelMap map) {
	service.deleteOrderMethod(id);
	String msg="orderMethod '"+id+"' Deleted";
	List<OrderMethod> orderMethods=service.getAllOrderMethods();
	map.addAttribute("message",msg);
	map.addAttribute("list",orderMethods);
	return "OrderData";
}
//add edit and update
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
OrderMethod orderMethod=service.getOneOrderMethod(id);
	map.addAttribute("orderMethod",orderMethod);
	return "OrderEdit";
}
//5.delete OrderMethod by id
@RequestMapping(value="/update", method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
	service.updateOrderMethod(orderMethod);
	String msg="orderMethod '"+orderMethod.getId()+"' Updated";
	List<OrderMethod>  orderMethods=service.getAllOrderMethods();
	map.addAttribute("message",msg);
	map.addAttribute("list",orderMethods);
	return "OrderData";
}
//7.Export data to excel file
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<OrderMethod> orderMethods=service.getAllOrderMethods();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new OrderMethodExcelView());
	//model details
	m.addObject("orderMethods",orderMethods);
	return m;
}
//8.Export data to excel file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	List<OrderMethod> orderMethods=service.getAllOrderMethods();
	ModelAndView m=new ModelAndView();
	m.setView(new OrderMethodPdfView());
	m.addObject("orderMethods", orderMethods);
	return m;
	
}
}

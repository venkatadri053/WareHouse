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

import com.app.controller.view.ShipmentTypeExcelView;
import com.app.controller.view.ShipmentTypePdfView;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Controller
@RequestMapping("/ShipmentType")
public class ShipmentTypeController {
	@Autowired
private IShipmentTypeService service;
	@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	map.addAttribute("shipmentType", new ShipmentType());
	return "ShipmentRegister";
}
@RequestMapping(value="/insert", method=RequestMethod.POST)
public String saveData(
		@ModelAttribute ShipmentType shipmentType, ModelMap map) {
	
	Integer id=service.saveShipmentType(shipmentType);
	String msg="shipmentType '"+id+"' saved";
	map.addAttribute("message",msg);
	map.addAttribute("shipmentType", new ShipmentType());
	return "ShipmentRegister";
}
//3 Get data from Db to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<ShipmentType> shipmentTypes=service.getAllShipmentTypes();
	map.addAttribute("list", shipmentTypes);
	return "ShipmentData";
}
//$.delete ShipmentType by id
@RequestMapping("/delete")
public String deleteShipmentType(@RequestParam("id")Integer id,ModelMap map) {
	service.deleteShipmentType(id);
	String msg="ShipmentType '"+id+"' Deleted";
	List<ShipmentType> shipmentTypes=service.getAllShipmentTypes();
	map.addAttribute("message",msg);
	map.addAttribute("list",shipmentTypes);
	return "ShipmentData";
}
//add edit and update
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
ShipmentType shipmentType=service.getOneShipmentType(id);
	map.addAttribute("shipmentType",shipmentType);
	return "ShipmentEdit";
}
//5.delete ShipmentType by id
@RequestMapping(value="/update", method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
	service.updateShipmentType(shipmentType);
	String msg="ShipmentType '"+shipmentType.getId()+"' Updated";
	List<ShipmentType>  shipmentTypes=service.getAllShipmentTypes();
	map.addAttribute("message",msg);
	map.addAttribute("list",shipmentTypes);
	return "ShipmentData";
}
//7.Export data to excel file
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<ShipmentType> shipmentTypes=service.getAllShipmentTypes();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new ShipmentTypeExcelView());
	//model details
	m.addObject("shipmentTypes",shipmentTypes);
	return m;
}
//8.Export data to excel file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	List<ShipmentType> shipmentTypes=service.getAllShipmentTypes();
	ModelAndView m=new ModelAndView();
	m.setView(new ShipmentTypePdfView());
	m.addObject("shipmentTypes", shipmentTypes);
	return m;
	
}
}

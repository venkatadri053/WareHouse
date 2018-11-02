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

import com.app.controller.view.WhUserTypeExcelView;
import com.app.controller.view.WhUserTypePdfView;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Controller
@RequestMapping("/WhUserType")
public class WhUserTypeController {
	@Autowired
private IWhUserTypeService service;
	@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	map.addAttribute("whUserType", new WhUserType());
	return "WhUserRegister";
}
@RequestMapping(value="/insert", method=RequestMethod.POST)
public String saveData(
		@ModelAttribute WhUserType WhUserType, ModelMap map) {
	
	Integer id=service.saveWhUserType(WhUserType);
	String msg="WhUserType '"+id+"' saved";
	map.addAttribute("message",msg);
	map.addAttribute("whUserType", new WhUserType());
	return "WhUserRegister";
}
//3 Get data from Db to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	map.addAttribute("list", whUserTypes);
	return "WhUserData";
}
//$.delete WhUserType by id
@RequestMapping("/delete")
public String deleteWhUserType(@RequestParam("id")Integer id,ModelMap map) {
	service.deleteWhUserType(id);
	String msg="WhUserType '"+id+"' Deleted";
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	map.addAttribute("message",msg);
	map.addAttribute("list",whUserTypes);
	return "WhUserData";
}
//add edit and update
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
WhUserType whUserType=service.getOneWhUserType(id);
	map.addAttribute("whUserType",whUserType);
	return "WhUserEdit";
}
//5.delete WhUserType by id
@RequestMapping(value="/update", method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute WhUserType WhUserType,ModelMap map) {
	service.updateWhUserType(WhUserType);
	String msg="WhUserType '"+WhUserType.getId()+"' Updated";
	List<WhUserType>  whUserTypes=service.getAllWhUserTypes();
	map.addAttribute("message",msg);
	map.addAttribute("list",whUserTypes);
	return "WhUserData";
}
//7.Export data to excel file
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new WhUserTypeExcelView());
	//model details
	m.addObject("whUserTypes",whUserTypes);
	return m;
}
//8.Export data to excel file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	ModelAndView m=new ModelAndView();
	m.setView(new WhUserTypePdfView());
	m.addObject("whUserTypes", whUserTypes);
	return m;
	
}
}

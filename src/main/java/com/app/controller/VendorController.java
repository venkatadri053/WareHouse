package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.controller.view.VendorExcelView;
import com.app.controller.view.VendorPdfView;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorService service;

	public String showRegPage(ModelMap map) {
		map.addAttribute("vendor", new Vendor());
		return"VendorRegister";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Vendor vendor,ModelMap map) {
	Integer id=service.saveVendor(vendor);
	String msg="Vendor ''"+id+"saved successfully";
	map.addAttribute("message", msg);
	map.addAttribute("vendor",new Vendor() );
		return"VendorRegister";
	}
	
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Vendor> vendors = service.getAllVendors();
		map.addAttribute("list", vendors);
		return "VendorData";
	}
	@RequestMapping("/delete")
	public String deleteVendor(@ModelAttribute("venId")Integer venId,ModelMap map) {
		service.deleteVendor(venId);
		String msg = "Vendor'" + venId + "'Deleted Successfully";
		List<Vendor> vendors=service.getAllVendors();
		map.addAttribute("message", msg);
		map.addAttribute("list", vendors);
		return "VendorData";
	}
	
	@RequestMapping("/edit")
	public String showEditVendor(@RequestParam("venId") Integer venId, ModelMap map) {
		Vendor vendor = service.getOneVendor(venId);
		map.addAttribute("vendor", vendor);
		return "VendorEdit";
	}

	@RequestMapping("/update")
	public String doUpdateVendorData(@ModelAttribute Vendor vendor, ModelMap map) {
		service.updateVendor(vendor);
		String msg = "Vendor '" + vendor.getVenId() + "'Updated Successfully";
		List<Vendor> vendors = service.getAllVendors();
		map.addAttribute("message", msg);
		map.addAttribute("list", vendors);
		return "VendorData";
	}

	// 7.Export data to excel file
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Vendor> vendors = service.getAllVendors();
		ModelAndView m = new ModelAndView();
		// view details
		m.setView(new VendorExcelView());
		// model details
		m.addObject("vendors", vendors);
		return m;
	}

	// 8.Export data to excel file
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<Vendor> vendors = service.getAllVendors();
		ModelAndView m = new ModelAndView();
		m.setView(new VendorPdfView());
		m.addObject("vendors", vendors);
		return m;

	}
	
	
	
	
	
	
	
	
}

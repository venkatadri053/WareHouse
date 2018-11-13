package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.view.UomExcelView;
import com.app.controller.view.UomPdfView;
import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;
	
	@Autowired
	private UomValidator validator;



	// 1.Show Reg. form
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}

	// 2.Insert data from DB
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom,Errors errors, ModelMap map) {
		validator.validate(uom, errors);
		if(!errors.hasErrors()) { //no errors

		Integer id = service.saveUom(uom);
		String msg = "Uom '" + id + "' saved";
		map.addAttribute("message", msg);
		map.addAttribute("uom", new Uom());
		}
		return "UomRegister";
	}

	// 3 .Get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("list", uoms);
		return "UomData";
	}

	// 4.Delete Uom by Id
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer id, ModelMap map) {
		service.deleteUom(id);
		String msg = "Uom '" + id + "'Deleted";
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("message", msg);
		map.addAttribute("list", uoms);
		return "UomData";
	}

	// 5. Edit Uom by Id
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, ModelMap map) {
		Uom uom = service.getOneUom(id);
		map.addAttribute("uom", uom);
		return "UomEdit";
	}

	// 6.Update Uom by Id
	@RequestMapping("/update")
	public String doUpdateUomData(@ModelAttribute Uom uom, ModelMap map) {
		service.updateUom(uom);
		String msg = "Uom '" + uom.getId() + "'Updated Successfully";
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("message", msg);
		map.addAttribute("list", uoms);
		return "UomData";
	}

	// 7.Export data to excel file
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Uom> uoms = service.getAllUoms();
		ModelAndView m = new ModelAndView();
		// view details
		m.setView(new UomExcelView());
		// model details
		m.addObject("uoms", uoms);
		return m;
	}

	// 8.Export data to excel file
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<Uom> uoms = service.getAllUoms();
		ModelAndView m = new ModelAndView();
		m.setView(new UomPdfView());
		m.addObject("uoms", uoms);
		return m;

	}

}

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private IDocumentService service;
	//1.to show doc upload page
	@RequestMapping("/show")
	public String showDocuments() {
		return"Documents";
	}
	
	public String uploadDoc(@RequestParam CommonsMultipartFile file,ModelMap map) {
	if(file!=null) {
		Document doc=new Document();
		doc.setFileName(file.getOriginalFilename());
		doc.setFileData(file.getBytes());
		int fileId=service.saveDocument(doc);
		map.addAttribute("message", "uploaded '"+fileId+"'  successfully");
	}
		return "Documents";
	}
}

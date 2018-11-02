package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String showDocuments(ModelMap map) {
		List<Object[]>docs=service.getDocumentIdAndNames();
		map.addAttribute("docs", docs);
		return"Documents";
	}
	//2.To upload document	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadDoc(@RequestParam CommonsMultipartFile file,ModelMap map) {
		if(file!=null) {
			//create model class obj
			Document doc=new Document();
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			int fileId=service.saveDocument(doc);
			map.addAttribute("message", "uploaded '"+fileId+"'  successfully");
			List<Object[]>docs=service.getDocumentIdAndNames();
			map.addAttribute("docs", docs);
		}
		return "Documents";
	}

	//3.Download Document
	@RequestMapping("/download")
	public void downloadDoc(@RequestParam("docId")int docId,HttpServletResponse resp) {
		//read document from drb using docId
		Document doc=service.getDocumentById(docId);
		//HeaderParam
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		//copy body
		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
		}
	}







}

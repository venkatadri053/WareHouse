package com.app.controller.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
																		HttpServletRequest request, HttpServletResponse response) throws Exception {

		//download Option, with file name
		response.addHeader("Content-Disposition", "attachment;filename=UOM.pdf");
		
		//create element
		//paragraph
		Paragraph p=new Paragraph("Welcome");
		
		//add to document
		document.add(p);
		
		//read data from Map
		@SuppressWarnings("unchecked")
		List<Uom> uoms=(List<Uom>)model.get("uoms");
		
		//create Table
		PdfPTable t=new PdfPTable(4);
		
		//add hearing columns
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("DSC");
		
		//add db data to table
		for(Uom u: uoms) {
			t.addCell(u.getId().toString());
			t.addCell(u.getType());
			t.addCell(u.getModel());
			t.addCell(u.getDsc());
		}
		//add to document
		document.add(t);
		
		//add date & Time
		document.add(new Paragraph(new Date().toString()));
	}

}

package com.app.controller.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//download Option, with file name
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//add to doc
		document.add(p);
		//read data from Map
		@SuppressWarnings("unchecked")
		List<OrderMethod> orderMethods=(List<OrderMethod>)model.get("orderMethods");
		//create Table
		PdfPTable t=new PdfPTable(5);
		//add hearing columns
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ACCEPT");
		t.addCell("DSC");
		
		//add db data to table
		for(OrderMethod o: orderMethods) {
			t.addCell(o.getId().toString());
			t.addCell(o.getMode());
			t.addCell(o.getCode());
			t.addCell(o.getAccept().toString());
			t.addCell(o.getDsc());
		}
		//add to document
		document.add(t);
		//add date & Time
		document.add(new Paragraph(new Date().toString()));
	}

}

package com.app.controller.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download Option, with file name
		response.addHeader("Content-Disposition", "attachment;filename=ShipmentType.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//add to doc
		document.add(p);
		//read data from Map
		@SuppressWarnings("unchecked")
		List<ShipmentType> shipmentTypes=(List<ShipmentType>)model.get("shipmentTypes");
		//create Table
		PdfPTable t=new PdfPTable(6);
		//add hearing columns
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLED");
		t.addCell("GRADE");
		t.addCell("DSC");
		
		//add db data to table
		for(ShipmentType s: shipmentTypes) {
			t.addCell(s.getId().toString());
			t.addCell(s.getMode());
			t.addCell(s.getCode());
			t.addCell(s.getEnabled());
			t.addCell(s.getGrade());
			t.addCell(s.getDsc());
		}
		//add to document
		document.add(t);
		//add date & Time
		document.add(new Paragraph(new Date().toString()));
	}

}

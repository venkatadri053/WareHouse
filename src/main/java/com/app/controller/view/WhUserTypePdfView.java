package com.app.controller.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//download Option, with file name
		response.addHeader("Content-Disposition", "attachment;filename=WhUser.pdf");
		//create element
		Paragraph p=new Paragraph("Welcome");
		//add to doc
		document.add(p);
		//read data from Map
		@SuppressWarnings("unchecked")
		List<WhUserType> whUsers=(List<WhUserType>)model.get("whUser");
		//create Table
		PdfPTable t=new PdfPTable(9);
		//add hearing columns
		t.addCell("ID");
		t.addCell("USER TYPE");
		t.addCell("USER CODE");
		t.addCell("USER FOR");
		t.addCell("USER EMAIL");
		t.addCell("USER CONTACT");
		t.addCell("USER IDTYPE");
		t.addCell("IFOTHER");
		t.addCell("IDNUM");

		//add db data to table
		for(WhUserType w: whUsers) {
			t.addCell(w.getId().toString());
			t.addCell(w.getUserType());
			t.addCell(w.getUserCode()+"");
			t.addCell(w.getUserFor());
			t.addCell(w.getUserEmail());
			t.addCell(w.getUserContact());
			t.addCell(w.getUserIdType());
			t.addCell(w.getIfOther());
			t.addCell(w.getIdNum());

		}
		//add to document
		document.add(t);
		//add date & Time
		document.add(new Paragraph(new Date().toString()));
	}

}

package com.app.controller.view;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//download Option, with file name
				response.addHeader("Content-Disposition", "attachment;filename=Vendor.pdf");
				//create element
				Paragraph p=new Paragraph("Welcome");
				//add to doc
				document.add(p);
				//read data from Map
				@SuppressWarnings("unchecked")
				List<Vendor> vendors=(List<Vendor>)model.get("vendors");
				//create Table
				PdfPTable t=new PdfPTable(5);
				//add hearing columns
				t.addCell("VENID");
				t.addCell("VENNAME");
				t.addCell("VENCODE");
				t.addCell("VENDESG");
				t.addCell("VENPRESERVE");
				
				//add db data to table
				for(Vendor s: vendors) {
					t.addCell(s.getVenId().toString());
					t.addCell(s.getVenName());
					t.addCell(s.getVenCode());
					t.addCell(s.getVenDesg());
					t.addCell(s.getVenPreserve());
				}
				//add to document
				document.add(t);
				//add date & Time
				document.add(new Paragraph(new Date().toString()));
			}

	}



package com.app.controller.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;
import com.app.model.Vendor;

public class VendorExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//file name Change
				response.addHeader("Content-Disposition","attachment;filename=Vendor.xlsx");
				//create sheet with name
				Sheet sheet=workbook.createSheet("Vendors");
				//createHead
				setHead(sheet);
				//read data
				@SuppressWarnings("unchecked")
				List<Vendor> vendors=(List<Vendor>)model.get("vendors");
				//set body
				setBody(sheet,vendors);
			}

			private void setHead(Sheet sheet) {
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("VENID");
				row.createCell(1).setCellValue("VENNAME");
				row.createCell(2).setCellValue("VENCODES");
				row.createCell(3).setCellValue("VENDESG");
				row.createCell(4).setCellValue("VENPRESERVE");
			
			}
			private void setBody(Sheet sheet, List<Vendor> vendors) {
				int rowNum=1;
				for(Vendor w:vendors) {
					Row row=sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(w.getVenId());
					row.createCell(1).setCellValue(w.getVenName());
					row.createCell(2).setCellValue(w.getVenCode());
					row.createCell(3).setCellValue(w.getVenDesg());
					row.createCell(4).setCellValue(w.getVenPreserve());
					
				}
				
			}
	}



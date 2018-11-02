package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//file name Change
		response.addHeader("Content-Disposition","attachment;filename=ShipmentType.xlsx");
		//create sheet with name
		Sheet sheet=workbook.createSheet("shipmentTypes");
		//createHead
		setHead(sheet);
		//read data
		@SuppressWarnings("unchecked")
		List<ShipmentType> shipmentTypes=(List<ShipmentType>)model.get("shipmentTypes");
		//set body
		setBody(sheet,shipmentTypes);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("Enable");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("Dsc");
	
	}
	private void setBody(Sheet sheet, List<ShipmentType> ShipmentTypes) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(ShipmentType s:ShipmentTypes) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getMode());
			row.createCell(2).setCellValue(s.getCode());
			row.createCell(3).setCellValue(s.getEnabled());
			row.createCell(4).setCellValue(s.getGrade());
			row.createCell(5).setCellValue(s.getDsc());
			
		}
		
	}
		
	}

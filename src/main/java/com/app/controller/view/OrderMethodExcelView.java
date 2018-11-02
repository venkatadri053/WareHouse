package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//file name Change
		response.addHeader("Content-Disposition","attachment;filename=OrderMethod.xlsx");
		//create sheet with name
		Sheet sheet=workbook.createSheet("OrderMethods");
		//createHead
		setHead(sheet);
		//read data
		@SuppressWarnings("unchecked")
		List<OrderMethod> orderMethods=(List<OrderMethod>)model.get("orderMethods");
		//set body
		setBody(sheet,orderMethods);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ACCEPT");
		row.createCell(4).setCellValue("DSC");
	
	}
	private void setBody(Sheet sheet, List<OrderMethod> orderMethods) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(OrderMethod o:orderMethods) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(o.getId());
			row.createCell(1).setCellValue(o.getMode());
			row.createCell(2).setCellValue(o.getCode());
			row.createCell(3).setCellValue(o.getAccept().toString());
			row.createCell(4).setCellValue(o.getDsc());
			
		}
		
	}
		
	}

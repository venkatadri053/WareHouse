package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//file name Change
		response.addHeader("Content-Disposition","attachment;filename=WhUserType.xlsx");
		//create sheet with name
		Sheet sheet=workbook.createSheet("WhUserTypes");
		//createHead
		setHead(sheet);
		//read data
		@SuppressWarnings("unchecked")
		List<WhUserType> whUserTypes=(List<WhUserType>)model.get("whUserTypes");
		//set body
		setBody(sheet,whUserTypes);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("USER TYPE");
		row.createCell(2).setCellValue("USER CODE");
		row.createCell(3).setCellValue("USER FOR");
		row.createCell(4).setCellValue("USER EMAIL");
		row.createCell(5).setCellValue("USER CONTACT");
		row.createCell(6).setCellValue("USER IDTYPE");
		row.createCell(7).setCellValue("IFOTHER");
		row.createCell(8).setCellValue("IDNUM");

	}
	private void setBody(Sheet sheet, List<WhUserType> whUserTypes) {
		int rowNum=1;
		for(WhUserType w:whUserTypes) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(w.getId());
			row.createCell(1).setCellValue(w.getUserType());
			row.createCell(2).setCellValue(w.getUserCode()+"");
			row.createCell(3).setCellValue(w.getUserFor());
			row.createCell(4).setCellValue(w.getUserEmail());
			row.createCell(5).setCellValue(w.getUserContact());
			row.createCell(6).setCellValue(w.getUserIdType());
			row.createCell(7).setCellValue(w.getIfOther());
			row.createCell(8).setCellValue(w.getIdNum());

		}

	}

}

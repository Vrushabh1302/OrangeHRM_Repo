package com.OrangeHRM.TestCases;

import java.io.FileInputStream;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xle_FileReader {

	public static void main(String[] args) throws Exception {
		
		FileInputStream path=new FileInputStream("F:\\Program Workspace\\Selenium\\MavanProject\\src\\main\\resources\\Book1.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(path);
        
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		   Iterator<Row> rows=sheet.rowIterator();	
		   
		      while(rows.hasNext()) {
		    	  Row rows1=rows.next();
		    	  Iterator<Cell> cell=rows1.cellIterator();
		    	  
		    	while (cell.hasNext()) {
		    		Cell cell1= cell.next();
		    		
		    		
		    		switch(cell1.getCellType()) {
		      		case NUMERIC : 
		      			 System.out.println((cell1.getNumericCellValue()));
		      		break;
		      		case BOOLEAN : 
		      			 System.out.println((cell1.getBooleanCellValue()));
		      			break;
		      		case STRING : 
		      			System.out.println((cell1.getStringCellValue()));
		      			break;
		      		}
		    	}
		    	
		    	 }
		      }
	
	}



package com.qa.testdriven;

import com.qa.excel.utility.Xls_Reader1;

public class ExcelOperations {

	public static void main(String[] args) {
		Xls_Reader1 reader = new Xls_Reader1("F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\testdata\\TestDataDriven.xlsx");
	    if(!reader.isSheetExist("Homepage"))
	    {
	    	reader.addSheet("Homepage");
	    }
         int totalcolumncount = reader.getColumnCount("Sheet1");
         System.out.println(totalcolumncount);
         
         
	}

}

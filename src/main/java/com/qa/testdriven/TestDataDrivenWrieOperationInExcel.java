package com.qa.testdriven;

import com.qa.excel.utility.Xls_Reader1;

public class TestDataDrivenWrieOperationInExcel {

	public static void main(String[] args) {
		Xls_Reader1 reader = new Xls_Reader1("F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\testdata\\TestDataDriven.xlsx");
	    int rowCount = reader.getRowCount("Sheet1");
	    reader.addColumn("Sheet1", "Status");
	    reader.addSheet("Sheet2");
	   
	  for(int row=2;row<=rowCount;row++)
	    {
	    	reader.setCellData("Sheet1", "Status", row, "Pass");
	    }

	}

}

package com.qa.excel.utility;

import java.util.ArrayList;

import com.qa.testdriven.TestDrivenParameterize;

public class GetDataFromExcel {
	static Xls_Reader1 reader;
	
	public static ArrayList<Object[]> readDataFromExcel()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
		reader = new Xls_Reader1("F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\testdata\\TestDataDriven.xlsx");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 for(int row=2;row<=reader.getRowCount("Sheet1") ;row++)
		    {
		    	String firstName = reader.getCellData("Sheet1", "firstname", row);
		    	System.out.println(firstName);
		    	
		    	String lastName = reader.getCellData("Sheet1", "lastname", row);
		    	System.out.println(lastName);
		    	
		    	String emailAddress = reader.getCellData("Sheet1", "emailaddress", row);
		    	System.out.println(emailAddress);
		    	
		    	String password = reader.getCellData("Sheet1", "password", row);
		    	System.out.println(password);
		    	
		    	Object ob[] = {firstName,lastName,emailAddress,password};
		    	mydata.add(ob);
	}

		 return mydata;
}
}

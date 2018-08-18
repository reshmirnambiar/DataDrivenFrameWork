package com.qa.webtablehandle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.excel.utility.Xls_Reader1;

public class WebTableHandle {
	 

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");	
		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_CompanyName = "]/td[1]";
		String afterXpath2_Contact = "]/td[2]";
		String afterXpath3_Country = "]/td[3]";
		//*[@id="customers"]
		List<WebElement> rows  = driver.findElements(By.xpath("//table[@id = 'customers']//tr"));
		int rowCount = rows.size();
		System.out.println("Row size is:" +rowCount);
		
		Xls_Reader1 reader = new Xls_Reader1("F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\testdata\\TestDataDriven.xlsx");
		
		if(!reader.isSheetExist("Webtable3"))
		{
		reader.addSheet("Webtable3");
		reader.addColumn("Webtable3", "Company");
		reader.addColumn("Webtable3", "Contact");
		reader.addColumn("Webtable3", "country");
		}

		for(int i = 2;i<=rowCount;i++)
		{
		String actualXpath_CompanyName = beforeXpath+i+afterXpath_CompanyName;
		String actualXpath2_Contact = beforeXpath+i+afterXpath2_Contact;
		String actualXpath3_Country = beforeXpath+i+afterXpath3_Country;
		String companyName = 	driver.findElement(By.xpath(actualXpath_CompanyName)).getText();
		String contact = 	driver.findElement(By.xpath(actualXpath2_Contact)).getText();
		String country = driver.findElement(By.xpath(actualXpath3_Country)).getText();
		
		
		reader.setCellData("Webtable3", "Company", i, companyName);
		reader.setCellData("Webtable3", "Contact", i, contact);
		reader.setCellData("Webtable3", "country", i, country);

		System.out.println(companyName);
		System.out.println(contact);
		System.out.println(country);
	
		}
		
		
		
		
		
		
		
	
	}

}

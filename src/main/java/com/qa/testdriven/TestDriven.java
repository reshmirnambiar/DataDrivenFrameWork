package com.qa.testdriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.excel.utility.Xls_Reader1;

public class TestDriven {

	public static void main(String[] args) {
	    Xls_Reader1 reader = new Xls_Reader1("F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\testdata\\TestDataDriven.xlsx");
		String firstName =  reader.getCellData("Sheet1", "firstname",2);
		System.out.println(firstName);
		
		String lastName =  reader.getCellData("Sheet1", "lastname",2);
		System.out.println(lastName);
		
		String emailAddress =  reader.getCellData("Sheet1", "emailaddress",2);
		System.out.println(emailAddress);
		
		String password =  reader.getCellData("Sheet1", "password",2);
		System.out.println(password); 

		
	  System.setProperty("webdriver.chrome.driver","F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\driver\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  WebDriverWait wait  = new WebDriverWait(driver,2);
	  driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
	  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
	  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
	  driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(password);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id = 'ppaFormSbtBtn']"))).click();
	  
	  

	  
	  
	  
	}

}

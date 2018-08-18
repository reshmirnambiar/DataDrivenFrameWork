package com.qa.dataProviderTestNg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.excel.utility.GetDataFromExcel;

public class DataProviderTestNg {
WebDriver driver;

	
@BeforeMethod
public void Setup()
{
	System.setProperty("webdriver.chrome.driver","F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\driver\\chromedriver.exe");
 	driver = new ChromeDriver();
 	driver.manage().window().maximize();
 	driver.manage().deleteAllCookies();
 	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
 	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
 	driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
 	
 }

@DataProvider
public Iterator<Object[]> getData()
{
	ArrayList<Object[]> testData = GetDataFromExcel.readDataFromExcel();
	return testData.iterator();
}

@Test(dataProvider = "getData")
public void ebayRegistration(String firstName,String lastName,String emailAddress,String password)
{
	 driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
  	 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
  	 driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
  	 driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(password);
}

@AfterMethod
public void tearDown()
{
	driver.quit();
}
}

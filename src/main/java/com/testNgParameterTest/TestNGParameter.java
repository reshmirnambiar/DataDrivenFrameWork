package com.testNgParameterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameter {
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void Setup(String browser)
	{
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\driver\\chromedriver.exe");
	 	driver = new ChromeDriver();
		}else if(browser.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\driver\\gecko.exe");
		 	driver = new FirefoxDriver();
		}
			
	 	driver.manage().window().maximize();
	 	driver.manage().deleteAllCookies();
	 	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	 	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 	 	
	 }
	
	
	@Test
	@Parameters({"url","emailID"})
	public void yahooLogin(String url,String emailID)
	{
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='login-username']")).clear();
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailID);
		driver.findElement(By.xpath("//input[@name = 'signin' ]")).click();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	


}

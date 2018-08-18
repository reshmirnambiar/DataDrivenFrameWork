package com.testNgParameterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\eclipse-workspace1\\DataDrivenFrameWork\\src\\main\\java\\com\\qa\\driver\\chromedriver.exe");
	 	ChromeDriver driver = new ChromeDriver();
	 	driver.get("https://login.yahoo.com/");
	 	driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("test123@yahoo.com");
	}

}

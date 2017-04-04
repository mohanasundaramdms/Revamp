package com.ondemandsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class IniateOndemand
{
	public WebDriver driver;
	@BeforeTest
	public void preCondition()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\vid\\WorkSpace\\Revamp\\exe\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://192.168.122.124/FEVRevAmp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
		
	@Test
	public void ondemandSession() throws InterruptedException
	{
		WebElement un = driver.findElement(By.id("USER_NAME"));
		un.clear();
		un.sendKeys("teststudent01");
		WebElement pw = driver.findElement(By.id("Password"));
		pw.clear();
		pw.sendKeys("123");
		driver.findElement(By.xpath("//input[@class='btn btn-primary pull-right']")).click();
		Thread.sleep(10000);
	}
	
	@AfterTest
	public void postCondition(){
		driver.quit();
	}
	
}

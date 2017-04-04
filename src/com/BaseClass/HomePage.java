package com.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy(xpath="//span[text()='On-Demand Session']")
	private WebElement clickOnDemandSession;
	
	@FindBy(xpath="//span[text()=' Logout']")
	private WebElement clickLogout;
	
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement tutorLogout;
	
	public void clickTutorLogout(){
		waitAndClick(tutorLogout);
	}
	
	public void clickLogout(){
		waitAndClick(clickLogout);
	}
	
	public void clickOnDemand(){
		waitAndClick(clickOnDemandSession);
	}
	public void alert(){
		driver.switchTo().alert().accept();
	}
	
}

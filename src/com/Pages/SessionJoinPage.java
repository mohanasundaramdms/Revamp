package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.BaseClass.HomePage;

public class SessionJoinPage extends HomePage{

	public SessionJoinPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[text()='Please click to go back to Dashboard']")
	private WebElement dashboardlink;
	
	public void goToDashboard(){
		dashboardlink.click();
	}

	
}

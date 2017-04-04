package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.BaseClass.HomePage;

public class LoginPage extends HomePage
{
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(id="USER_NAME")
	private WebElement userID;
	
	@FindBy(id="Password")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@class='btn btn-primary pull-right']")
	private WebElement login;
	
	
	public void login(String id, String pw){
		userID.clear();
		userID.sendKeys(id);
		pwd.click();
		pwd.sendKeys(pw);
		login.click();
		
	}
}

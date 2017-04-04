package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.BaseClass.HomePage;

public class DashboardPage extends HomePage{
	
	

	public DashboardPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//td[contains(text(),'Testing_dont_pick')]/../td[12]/input[@id='btnJoinNow']")
	private WebElement clicButton;
	
	@FindBy(xpath="(//input[@class='btn btn-warning'])[1]")
	private WebElement clickGoOnline;
	
		public void clickJoinNowButton(){
		waitAndClick(clicButton);
	}
	
	public void clickButton(String question){
		String xpath = "//td[contains(text(),'"+question+"')]/../td[12]/input[@id='btnJoinNow']";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickGoOnlineButton(){
		waitAndClick(clickGoOnline);
	}



	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

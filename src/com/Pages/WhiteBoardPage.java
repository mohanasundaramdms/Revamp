package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.BaseClass.HomePage;

public class WhiteBoardPage extends HomePage{

	public WhiteBoardPage(WebDriver driver) {
		super(driver);
		}

	@FindBy(id="btnHighlighter")
	private WebElement clickHighlighter;
	
	@FindBy(xpath="div[text()='Welcome']")
	private WebElement verifyChat;
	
	public void verifyChat(){
		String text = waitAndVerify(verifyChat);
		Assert.assertEquals("Welcome", text);
	}
	
	public void clickHighLighter(){
		waitAndClick(clickHighlighter);
	}
}

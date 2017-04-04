package com.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	public WebDriver driver;
	  public WebDriverWait wait;
	  
 
	  public BasePage(WebDriver driver){
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
		  wait = new WebDriverWait(driver, 60);
	  }
	  
	  public void waitAndClick(WebElement element)
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		  element.click();
	  }
	  public String waitAndVerify(WebElement element)
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		  String chat = element.getText();
		  return chat;
				  
	  }
	  
	  public void waitForPageLoad(WebElement element){
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		  
	  }
	  
	  
}

package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.BaseClass.HomePage;
import com.Utility.Utility;

public class OnDemandSessionPage extends HomePage{

	public OnDemandSessionPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="ddlLayer2")
	private WebElement selectSubject;
	
	@FindBy(id="ddlLayer3")
	private WebElement selectCourse;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	private WebElement enterQuestion;
	
	@FindBy(id="btnSubmit")
	private WebElement btnSubmit;
	
	public void clickSubmit(){
		btnSubmit.click();
	}
	
	public void setQuestion(String question){
		enterQuestion.sendKeys(question);
	}
	
	public void selectCourse(){
		Utility.selectValueFromListBox(selectCourse, "4" );
	}
	
	public void selectSubject(){
		Utility.selectValueFromListBox(selectSubject, "2" );
	}

}

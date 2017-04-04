package com.Scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.SessionJoinPage;
import com.Utility.Utility;

public class VerifyPickSessionFromTutor extends BaseTest{
	
	@Test
	public void pickSession() throws InterruptedException{
		LoginPage l=new LoginPage(driver);
		int x= Utility.getExcelRowCount(INPUT_PATH, "AddTutor");
		for(int i=1; i<x; i++){
			String un = Utility.getExcelCellValue(INPUT_PATH, "AddTutor", i, 0);
			String pw = Utility.getExcelCellValue(INPUT_PATH, "AddTutor", i, 1);
			String questions = Utility.getExcelCellValue(INPUT_PATH, "Question", i, 0);
			l.login(un, pw);
			Thread.sleep(5000);
			DashboardPage dbp=new DashboardPage(driver);
			Thread.sleep(5000);
			dbp.clickGoOnlineButton();
			Thread.sleep(10000);
			dbp.clickButton(questions);
			Reporter.log(questions + "Picked by" + un, true);
			Thread.sleep(10000);
			
			Object[] currentWindow = driver.getWindowHandles().toArray();
			String pWindow = currentWindow[0].toString();
			String cWindow = currentWindow[1].toString();
			System.out.println(currentWindow);
			driver.switchTo().window(cWindow);
			driver.close();
			Reporter.log("Child Window is closed", true);
			driver.switchTo().window(pWindow);
			
			Reporter.log("Switch is done to Parent window", true);
			SessionJoinPage sjp=new SessionJoinPage(driver);
			sjp.goToDashboard();
			Thread.sleep(2000);
			
			dbp.clickTutorLogout();
			dbp.alert();
			
			Thread.sleep(5000);
			
	}
	
}

}

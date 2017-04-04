package com.Scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.OnDemandSessionPage;
import com.Pages.SessionJoinPage;
import com.Utility.Utility;

public class VerifyJoinSession extends BaseTest {

	@Test(priority=1)
	public void iniateOndemandSession() throws InterruptedException
	{
		
		LoginPage l=new LoginPage(driver);
		int x= Utility.getExcelRowCount(INPUT_PATH, "AddStudent");
		for(int i=1; i<x; i++){
			String un = Utility.getExcelCellValue(INPUT_PATH, "AddStudent", i, 0);
			String pw = Utility.getExcelCellValue(INPUT_PATH, "AddStudent", i, 1);
			String questions = Utility.getExcelCellValue(INPUT_PATH, "Question", i, 0);
			l.login(un, pw);
			Thread.sleep(5000);
			DashboardPage dbp=new DashboardPage(driver);
			dbp.clickOnDemand();
			Thread.sleep(2000);
			OnDemandSessionPage osp=new OnDemandSessionPage(driver);
			osp.selectSubject();
			osp.selectCourse();
			osp.setQuestion(questions);
			osp.clickSubmit();
			Reporter.log(questions+ "Scheduled", true);
			dbp.clickLogout();
			dbp.alert();
			Thread.sleep(5000);
}
}
	
	@Test(priority=2)
	public void pickSession() throws InterruptedException{
		LoginPage l=new LoginPage(driver);
		int x= Utility.getExcelRowCount(INPUT_PATH, "AddTutor");
		for(int i=1; i<x; i++){
			String un = Utility.getExcelCellValue(INPUT_PATH, "AddTutor", i, 0);
			String pw = Utility.getExcelCellValue(INPUT_PATH, "AddTutor", i, 1);
			String questions = Utility.getExcelCellValue(INPUT_PATH, "Question", i, 0);
			l.login(un, pw);
			Thread.sleep(3000);
			DashboardPage dbp=new DashboardPage(driver);
			//Thread.sleep(2000);
			dbp.clickGoOnlineButton();
			Thread.sleep(6000);
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
			Thread.sleep(2000);
			
			sjp.clickTutorLogout();
			dbp.alert();
			
			Thread.sleep(5000);
			
	}
	
}
}

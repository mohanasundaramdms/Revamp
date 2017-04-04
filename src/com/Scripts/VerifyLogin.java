package com.Scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.OnDemandSessionPage;
import com.Utility.Utility;

public class VerifyLogin extends BaseTest
{

	@Test
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
}

package com.Utility;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Utility 
{
	
	
	public static String getFormatedDateTime(){
		SimpleDateFormat simpleDate = new SimpleDateFormat("M/dd/yyyy hh:mm:ss");
		return simpleDate.format(new Date());
	}
	
	public static String selectValueFromListBox(WebElement element, String value){
		Select select=new Select(element);
		select.selectByValue(value);
		//select.selectByVisibleText(value);
		return value;
	}
	public static int getExcelRowCount(String path,String sheet)
	{
		int r=0;
		try{
			
			r=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	
	public static String getExcelCellValue(String path,String sheet,int r,int c)
	{
		String v="";
		try{
			
			v=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	
	
	public static boolean switchBrowser(WebDriver driver, String eTitle)
	{
		
		String currentWH = "";
		try
		{
			currentWH = driver.getWindowHandle();
		}
		catch (Exception e)
		{
			Reporter.log("Current Window not found", true);
		}
		Set<String> allWH = driver.getWindowHandles();
		for (String wh : allWH)
		{
			String title = driver.switchTo().window(wh).getTitle();
			if(title.equals(eTitle))
			{
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		return false;
	}
	
}

package com.TestNG.TestCases;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.CommonComponents.Objects;

public class LoginTest 
{
  @Test(dataProvider="getLoginCredentials")
  public void loginTest(String usernameFromExcel, String passwordFromExcel) throws InvalidFormatException, IOException 
  {
	  Objects.pl.LoginToApp(usernameFromExcel, passwordFromExcel);
		String expected = "Open Tasks";
		String actual = Objects.driver.findElement(By.xpath("//tr/td[contains(text(),'Open Tasks')]")).getText();
		Assert.assertEquals(actual, expected);
  }
  
  @DataProvider
  public Object[][] getLoginCredentials() throws InvalidFormatException, IOException
  {
	  int rowCount = Objects.el.getRowCount("Sheet1");
	  int colCounnt = Objects.el.getCellCount("Sheet1");
	  int startFrom=0;
	  for(int i=0;i<colCounnt;i++)
	  {	
		  String tabName = Objects.el.getExcelInput("Sheet1", 0, i);
		  if(tabName.equals("UserName"))
		  {
			  startFrom = i;
			  break;
		  }
	  }
	  int s = startFrom;
	  Object[][] data = new Object[rowCount][s];
	  for(int r=1; r<=rowCount;r++)
	  {
		  String usernameFromExcel = Objects.el.getExcelInput("Sheet1", r, s);
		  System.out.println(usernameFromExcel);
		  String passwordFromExcel = Objects.el.getExcelInput("Sheet1", r, s+1);
		  System.out.println(passwordFromExcel);
		  data[r-1][0]=usernameFromExcel;
		  data[r-1][1]=passwordFromExcel;
	  }
	  return data;
  }
}


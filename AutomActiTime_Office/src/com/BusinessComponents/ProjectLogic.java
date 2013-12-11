package com.BusinessComponents;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import com.CommonComponents.Objects;


public class ProjectLogic {

	public boolean status = false;
	
	public void ScreenShots() throws IOException{
		File srcFile = Objects.efwd.getScreenshotAs(OutputType.FILE);
		File destDir = new File("F:\\Selenium Materials\\Study Materials\\workspace\\workspace\\AutomActiTime_Office\\ScreenShots");
		FileUtils.copyFileToDirectory(srcFile, destDir);
	}
	
	public boolean LoginToApp(String username, String password) throws IOException{
		try{
		Objects.driver.get("http://ingbtcpic2dtmk7/login.do");
		Objects.driver.manage().window().maximize();
		Objects.login.getUsr().sendKeys(username);
		Objects.login.getPswd().sendKeys(password);
		Objects.login.getLoginBtn().click();
		Objects.cl.waitToPageLoad();
		String expected = "Open Tasks";
		String actual = Objects.driver.findElement(By.xpath("//tr/td[contains(text(),'Open Tasks')]")).getText();
		Assert.assertEquals(actual, expected);
		status = true;
		//return status;
		}
		catch(Throwable t)
		{	
			Objects.pl.ScreenShots();
			Logger.getLogger(ProjectLogic.class);
			Objects.log.error("Login Failed");
			
			status = false;
		}
		return status;	
	}

}

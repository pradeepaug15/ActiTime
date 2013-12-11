package com.CommonComponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.BusinessComponents.ProjectLogic;
import com.PageFactory.LoginPageXpaths;
import com.TestData.ExcelInput;

public class Objects {
		public static WebDriver driver = new FirefoxDriver();
		public static ProjectLogic pl = new ProjectLogic();
		public static LoginPageXpaths login = PageFactory.initElements(driver, LoginPageXpaths.class);
		public static ExcelInput el = new ExcelInput();
		public static Common_Components cl = new Common_Components();
		public static Logger log = Logger.getLogger(Objects.class);
		public static EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
}

package com.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageXpaths {
	
	@FindBy (name="username")
	private WebElement usr;
	
	@FindBy (name="pwd")
	private WebElement pswd;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getUsr() {
		return usr;
	}

	public WebElement getPswd() {
		return pswd;
	}
	

}

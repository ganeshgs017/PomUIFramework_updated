package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.Basetest;

public class LoginPage  extends Basetest{

	@FindBy(id = "modalusername")
	WebElement username;

	@FindBy(name = "current-password")
	WebElement password;

	@FindBy(xpath = "//span[text()='Log in']")
	WebElement login;

	public void setuserName(String user) {

		//username.sendKeys(user);
		typeText(username,user);
		
	}

	public void setpassWord(String pass) {

		//password.sendKeys(pass);
		typeText(password,pass);
	}

	public void clickLogin() {

		//login.click();
		clickAction(login);
		
	
	}

}

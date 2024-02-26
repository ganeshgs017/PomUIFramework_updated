package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.Basetest;

public class SignupPage extends Basetest {

	@FindBy(name = "email")
	WebElement userEmail;

	@FindBy(name = "new-password")
	WebElement userPassword;

	@FindBy(xpath = "//span[text()='Sign up for free']")
	WebElement usersignup;
	
	@FindBy(id ="modal_first_name")
	WebElement addfirstname;
	
	@FindBy(id = "modal_last_name")
	WebElement addlastname;
	
	@FindBy(xpath= "//span[text()='Continue']")
	WebElement continuebtn;

	public void enterEmail(String email) {

		//userEmail.sendKeys(email);
		typeText(userEmail,email);
	}

	public void enterPasword(String password) {

		//userPassword.sendKeys(password);
		typeText(userPassword,password);

	}

	public void signbtn() {

		jsClick(usersignup);
		//usersignup.click();
		//clickAction(usersignup);
	}


	public void addFirstName(String fname) {
		
		
		clickAction(addfirstname);
		//addfirstname.sendKeys(fname);
		typeText(addfirstname,fname);
	}

     public void addLastName(String lname) {
    	 
    	
    	 clickAction(addlastname);
    	// addlastname.sendKeys(lname);
    	 typeText(addlastname,lname);
     }
	
     public void continueButton() {
    	 
    	 //continuebtn.click();
    	 
    	 clickAction(continuebtn);
     }












}


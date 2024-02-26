package com.w3schools.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.w3schools.pages.SignupPage;
import com.w3schools.utils.Reports;

public class SignupTest extends SignupPage{
	
	Reports report = new Reports();
	
	@Test
	public void signUptest() {
		
		
		try {
			//losdosd9owkdpw
			//ifjiorjfirjgtio
			report.setTestCaseDesc("Validating the Test cases");
			
			launchBrowser("https://profile.w3schools.com/sign-up");
			
			SignupPage signup = PageFactory.initElements(driver, SignupPage.class);
			
			signup.enterEmail("ganeshafs393@gmail.com");
			Thread.sleep(3000);
			
			signup.enterPasword("Ganeshafs@123");
			Thread.sleep(1000);
			
			signup.signbtn();		
			Thread.sleep(4000);
			
			
			signup.addFirstName("Suresh");
			Thread.sleep(4000);
			
			signup.addLastName("s");
			Thread.sleep(4000);
			
			signup.continueButton();
			
		}
	catch(Exception ex) {
		
		ex.printStackTrace();
		
	}
	}

}

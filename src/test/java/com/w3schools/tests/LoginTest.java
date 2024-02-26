package com.w3schools.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w3schools.pages.LoginPage;
import com.w3schools.utils.Reports;

@Listeners(Reports.class)
public class LoginTest extends LoginPage {
	
	Reports report = new Reports();
	
	@Test
	public void loginW3School() {
		
		try {
			
			
			report.setTestCaseDesc("Validating the Test cases");
			
			launchBrowser("https://profile.w3schools.com/log-in");	
			
			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
			
			loginpage.setuserName("ganeshgsbusiness@gmail.com");
			
			loginpage.setpassWord("Ganeshafs@111");
			
			loginpage.clickLogin();	
			
			Thread.sleep(7000);
			
			String title = "W3schools Pathfinder";
			Assert.assertEquals(driver.getTitle(), title);
		
		}
		
		catch(Exception ex)
		{
			
			System.out.print("Problem while executing the test case");
			ex.printStackTrace();
		}
	}

}

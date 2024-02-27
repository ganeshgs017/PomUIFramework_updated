package com.w3schools.utils;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	

	public static WebDriver driver = null;

	public void launchBrowser(String url) {

		try {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get(url);
			Reports.reportStep("PASS","Browser launched successfully with " + url);
		} catch (Exception ex) {

			Reports.reportStep("FAIL","Problem While Launching the browser"+ url);
			ex.printStackTrace();
		}
	}

	public void typeText(WebElement ele, String text) {

		try {
			
		
		ele.sendKeys(text);
		Reports.reportStep("PASS","The given " +text+ " was entered successfully to the "+ele);
	}
        catch(Exception ex) {
        	Reports.reportStep("FAIL","The given " +text+ "was not entered successfully to the "+ele);
        	ex.printStackTrace();
        }
        }
	public void clickAction(WebElement ele) {

		try {
			
			ele.click();
			Reports.reportStep("PASS","The "  + ele.getText() + " was clicked successfully");
			
		} catch (Exception e) {
			Reports.reportStep("FAIL","The" +ele.getText()+ "wasn't clicked successfully");
		
			e.printStackTrace();
		}
	}

	public void waitForElement(WebElement ele) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			Reports.reportStep("PASS","The" +ele.getText()+ " waited successfully to meet the expected conditions");
		} catch (Exception e) 
		
		{	
		Reports.reportStep("FAIL","Problem while Waiting for The" +ele.getText()+ "to meet the expected conditions");	
			e.printStackTrace();
		}

	}

	public void pollingWait(WebElement ele) {
		try {
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofNanos(30)).pollingEvery(Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOf(ele));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			
			Reports.reportStep("PASS","The" +ele.getText()+ " waited successfully to meet the expected conditions");
		}
		catch (Exception e) {
			Reports.reportStep("FAIL","Problem while Waiting for The" +ele.getText()+ "to meet the expected conditions");	

			e.printStackTrace();
		}
		
	}

	public void selectDDbyvalue(WebElement ele, String value) {
		
		try {
			Select sel = new Select(ele);
			sel.selectByValue(value);
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	public void selectDDbyindex(WebElement ele, int index ) {
		
		try {
			Select sel = new Select(ele);
			sel.selectByIndex(index);
		} 
		catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	
	public void selectDDbyvisibletext(WebElement ele,String VisibeText){
		
	    try {
			Select sel = new Select(ele);
			sel.deselectByVisibleText(VisibeText);
		} 
	    catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	public void alertaccept() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	
	public void alertdismiss() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} 
		catch (Exception e) {
	
			e.printStackTrace();
		}		
	}
	
	public void alertgetText() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.getText();
		}
		catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	
	
	public void moveTo(WebElement ele) {
		
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void rightClick(WebElement ele) {
		
		try {
			Actions action = new Actions(driver);
			action.moveToElement(ele).contextClick().build().perform();
		} 
		catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	public void draganddrop(WebElement source, WebElement target) {
		
		try {
			Actions action = new Actions(driver);
			action.dragAndDrop(source, target);
		}
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void doubleclick(WebElement ele) {
		
		try {
			Actions action = new Actions(driver);
			action.doubleClick(ele).build().perform();
		}
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void clickandHold(WebElement ele) {
		
		try {
			Actions action = new Actions(driver);
			action.clickAndHold(ele).build().perform();
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void clickandholdMovetoelement(WebElement source, WebElement target) {
		
		try {
			Actions action = new Actions(driver);
			action.clickAndHold(source).moveToElement(target).build().perform();
		}
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	public boolean verifyenabled(WebElement ele) {
				
		boolean retvalue = false;
			
		try 
		{
			if(ele.isEnabled()) {
				System.out.println("Pass : Element is Enabled");
				retvalue = true;
				
			}
			else
				System.out.println("failed: Element is not Enabled");
		
		} 
			catch (Exception e) {
		
			e.printStackTrace();
		}
	
			return retvalue;
	}
	
	
	public boolean verifyDisplayed(WebElement ele) {
		
		boolean retvalue = false;
		
		try 
		{
			if(ele.isDisplayed()) {
				System.out.println("Pass : Element is Displayed");
			}

			else
				System.out.println("Failed : Element Is not Displayed");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}  
		return retvalue;
	}
	
	public boolean verifySelected(WebElement ele) {
		
		boolean retvalue = false;
		
		try
		{
			if(ele.isEnabled()) {
				System.out.println("Pass: Element is Selected");
			}
			else 
				System.out.println("Failed : Element is not Selected");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return retvalue;
	}
	
	  public void framebyIndex(int index) {
		  
		 try {
			 
			driver.switchTo().frame(index);
		}
		 
		 catch (Exception e) {
		
			e.printStackTrace();
		}
		 
	  }
	

	  public void framebywebelement(WebElement ele ) {
		  
		  try {
			  
			driver.switchTo().frame(ele);
		} 
		  catch (Exception e) {

			e.printStackTrace();
		}
	  	  
	  }
	
	  public void scrollupandDown(int value) {
		  
		  try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			  jse.executeAsyncScript("window.scrollBy(0," + value + ")");
		} 
		  catch (Exception e) {
		
			e.printStackTrace();
		}
	  }
	public void scrollrightandleft(int value) {
		
		 try {
			 
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			  jse.executeAsyncScript("window.scrollBy(" + value + ", 0)");
		} 
		 catch (Exception e) {
	
			e.printStackTrace();
		}
	  }
		
	public void scrolluptoElement(WebElement ele) {
		
		try {
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(True)", ele);
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
	
	}
	
	public void jsClick(WebElement ele) {
		
		try {
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
		} 
		catch (Exception e) {
	
			e.printStackTrace();
		}
	}

     public void returntitle() {
    	 
    	 try {
    		 
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			 System.out.println(jse.executeScript("return document.title").toString());
		} 
    	 catch (Exception e) {
		
			e.printStackTrace();
		}
    	   	 
     }
	
	 public void screenShotMethod(String ssname) {
		 
		 try {
			 
		 // It will copy the screen to clip board memory
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	 
		 File dest = new File("C:\\Users\\ganes\\OneDrive\\Desktop\\Screenshot\\SeleniumScreenshot_" + ssname + ".png");
	
		// Saves the file in given destinaation
		 FileUtils.copyFile(source, dest);
	 }

        catch(Exception ex) {
        	
        	ex.printStackTrace();
        }

	 }
		 public void windowHandle() {
		
		 try {
			 String parentwindow = driver.getWindowHandle();
		 
			 Set<String>windowHandle = driver.getWindowHandles();
		 for(String adr : windowHandle) {
			 
			 if(!(parentwindow.contains(adr))) {
				 driver.switchTo().window(adr);
			 }
		 System.out.println(adr);
		 }
		 }
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
}

		 public void quitbrowser() {
			 try
			 {
				 driver.quit();
			 }
			catch(Exception ex) {
				ex.printStackTrace();
			}
		 }

		 public void closeBrowser() {
			 try
			 {
			 driver.close();
			 }
		
			 catch(Exception ex)
			 {
				 ex.printStackTrace();
			 }
		 }
}
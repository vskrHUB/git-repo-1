package com.autorabit.templates.analytic;

import static org.junit.Assert.fail;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.rabit.testgen.util.RecorderUtil;

public class AnalyticSettingsTest_test4 {
private EventFiringWebDriver driver;
private RecorderUtil recorderObj= new RecorderUtil();
private String title;
private String assertionData;
private String[] testData = new String[10];
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();
  

  @Before
	    public void setUp() throws Exception {
	    	String path= this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + File.separator;
	    		String package1 = this.getClass().getPackage().getName();
	    		String [] parts= package1.split("\\.");
	    		for (int i = 0; i < parts.length; i++) {
	    		String part = parts[i];
	    		if(parts.length == i) {
	    		path = path + part;
	    		} else {
	    		path = path + part + File.separator;
	    		}
	    		}
	    		driver= recorderObj.Browser("finance.nsw.gov.au",this.getClass().getSimpleName(),path);
	    		recorderObj.setDriver(driver);
	    		driver.manage().window().maximize();

	    	    baseUrl = "https://login.salesforce.com/";
	    	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	  }

  @Test
  public void testAnalyticSettings() throws Exception {

	 try{
		 
	   
		
    try {
    driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
    driver.findElement(By.xpath("//span[@id='userNavLabel']/following::a[text()='Setup']")).click();
    } catch (Exception e) {
		driver.findElement(By.xpath("//a[text()='Setup']")).click();
	}    
	    driver.findElement(By.xpath("//a[text()='Customize']/preceding::img[1]")).click();
	    driver.findElement(By.xpath("//a[text()='Reports & Dashboards']/preceding::img[1]")).click();
	    driver.findElement(By.xpath("//a[text()='Reports and Dashboards Settings']")).click();
	    recorderObj.waitSeconds(3);

	  testData[1]= "Enable Dashboard Finder$#false$#Enable Lightning Report Builder (Beta)$#false";
	    if(!testData[1].equalsIgnoreCase("")){ recorderObj.waitSeconds(1);
	    	 String[] values = testData[1].split("\\$\\#"); recorderObj.waitSeconds(1);
	         for (int i = 0; i < values.length; i=i+2) {
	         	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         try {
	 			
	             WebElement sortCheckBox = driver.findElement(By.xpath("//label[text()[contains(.,'"+values[i]+"')]]/preceding::input[1]")); recorderObj.waitSeconds(1);

	             
	             if(values[i+1].equalsIgnoreCase("True") && !sortCheckBox.isSelected()){ recorderObj.waitSeconds(1);
	             sortCheckBox.click();
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 try {
					driver.switchTo().window("");
					driver.findElement(By.xpath("//input[@title='Yes, Enable Component Snapshots']")).click();
				} catch (NoAlertPresentException e) {
					continue;
				}	
	         	}
	             else if ((values[i+1].equalsIgnoreCase("False") && sortCheckBox.isSelected())) { recorderObj.waitSeconds(1);
	             sortCheckBox.click();
	             }
	            recorderObj.waitSeconds(5);
	         	} catch (NoSuchElementException e) {
	 				recorderObj.logMessage(""+values[i]+": is not available");
	 				verificationErrors.append(""+values[i]+": is not available");
	 				continue;
	 			}
	            }
	    }
	    driver.findElement(By.xpath("//input[@title='Save']")).click();
	 }
	    
	 	 catch (AssertionError e){
			recorderObj.screenshot(e);
			if(e.getMessage().contains("\n")){
				fail(e.getMessage().substring(0, e.getMessage().indexOf("\n")));
				}
				else fail(e.getMessage());
			}
			catch (Exception e){
			recorderObj.screenshot(e);
			if(e.getMessage().contains("\n")){
				fail(e.getMessage().substring(0, e.getMessage().indexOf("\n")));
				}
				else fail(e.getMessage());
			}
  }
		 
	 

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

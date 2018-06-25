package com.whitebread.apps.helper;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;


public class AndroidObject {
	 private static final Log LOG = LogFactory.getLog(AndroidObject.class);
    private static final long DRIVER_WAIT_TIME = 30;
    protected static WebDriverWait wait = null;
    
    protected static AndroidDriver<?> androidDriver;


    protected AndroidObject() {
        AndroidObject.androidDriver = SharedDriver.getAndroidWebDriver();
        AndroidObject.wait = new WebDriverWait(androidDriver, DRIVER_WAIT_TIME);
      
    }

    //checks the visibility of element
    protected WebElement waitForExpectedElement(final By by) {
    	LOG.info("Checking if element is visible of the page");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
  //checks the visibility of all multiple elements
    protected List<WebElement> waitForExpectedElements(final By by) {
    	LOG.info("Checking if elements are visible of the page");
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    
  

}

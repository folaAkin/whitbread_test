package com.whitebread.apps.helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class SharedDriver  extends EventFiringWebDriver{
	 private static final Log LOG = LogFactory.getLog(SharedDriver.class);
	    private static AndroidDriver<WebElement> ANDROID_DRIVER = null;
	    static Properties properties;
	    private static final Thread CLOSE_THREAD = new Thread() {
	    	@Override
	        public void run() {
	        	ANDROID_DRIVER.quit();;
	            
	        }
	    };

	    static {
	    	try {
				properties = Props.loadRunConfigProps();
			} catch (Exception e) {
				LOG.warn(e);
			}
	    	LOG.info("Loading configuration properties file");
	        
				try {
					ANDROID_DRIVER = startAppiumDriver();
				} catch (Exception e) {
					
					LOG.warn(e);
				}
			
	        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	    }

	    private SharedDriver() {
	        super(ANDROID_DRIVER);
	    }

	    
        
	    private static AndroidDriver<WebElement> startAppiumDriver() throws Exception  {
	    	DesiredCapabilities capabilities = null; 
	    	if (properties.getProperty("device").equals("Android")){
	    		 capabilities = getAndroidDesiredCapabilities();	
	    		 LOG.info("Loading android desired capabilities");
	    	}
	    	
	        try {
	        	LOG.info("Starting Appium server");
	            ANDROID_DRIVER = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	        } catch (MalformedURLException e) {
	            LOG.warn(e);
	        
	        
	    }
			return ANDROID_DRIVER;
	    }

	    public static DesiredCapabilities getAndroidDesiredCapabilities() throws Exception{
	    	
	    	
	   
	    	File appDir = new File("src/main/resources/apkFiles");
    	     File app = new File(appDir, "app-debug.apk");
    	     final DesiredCapabilities capabilities = new DesiredCapabilities();
    	     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
    	     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
    	     capabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
    	     capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
    	     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	        return capabilities;
	    }

	    public static AndroidDriver<WebElement> getAndroidWebDriver() {
	        return ANDROID_DRIVER;
	    }

	    @Override
	    public void close() {
	        if (Thread.currentThread() != CLOSE_THREAD) {
	            throw new UnsupportedOperationException(
	                    "WebDriver shouldn't be closed. It's shared and will close when the JVM exits.");
	        }
	        super.close();
	      
	    }

}

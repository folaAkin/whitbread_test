package com.whitbread.apps.page_objects.mobile;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import com.whitebread.apps.helper.SharedDriver;
import com.whitebread.apps.helper.AndroidObject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;




public class CategoryPage extends AndroidObject{
	protected AndroidDriver<?> androidDriver;
	protected WebDriver driver;
	
	private By category1 = By.xpath("//android.widget.TextView[@text='CATEGORY 1']");
	private By cheeessquare = By.xpath("//android.widget.TextView[@text ='Cheesesquare']");
	private By ellipsis = By.className("android.widget.ImageView");
	private By nightModeDropdown =  By.xpath("//android.widget.TextView[@text='Night mode']");
	private By nightAlwaysRadioButton = By.xpath("//android.widget.TextView[@text='Night (always)']");
	private By info = By.xpath("//android.widget.TextView[@text='Info']");
	private By friends = By.xpath("//android.widget.TextView[@text='Friends']");
	private By related = By.xpath("//android.widget.TextView[@text='Related']");
	private By selectCheese = By.xpath("//*[@class='android.widget.TextView' and @index='1']");
	private By allCheeseCategory = By.className("android.widget.TextView");
	
	
	
	    
	public void clickCategory() {
		SharedDriver.getAndroidWebDriver().findElement(category1).click();
	}
	

	    public String getCheeseSquareText() throws InterruptedException {
			return waitForExpectedElement(cheeessquare).getText();

		}
	  
	    
	    public List<String> getAllCheeseCategory() {
			List<String> getAllCheeseCategory = new ArrayList<String>();
			List<WebElement> allCheeseCategories=  waitForExpectedElements(allCheeseCategory);
			for (WebElement element : allCheeseCategories) {
				getAllCheeseCategory.add(element.getText());

			}

			return getAllCheeseCategory;
		}
	    
	    
	    public void selectCheeseInTheList() throws InterruptedException {
	    	List<WebElement>  cheeseList =waitForExpectedElements(selectCheese);
	    	cheeseList.get(1).click();

    }
		
	    
	    
		public void selectEllipsis() {
			waitForExpectedElement(ellipsis).click();

		}

		public void selectNightModeDropdown() {
			waitForExpectedElement(nightModeDropdown).click();
		}

		public void selectNightAlwaysRadioButton() {
			waitForExpectedElement(nightAlwaysRadioButton).click();

		}
		
		public String checkInfoIsDispayed() {
			return waitForExpectedElement(info).getText();

		}
		
		
		public String checkFriendIsDispayed() {
			return waitForExpectedElement(friends).getText();
			

		}
		
		public String checkRelatedIsDispayed() {
			return waitForExpectedElement(related).getText();

		}
		
		
		public void scrollToElement(){
			SharedDriver.getAndroidWebDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                            + "new UiSelector().text(\"Related\"));"));
	
			
		}

}

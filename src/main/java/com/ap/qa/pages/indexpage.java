package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.testbase.TestBase;



public class indexpage extends TestBase{
	@FindBy(css = "img.logo.img-responsive")
	WebElement logoIcon;
	
	@FindBy(className = "login")
	WebElement signin;
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductButton;
	
	
	public indexpage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean  validatelogoiconaction() {
		return logoIcon.isDisplayed();
	}
	
	
	public String validtaeindexpagetitleaction() {
		return driver.getTitle();
		
	}
	
	
	public String validtaeindexpagecurrenttitleaction() {
		return driver.getCurrentUrl();
	
	
}
	
	public  boolean searchProductBoxaction() {
		return (searchProductBox.isDisplayed()&& searchProductBox.isEnabled());
		
	}

	public Searchresultpage searchProductSubmitButtonAction() {
		searchProductBox.sendKeys("t-shirt");
		searchProductButton.click();
		return new Searchresultpage();
	}
	public Loginpage clickonsigninlinkaction() {
		 signin.click();
		 return new Loginpage();
	}
}
	
	
	
	
	
	
	
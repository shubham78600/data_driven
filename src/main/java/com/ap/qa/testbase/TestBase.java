package com.ap.qa.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions options;
	@BeforeTest
	public static void launchConfiguration() throws Throwable {
	
	Properties prop = new Properties();
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\CONFIGURATION\\config.properties");
	prop.load(ip);
	
}
	public static void launchApplication() {
		
	
	String browserName = prop.getProperty("browser");
	options = new ChromeOptions();
	options.setPageLoadStrategy(PageLoadStrategy.EAGER);

	if (browserName.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		options.addArguments("--incognito");
	}else if (browserName.equals("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
	}else if (browserName.equals("edge")){
	WebDriverManager.edgedriver().setup();
	}else {
		
		System.out.println("window not opening");
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		
		
		
		
	}
	
}
	
	
	
	
	
	 


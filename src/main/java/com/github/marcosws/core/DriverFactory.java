package com.github.marcosws.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {
	
	private static WebDriver driver = null;
	public enum Browser{
		CHROME, FIREFOX, IE, OPERA;
	}
	private static Browser currentBrowser;
	
	public static void setNavigator(Browser browser){
		
		String userPath = System.getProperty("user.dir");
		String partialPath = "//src//main//resources//drivers";
		currentBrowser = browser;
		Properties properties = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(userPath + "//src//main//resources//properties//driverfactory.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String ieDriverPath = userPath + partialPath + properties.getProperty("driverfactory.driverpath.ie");
		String firefoxDriverPath = userPath + partialPath + properties.getProperty("driverfactory.driverpath.firefox");
		String chromeDriverPath = userPath + partialPath + properties.getProperty("driverfactory.driverpath.chrome");
		String operaDriverPath = userPath + partialPath + properties.getProperty("driverfactory.driverpath.opera");

		if(browser.equals(Browser.CHROME)){
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
			driver = new ChromeDriver();
		}
		else if(browser.equals(Browser.FIREFOX)){
			System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		else if(browser.equals(Browser.IE)){
			System.setProperty("webdriver.ie.driver",ieDriverPath);
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals(Browser.OPERA)){
			System.setProperty("webdriver.opera.driver",operaDriverPath);
			driver = new OperaDriver();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
			if(currentBrowser.equals(Browser.IE)){
				try{
					Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
					Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
				}
				catch (IOException e) {}
			}
		}
	}

}
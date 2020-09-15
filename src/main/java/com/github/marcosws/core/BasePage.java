package com.github.marcosws.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.marcosws.utils.Common;

public class BasePage {
	
	private WebDriver driver;
	private boolean highLight;

	public void setHighLight(boolean highLight) {
		this.highLight = highLight;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	protected enum Attribute{
		id, className, tagName, xpath, name;
	}
	protected void editElement(Attribute attribute, String value, String text) {
		WebElement webElement = this.loadElement(attribute, value);
		this.highLight(webElement);
		webElement.clear();
		webElement.sendKeys(text);
	}
	protected void clickElement(Attribute attribute, String value) {
		WebElement webElement = this.loadElement( attribute, value);
		this.highLight(webElement);
		webElement.click();
	}
	protected String getTextElement(Attribute attribute, String value) {
		return value;
		
	}
	
	protected boolean waitElement(Attribute attribute, String value) {
		return highLight;
		
	}
	
	protected void executeJavaScript(String script, WebElement webElement, String arguments) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 javascriptExecutor.executeScript(script, webElement, arguments);
	}
	protected void executeJavaScript(String script, WebElement webElement) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		 javascriptExecutor.executeScript(script, webElement);
	}
	/*
	 * Metodos privados
	 */
	
    private void highLight(WebElement webElement) {
    	if(highLight) {
	    	Common common = new Common();
	    	String script = "arguments[0].setAttribute('style', arguments[1]);";
	    	String arguments = "color: white; border: 2px solid rgb(109,254,48); text-shadow: 1px 1px rgb(48,156,1);";
	        for (int i = 0; i < 3; i++) {
	        	this.executeJavaScript(script, webElement, arguments);
	            common.sleep(150);
	            this.executeJavaScript(script, webElement);
	            common.sleep(150);
	        }
    	}
    }
	private WebElement loadElement(Attribute attribute, String value){
		WebElement webElement = null;
		if(attribute.equals(Attribute.id)){
			webElement = driver.findElement(By.id(value));
		}
		else if(attribute.equals(Attribute.className)){
			webElement = driver.findElement(By.className(value));
		}
		else if(attribute.equals(Attribute.tagName)){
			webElement = driver.findElement(By.xpath(value));
		}
		else if(attribute.equals(Attribute.name)){
			webElement = driver.findElement(By.name(value));
		}
		else if(attribute.equals(Attribute.tagName)){
			webElement = driver.findElement(By.tagName(value));
		}
		return webElement;
	}

}

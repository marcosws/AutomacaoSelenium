package com.github.marcosws.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	protected void editElement(Attribute attribute, String value, String text, int index) {
		WebElement webElement = this.loadElement(attribute, value, index);
		this.highLight(webElement);
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	protected void clickElement(Attribute attribute, String value) {
		WebElement webElement = this.loadElement(attribute, value);
		this.highLight(webElement);
		webElement.click();
	}
	
	protected void clickElement(Attribute attribute, String value, int index) {
		WebElement webElement = this.loadElement(attribute, value, index);
		this.highLight(webElement);
		webElement.click();
	}
	protected void selectElement(Attribute attribute, String value, boolean checked) {
		WebElement webElement = this.loadElement(attribute, value);
		this.highLight(webElement);
		if(checked != webElement.isSelected()) {
			webElement.click();
		}
	}
	protected void selectElement(Attribute attribute, String value, boolean checked, int index) {
		WebElement webElement = this.loadElement(attribute, value, index);
		this.highLight(webElement);
		if(checked != webElement.isSelected()) {
			webElement.click();
		}
	}
	
	protected void selectElement(Attribute attribute, String value, String text) {
		Select select = new Select(this.loadElement(attribute, value));
		this.highLight(this.loadElement(attribute, value));
		select.selectByVisibleText(text);
	}
	
	protected void selectElement(Attribute attribute, String value, int itemIndex) {
		Select select = new Select(this.loadElement(attribute, value));
		this.highLight(this.loadElement(attribute, value));
		select.selectByIndex(itemIndex);
	}
	
	protected void selectElement(Attribute attribute, String value, String text, int index) {
		Select select = new Select(this.loadElement(attribute, value, index));
		this.highLight(this.loadElement(attribute, value, index));
		select.selectByVisibleText(text);
	}
	
	protected void selectElement(Attribute attribute, String value, int itemIndex, int index) {
		Select select = new Select(this.loadElement(attribute, value, index));
		this.highLight(this.loadElement(attribute, value, index));
		select.selectByIndex(itemIndex);
	}

	protected boolean ckeckedElement(Attribute attribute, String value) {
		WebElement webElement = this.loadElement(attribute, value);
		this.highLight(webElement);
		return webElement.isSelected();
	}
	protected String getTextElement(Attribute attribute, String value) {
		WebElement webElement = this.loadElement(attribute, value);
		this.highLight(webElement);
		return webElement.getText();
	}
	protected String getValueElement(Attribute attribute, String value) {
		WebElement webElement = this.loadElement(attribute, value);
		this.highLight(webElement);
		return webElement.getAttribute("value");
	}
	
	protected boolean waitElement(Attribute attribute, String value, int timeOutSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,timeOutSeconds);
		WebElement webElement = null;
		try {
			if(attribute.equals(Attribute.id)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
			}
			else if(attribute.equals(Attribute.className)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
			}
			else if(attribute.equals(Attribute.name)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
			}
			else if(attribute.equals(Attribute.tagName)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.tagName(value)));
			}
			else if(attribute.equals(Attribute.xpath)){
				webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
			}
		}
		catch(Exception e) {
			return false;
		}
		return webElement.isDisplayed();
		
	}
	@Deprecated
	protected String dialogBox(boolean confirm, String inputText ,int timeOutSeconds){
		Common common = new Common();
		new WebDriverWait(driver, timeOutSeconds).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys(inputText);
		String textDialogBox = driver.switchTo().alert().getText();
		common.sleep(3000);
		if(confirm){
			driver.switchTo().alert().accept();
		}
		else{
			driver.switchTo().alert().dismiss();
		}
		return textDialogBox;
	}
	@Deprecated
	protected String dialogBox(boolean confirm, int timeOutSeconds){
		Common common = new Common();
		new WebDriverWait(driver, timeOutSeconds).until(ExpectedConditions.alertIsPresent());
		String textDialogBox = driver.switchTo().alert().getText();
		common.sleep(3000);
		if(confirm){
			driver.switchTo().alert().accept();
		}
		else{
			driver.switchTo().alert().dismiss();
		}
		return textDialogBox;
	}
	protected String dialogBox(boolean confirm, String inputText){
		String textDialogBox = "";
		try {
			Common common = new Common();
			driver.switchTo().alert().sendKeys(inputText);
			textDialogBox = driver.switchTo().alert().getText();
			common.sleep(3000);
			if(confirm){
				driver.switchTo().alert().accept();
			}
			else{
				driver.switchTo().alert().dismiss();
			}
		}
		catch(Exception e) {
			return "";
		}
		return textDialogBox;
	}
	protected String dialogBox(boolean confirm){
		String textDialogBox = "";
		try {
			Common common = new Common();
			textDialogBox = driver.switchTo().alert().getText();
			common.sleep(3000);
			if(confirm){
				driver.switchTo().alert().accept();
			}
			else{
				driver.switchTo().alert().dismiss();
			}
		}
		catch(Exception e) {
			return "";
		}
		return textDialogBox;
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
		else if(attribute.equals(Attribute.xpath)){
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
	
	private WebElement loadElement(Attribute attribute, String value, int index){
		List<WebElement> webElements = null;
		if(attribute.equals(Attribute.id)){
			webElements = driver.findElements(By.id(value));
		}
		else if(attribute.equals(Attribute.className)){
			webElements = driver.findElements(By.className(value));
		}
		else if(attribute.equals(Attribute.xpath)){
			webElements = driver.findElements(By.xpath(value));
		}
		else if(attribute.equals(Attribute.name)){
			webElements = driver.findElements(By.name(value));
		}
		else if(attribute.equals(Attribute.tagName)){
			webElements = driver.findElements(By.tagName(value));
		}
		if(webElements.size() > Math.abs(index)) {
			return webElements.get(Math.abs(index));
		}
		else {
			return null;
		}
	}

}

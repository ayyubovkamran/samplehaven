package com.qa.havenlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.havenlife.base.BasePage;

public class ValuesPage extends BasePage {

	private WebDriver driver;

	// 1. By locators -- Object Repository

	public WebElement labelVal1 = driver.findElement(By.id("lbl_val_1"));
	public WebElement labelVal2 = driver.findElement(By.id("lbl_val_2"));
	public WebElement labelVal3 = driver.findElement(By.id("lbl_val_3"));
	public WebElement labelVal4 = driver.findElement(By.id("lbl_val_4"));
	public WebElement labelVal5 = driver.findElement(By.id("lbl_val_5"));
	public WebElement textVal1 = driver.findElement(By.id("txt_val_1"));
	public WebElement textVal2 = driver.findElement(By.id("txt_val_2"));
	public WebElement textVal3 = driver.findElement(By.id("txt_val_3"));
	public WebElement textVal4 = driver.findElement(By.id("txt_val_4"));
	public WebElement textVal5 = driver.findElement(By.id("txt_val_5"));
	public WebElement labelTotalBal = driver.findElement(By.id("lbl_ttl_val"));
	public WebElement textTotalbal = driver.findElement(By.id("txt_ttl_val"));

	// 2. Create constructor of Page Class

	public ValuesPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions

	public void enterValue(WebElement value, String realTimeValue) {
		value.sendKeys(realTimeValue);
	}

	public double getDoubleValue(WebElement value) {
		double doubleValue = Integer.parseInt(value.getText().substring(1));
		return doubleValue;
	}

	public double sumAllValues() {
		double sum = getDoubleValue(textVal1) + getDoubleValue(textVal2) + getDoubleValue(textVal3)
				+ getDoubleValue(textVal4) + getDoubleValue(textVal5);
		return sum;
	}

	public boolean isCurrency(WebElement value) {
		if (value.getText().contains("$")) {
			return true;
		}

		return false;
	}
}

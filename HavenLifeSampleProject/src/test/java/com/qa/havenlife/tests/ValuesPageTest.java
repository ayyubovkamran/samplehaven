package com.qa.havenlife.tests;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.havenlife.base.BasePage;
import com.qa.havenlife.pages.ValuesPage;

public class ValuesPageTest {
	WebDriver driver;
	BasePage basePage;
	ValuesPage valuesPage;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		valuesPage = new ValuesPage(driver);
	}

	// Need to verify the right count of values appear on the screen
	@Test
	public void verifyCountOfValues() {
		List<WebElement> lbl_values = driver.findElements(By.xpath("some xpath for lbl values"));
		List<WebElement> txt_values = driver.findElements(By.xpath("some xpath for txt values"));
		Assert.assertEquals(lbl_values.size(), 6);
		Assert.assertEquals(txt_values.size(), 6);
	}

	// Need to verify the values on the screen are greater than 0
	@Test
	public void verifyValuesGreaterZero() {
		Assert.assertTrue(valuesPage.getDoubleValue(valuesPage.textVal1) > 0);
		Assert.assertTrue(valuesPage.getDoubleValue(valuesPage.textVal2) > 0);
		Assert.assertTrue(valuesPage.getDoubleValue(valuesPage.textVal3) > 0);
		Assert.assertTrue(valuesPage.getDoubleValue(valuesPage.textVal4) > 0);
		Assert.assertTrue(valuesPage.getDoubleValue(valuesPage.textVal5) > 0);
		Assert.assertTrue(valuesPage.getDoubleValue(valuesPage.textTotalbal) > 0);
	}

	// Need to verify the total balance matches the sum of the values

	@Test
	public void verifyTotalBalance() {
		double actualSum = valuesPage.sumAllValues();
		double expectedSum = valuesPage.getDoubleValue(valuesPage.textTotalbal);
		Assert.assertEquals(actualSum, expectedSum);
	}

	// Need to verify the values are formatted as currencies

	@Test
	public void verifyAllValuesFormattedAsCurrency() {
		Assert.assertEquals(valuesPage.isCurrency(valuesPage.textVal1), true);
		Assert.assertEquals(valuesPage.isCurrency(valuesPage.textVal2), true);
		Assert.assertEquals(valuesPage.isCurrency(valuesPage.textVal3), true);
		Assert.assertEquals(valuesPage.isCurrency(valuesPage.textVal4), true);
		Assert.assertEquals(valuesPage.isCurrency(valuesPage.textVal5), true);
		Assert.assertEquals(valuesPage.isCurrency(valuesPage.textTotalbal), true);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

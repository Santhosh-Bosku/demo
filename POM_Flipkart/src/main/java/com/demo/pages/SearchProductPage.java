package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.TestBase;

public class SearchProductPage extends TestBase {

	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	By searchLocator = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
	
		
	public void searchProductPageValidator()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocator));
	}
	
	public String searchProduct(String productName) throws Throwable {
		
		Thread.sleep(5000);
		driver.findElement(searchLocator).sendKeys(productName);
		driver.findElement(searchLocator).sendKeys(Keys.ENTER);;
		String actualResult = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).getAttribute("title");
		System.out.println(actualResult);
		return actualResult;
	}
	
}

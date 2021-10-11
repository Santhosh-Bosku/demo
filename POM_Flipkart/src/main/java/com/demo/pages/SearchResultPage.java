package com.demo.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.TestBase;

public class SearchResultPage extends TestBase {
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	By product = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
	By addCartvalidator = By.className("_2c7YLP UtUXW0 _6t1WkM _3HqJxg");
	
	By price = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div[1]/div[1]/div[1]");
	By Cprice = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[4]/div[1]/div/div[1]");
	public boolean selectProduct() throws Throwable
	{
		String validator = driver.findElement(price).getText();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(product));
		driver.findElement(product).click();
		
		Set<String> stringsSet = new HashSet<String>();
		stringsSet = driver.getWindowHandles();
		List<String> stringsList = new ArrayList<String>(stringsSet);
		System.out.println(stringsList.get(1));
		driver.switchTo().window(stringsList.get(1));
		
		//	Checking addCartPage Lunched 		
		Thread.sleep(5000);
		String Cvalidator = driver.findElement(Cprice).getText();
		System.out.println(validator);
		System.out.println(Cvalidator);
		
		if(validator.equalsIgnoreCase(Cvalidator))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public String sortProduct()
	{
		String validator = null;
		return validator;
	}
	
	public String addToCompare() {
		String validator = null;
		return validator;
	}
}

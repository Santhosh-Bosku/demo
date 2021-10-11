package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.demo.base.TestBase;

public class AddProductToCart extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	By addToCartButton = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button");
	
	By priceInAddtocart = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[4]/div[1]/div/div[1]");
	
	By priceInPlaceorder = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/span[1]");
	
	public boolean addToCart() throws InterruptedException
	{
		System.out.println("a");
		System.out.println(driver.getTitle());
		System.out.println("b");
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
		String validator = driver.findElement(priceInAddtocart).getText();
		driver.findElement(addToCartButton).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(priceInPlaceorder));
		String Cvalidator = driver.findElement(priceInPlaceorder).getText();
		
		System.out.println(validator);
		System.out.println(Cvalidator);
		
		if(validator.equalsIgnoreCase(Cvalidator))
		{
			return true;
		}
		else {
			return false;
		}
	}
}

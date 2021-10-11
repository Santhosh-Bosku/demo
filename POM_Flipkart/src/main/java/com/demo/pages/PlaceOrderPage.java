package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.TestBase;

public class PlaceOrderPage extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	By placeOrder = By.className("_2KpZ6l _2ObVJD _3AWRsL");
	By totalAmount = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/span[1]");
	By totalPayable = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[2]/div/div[1]/div[1]/div[3]/div/span/div/div/div");
		public boolean placeOrder() {
			System.out.println("a");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(placeOrder));
			String validator = driver.findElement(totalAmount).getText();
			driver.findElement(placeOrder).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(totalPayable));
			String Cvalidator = driver.findElement(totalPayable).getText();
			System.out.println("b");
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
}

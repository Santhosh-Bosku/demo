package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.base.TestBase;

public class LoginPage extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver, 50);

	By emailLocator = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	By pwdLocator = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
	By loginButtonLocatory = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button");
	
//	public LoginPage(WebDriver driver){
//		this.driver = driver;
//	}
	
	public String validateLogin(String email, String pwd) throws Throwable {
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailLocator));
		driver.findElement(emailLocator).sendKeys(email);
		driver.findElement(pwdLocator).sendKeys(pwd);
		driver.findElement(loginButtonLocatory).click();
		
		//wait until searchbox is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")));
		Thread.sleep(5000);
		String loginResult = driver.getTitle();
		//System.out.println("Actual Result: " + loginResult);
		
		System.out.println(loginResult+" loginpage");
		
		
		return loginResult;
		
	}
	
	
}

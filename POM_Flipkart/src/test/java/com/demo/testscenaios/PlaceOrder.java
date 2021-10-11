package com.demo.testscenaios;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.base.TestBase;
import com.demo.pages.AddProductToCart;
import com.demo.pages.LoginPage;
import com.demo.pages.SearchProductPage;
import com.demo.pages.SearchResultPage;
import com.demo.pages.PlaceOrderPage;


public class PlaceOrder extends TestBase {
	
	LoginPage loginPage;
	SearchProductPage searchProductPage;
	SearchResultPage searchResultPage;
	AddProductToCart addtoCart;
	PlaceOrderPage placeOrder;
	
	@Test(priority = 0)
	public void launchHomePageTest() {
		driver.get("https://www.flipkart.com/");
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://www.flipkart.com/";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 1)
	public void loginTest() throws Throwable {
		loginPage = new LoginPage();
//		searchProductPage =new SearchProductPage();
		String loginResult = loginPage.validateLogin("9094018902", "RisTha15#f1");
//		searchProductPage.searchProductPageValidator();
		Thread.sleep(3000);
		String actualResult = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actualResult, loginResult);
	
	}
	
	@Test (priority = 2)
	public void searchProductTest() throws Throwable {
		searchProductPage = new SearchProductPage();
		String acutalResult = searchProductPage.searchProduct("laptop");
		String expectedResult = "Search for products, brands and more";
		Assert.assertEquals(acutalResult, expectedResult);
	}
	
	@Test (priority = 3)
	public void selectProductTest() throws Throwable {
		searchResultPage = new SearchResultPage();
		boolean actualResult = searchResultPage.selectProduct();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 4)
	public void addToCartTest() throws InterruptedException {
		addtoCart = new AddProductToCart();
		boolean actualResult = addtoCart.addToCart();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test (priority = 5)
	public void confirmOrderTest() {
		placeOrder = new PlaceOrderPage();
		boolean actualResult = placeOrder.placeOrder();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 6)
	public void makePaymentTest() {
		
	}

	@Test(priority = 7)
	public void logoutTest() {
		
	}

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
	  setupDriver();
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
//	  closeDriver();
	  
  }

}

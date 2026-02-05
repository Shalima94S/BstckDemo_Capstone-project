package tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cartPage;
import pages.loginPage;
import pages.productPage;
public class addToCartTest extends baseTests{ 
    productPage pp;
	loginPage lp;
	cartPage cp;
     @Test
	public void productpageverify() {
        loginPage lp=new loginPage(driver);
		lp.signIn();
		productPage pp=lp.login(" demouser"," testingisfun99");
		pp.verifyloggedinuser("demouser");
		pp.verifyproductpage();
		pp.verifyProductDetails();
		pp.verifyfilter();
	}
	//Add Single item to the cart
	@Test
	public void  TC_004_addsingleproduct() {
		//test = extent.createTest("TC_004_addsingleproduct");
		cartPage cp=new cartPage(driver);
		loginPage lp=new loginPage(driver);
		lp.signIn();
		productPage pp=lp.login(" demouser"," testingisfun99");
		cp.addSingleProductToCart();
		cp.verifysingleproduct();
		String cartnumber=cp.getCartCount();
		System.out.println("Number of items:"+cartnumber);
		
		}
	
	//Add multiple item
	@Test
	public void  TC_005_addmultipleitem() throws InterruptedException {
		//test = extent.createTest("TC_005_addmultipleitem");
		cartPage cp=new cartPage(driver);
		loginPage lp=new loginPage(driver);
		lp.signIn();
		productPage pp=lp.login(" demouser"," testingisfun99");
		String cartnumber=cp.getCartCount();//verify that no item present
		System.out.println("Number of items:"+cartnumber);
		cp.multipleItems(5);
        int cartCount = cp.newCartCount();
        System.out.println("Number of items: " + cp.newCartCount());
		Assert.assertEquals(cartCount, 5, "Cart count is incorrect");
		cp.checkoutpageisVisible();
		cp.deleteAllItemsFromCart();
        cp.verifyCartIsEmpty();
         
        }
	@Test
	public void  TC_006_removeItemfromcart() throws InterruptedException {
		
		cartPage cp=new cartPage(driver);
		loginPage lp=new loginPage(driver);
		lp.signIn();
		productPage pp=lp.login(" demouser"," testingisfun99");
		String cartnumber=cp.getCartCount();
		System.out.println("Number of items:"+cartnumber);
		int cartCount = cp.newCartCount();
		cp.multipleItems(5);
        System.out.println("Number of items: " + cp.newCartCount());
        cp.deleteAllItemsFromCart();
        cp.verifyCartIsEmpty();
        
	
	}}


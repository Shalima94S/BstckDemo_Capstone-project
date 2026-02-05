package tests;
import org.testng.annotations.Test;
import pages.cartPage;
import pages.checkoutPage;
import pages.loginPage;
import pages.productPage;

public class checkoutTest extends baseTests{
	productPage pp;
	loginPage lp;
	cartPage cp;
	checkoutPage checkpage;
	@Test
	public void  TC_007_checkoutpage() throws InterruptedException {
	  //  test = extent.createTest("TC_007_checkoutpage");
		loginPage lp = new loginPage(driver);
        cartPage cp = new cartPage(driver);
        productPage pp=new productPage(driver);
        checkoutPage checkpage = new checkoutPage(driver);
        lp.signIn();
        lp.login(" demouser"," testingisfun99");
        cp.addSingleProductToCart();
        //Checkout page
        cp.openCart();
        checkpage.getCartProductName();
        checkpage.getCartProductPrice();
        checkpage.clickCheckout();
        checkpage.verifyCheckoutUrl();
        checkpage.fillCheckoutForm();
        checkpage.clickSubmit();
        //Confirmation page
        checkpage.verifyConfirmationUrl();
        checkpage.placedordermessage();
        checkpage.fetchOrderNumber();
        checkpage.verifyInvoiceAvailable();
        checkpage.verifySubmitWithEmptyFields();

	}
	//NEGATIVE TEST
@Test
public void  TC_008_emptyfields() throws InterruptedException {
	//test = extent.createTest("TC_008_emptyfields");
	loginPage lp = new loginPage(driver);
    cartPage cp = new cartPage(driver);
    productPage pp=new productPage(driver);
    checkoutPage checkpage = new checkoutPage(driver);
    lp.signIn();
    lp.login(" demouser"," testingisfun99");
    cp.addSingleProductToCart();
    //Checkout page
    cp.openCart();
    checkpage.clickCheckout();
    checkpage.verifySubmitWithEmptyFields();
	
}
}

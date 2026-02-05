package pages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.waitUtils;

public class checkoutPage {
	WebDriver driver;
	waitUtils wait;
	By firstname=By.id("firstNameInput");
	By lastname=By.id("lastNameInput");
	By address=By.id("addressLine1Input");
	By state=By.id("provinceInput");
	By postal=By.id("postCodeInput");
    By submitBtn = By.id("checkout-shipping-continue");
    By cartProductName = By.cssSelector(".shelf-item__details .title");
	By cartProductPrice = By.cssSelector(".shelf-item__price");
	By successMessage = By.xpath("//*[contains(text(),'Order has been successfully placed')]");
    By orderNumber = By.xpath("//*[@id=\"checkout-app\"]/div/div/div/ol/li/div/div/div[2]");
    By downloadInvoiceBtn = By.xpath("//button[contains(text(),'Download')]");
	
public checkoutPage(WebDriver driver) {
	  this.driver=driver;
	  wait = new waitUtils(driver);
}
//Verify the Add to cart product
public String getCartProductName() {
	String productname=driver.findElement(cartProductName).getText();
	System.out.println("Product name is :"+productname);
    return productname;
}
public String getCartProductPrice() {
	String productprice=driver.findElement(cartProductPrice).getText();
	System.out.println("Product price is :"+productprice);
    return productprice;
}
public void clickCheckout() {
    driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div[3]")).click();
    System.out.println("Checkout button clicked");
}
public void verifyCheckoutUrl() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.urlContains("checkout"));
	String currenturl=driver.getCurrentUrl();
	System.out.println("page url is :"+currenturl);
	Assert.assertTrue(currenturl.contains("checkout"),"url verification failed");
	System.out.println("Checkout page URL verified");
 }
public void fillCheckoutForm() {

    wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)) .sendKeys("Meera");
    driver.findElement(lastname).sendKeys("P");
    driver.findElement(address).sendKeys("Bangalore");
    driver.findElement(state).sendKeys("Karnataka");
    driver.findElement(postal).sendKeys("560001");
     System.out.println("Checkout form filled");
}
public void clickSubmit() {
    wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    System.out.println("Checkout form submitted");
}
//CONFIRMATION PAGE

public void verifyConfirmationUrl() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.urlContains("confirmation"));
	String currenturl=driver.getCurrentUrl();
	System.out.println("page url is :"+currenturl);
	Assert.assertTrue(currenturl.contains("confirmation"),"url verification failed");
	System.out.println("Confirmation page URL verified");
    
}
public void placedordermessage() {
	String msg=wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText(); 
	System.out.println("Success Message:"+msg);
	Assert.assertTrue(msg.contains("successfully"),"Order success message not displayed");
}
public String fetchOrderNumber() {

    String orderText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(orderNumber)
    ).getText();
    System.out.println("Your order number is: " + orderText);
    return orderText;
}
public void verifyInvoiceAvailable() {
    boolean isDownloadVisible = driver.getPageSource().contains("Download");
    Assert.assertTrue( isDownloadVisible, "Download Invoice option not available");
    System.out.println("Invoice option verified");
}
//NEGATIVE CASE ,WITHOUT DATA IN CHECKOUT PAGE
public void verifySubmitWithEmptyFields() throws InterruptedException {
	Thread.sleep(3000);
     String checkoutUrlBefore = driver.getCurrentUrl();
// Click submit without filling any field
    wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    String checkoutUrlAfter = driver.getCurrentUrl();
    System.out.println("First url is :"+checkoutUrlBefore);
    System.out.println("Second url after click submit is :"+checkoutUrlAfter);

    // Validation: user should NOT go to confirmation page
    Assert.assertEquals(
            checkoutUrlAfter,
            checkoutUrlBefore,
            "Order placed even when checkout fields are empty" );
}
}





    
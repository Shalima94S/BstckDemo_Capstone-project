package pages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.waitUtils;

public class cartPage {
	WebDriver driver;
	waitUtils wait;
	public cartPage(WebDriver driver) {
		this.driver=driver;
		wait = new waitUtils(driver);
}
	By cartcount=By.cssSelector(".bag__quantity");
	By cartItemTitle = By.className("shelf-item__title");
    By productCards = By.cssSelector(".shelf-item");
	By addToCartBtn = By.cssSelector(".shelf-item__buy-btn");
	By removeBtn = By.cssSelector("div.float-cart__content button");
	By checkout=By.xpath("//div[@class='buy-btn']");
    By continueShoppingBtn =By.xpath("//button[normalize-space()='Continue Shopping']");
    By cartSlider = By.cssSelector(".float-cart__content");
    By emptyCartMsg = By.xpath("//*[contains(text(),'Add some products in the bag')]");
    By cartIcon =  By.cssSelector("div.float-cart__icon");
    By deleteBtns = By.cssSelector(".shelf-item__del");

	

//Add single product
  public void addSingleProductToCart() {
    wait.waitForElementClickable(addToCartBtn);
    driver.findElement(addToCartBtn).click();
}
//Verification
	public void verifysingleproduct() {
		wait.waitForElementVisible(cartcount);
        String count = driver.findElement(cartcount).getText();
        Assert.assertEquals(count, "1", "Cart count is not 1");
        wait.waitForElementVisible(cartItemTitle);
        Assert.assertTrue(driver.findElements(cartItemTitle).size() > 0,
                "Product not found in cart");
        System.out.println("Item added to cart");
		}
	
	//Add Multiple product 
	//First check is there any product exists in cart and its count
	
  public String  getCartCount() {
		wait.waitForElementVisible(cartcount);
		return driver.findElement(cartcount).getText();
		}
	
  public void multipleItems(int count) {
		  wait.waitForElementPresent(productCards);
		  List<WebElement> products = driver.findElements(productCards);
          JavascriptExecutor js = (JavascriptExecutor) driver;
          for (int i = 0; i < count; i++) {
                 WebElement addBtn = products.get(i).findElement(addToCartBtn);
		        js.executeScript("arguments[0].scrollIntoView(true);", addBtn);
		        try { Thread.sleep(500); } catch (Exception e) {}
		        js.executeScript("arguments[0].click();", addBtn);
          }
       }
          
   public int newCartCount() {
     		 return Integer.parseInt(
     	                driver.findElement(cartcount).getText());
     		 }
     //verify Checkout is visible 
	public void checkoutpageisVisible() {
		 Assert.assertTrue(
			        driver.findElement(checkout).isDisplayed(),
			        "Checkout button is NOT visible when cart has items" );
		             System.out.println("Checkout is visible");
		             WebElement cartclick=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[1]"));
		     		cartclick.click();
	}
	public void openCart() {
        List<WebElement> slider = driver.findElements(cartSlider);
        if (slider.isEmpty() || !slider.get(0).isDisplayed()) {
            driver.findElement(cartIcon).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartSlider));
        }
        }
	public void openCartIfClosed() {

	    // cart panel content selector
	    By cartContent = By.cssSelector("div.float-cart__content");

	    if (driver.findElements(cartContent).isEmpty()) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	    }
	}
	public void deleteAllItemsFromCart() {
        openCartIfClosed();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> deleteButtons = driver.findElements(deleteBtns);

	    for (WebElement delete : deleteButtons) {
	        js.executeScript("arguments[0].scrollIntoView(true);", delete);
	        js.executeScript("arguments[0].click();", delete);
	    }
		    }
	        
  
	 
  public void verifyCartIsEmpty()  {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 List<WebElement> slider = driver.findElements(By.cssSelector("div.float-cart__content"));
	    if (slider.isEmpty() || !slider.get(0).isDisplayed()) {
	        driver.findElement(By.cssSelector("div.cart--icon")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("div.float-cart__content")));
	    }
  // Wait until no Remove buttons are present
	    wait.until(ExpectedConditions.numberOfElementsToBe(
	            By.xpath("//button[contains(text(),'Remove')]"), 0));

	    System.out.println("Cart is empty,no remove button present");
	}


 }

		
	

	



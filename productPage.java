package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.waitUtils;

public class productPage {
	WebDriver driver;
	waitUtils wait;
	By loggedUser = By.className("username");
	By productTitle = By.className("shelf-item__title");
	By productPrice=By.className("val");
	By addtocartBtn=By.xpath("//*[@id=\"1\"]/div[4]");
    By filterDropdown=By.cssSelector("select.sort");
    By lowToHighoption=By.xpath("//div[text()='Lowest to highest']");
	 
	public productPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new waitUtils(driver);
	    }
	
	  public void verifyloggedinuser(String expecteduser) {
	        wait.waitForElementVisible(loggedUser);
	       String actualuser=driver.findElement(loggedUser).getText();
	       System.out.println("Logged in user is:"+actualuser);
	       Assert.assertEquals(actualuser,expecteduser,"Username not matching");
	    }
	  
	  public void verifyproductpage() {
		  wait.waitForElementVisible(productTitle);
		  Assert.assertTrue(driver.findElements(productTitle).size()>0,"Product not displayed");
		  System.out.println("Productpage displayed");
	  }
	  //Verify product details
	  public void verifyProductDetails() {
		  wait.waitForElementVisible(productTitle);
		  //verify ProductName
		  Assert.assertTrue(driver.findElements(productTitle).size()>0,"No products displayed");
		  //verify Product Price
		  Assert.assertTrue(driver.findElements(productPrice).size()>0,"No products price displayed");
		  //verify ADD to cart is present or not
		  Assert.assertTrue(driver.findElements(addtocartBtn).size()>0,"No Add to cart button displayed");
		  
	  }
	  //verify filter works
	  public void verifyfilter() {
		boolean filter=driver.getPageSource().contains("Lowest to highest");
		Assert.assertTrue(filter,"filter option is not present");
		System.out.println("Verified filter");
	
		  
	  }
	  
}

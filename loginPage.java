package pages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.waitUtils;

public class loginPage {
	WebDriver driver;
	waitUtils wait;
	
	 By signinbtn=By.id("signin");
	 By username  = By.id("username");
	 By password=By.id("password");
	 By loginbtn=By.id("login-btn");
	 By errormsg=By.className("api-error");

	
	public loginPage(WebDriver driver) {
		this.driver=driver;
		wait = new waitUtils(driver);

	}
	public void homePageDisplayed() {
		wait.waitForElementVisible(signinbtn);
		System.out.println("Homepsge displayed");
		Assert.assertTrue(driver.findElement(signinbtn).isDisplayed(),"Homepage is not displayed,please verify");
		}
	public void signIn()  {
	    driver.findElement(signinbtn).click();
	}
	public productPage login(String user,String pass) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	 wait.waitForElementClickable(username);
    	 driver.findElement(username).click();
   // select username option
         By userOption = By.cssSelector("#react-select-2-option-0-0");
         wait.waitForElementVisible(userOption);
         WebElement userE=driver.findElement(userOption);
         js.executeScript("arguments[0].scrollIntoView(true);",userE);
         js.executeScript("arguments[0].click();",userE);
         
  //Password
         wait.waitForElementClickable(password);
    	 driver.findElement(password).click();
         By passOption = By.cssSelector("#react-select-3-option-0-0");
         wait.waitForElementVisible(passOption);
         driver.findElement(passOption).click();
         
        // click login
        wait.waitForElementClickable(loginbtn);
        driver.findElement(loginbtn).click();
        System.out.println("Login successfully");
        return new productPage(driver);
    }
    //for invalid condition only
    public void selectReactOption(By dropdown, String value) {
        wait.waitForElementClickable(dropdown);
        driver.findElement(dropdown).click();

        By option = By.xpath("//div[contains(@id,'react-select') and text()='" + value + "']");
        wait.waitForElementVisible(option);
        driver.findElement(option).click();
    }
    public void login1(String user, String pass) throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(username).click();
        driver.findElement(username).sendKeys(user);

        // password
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginbtn).click();
    }
    
    public boolean isErrorDisplayed() {
		return driver.findElement(errormsg).isDisplayed();
    	
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.loginPage;
import pages.productPage;

public class loginTest extends baseTests {
	
	loginPage lp;

	
	@Test
	public void  TC_001_Loginwithvalidcredentials() {
		lp=new loginPage(driver);
		lp.homePageDisplayed();
		lp.signIn();
		lp.login(" demouser"," testingisfun99");
		Assert.assertTrue(driver.getCurrentUrl().contains("bstackdemo"));
		}
	
	//LOGIN WITH INVALID CREDENTIALS( TC_003: also included)
	//This login page ask to create user when we tries to add a new username,cant give a random input data and verify the error
	 @DataProvider(name = "loginData")
	    public Object[][] loginData() {
	        return new Object[][] {
	                
	                { "demo", "testingisfun99", "invalid" },//invalid username
	                { "demouser", "wrongpassword", "invalid" },//invalid password
	                {"      ","       ","invalid"}//blankdata
	        };
	    }

	 @Test(dataProvider = "loginData")
	   public void TC_002_Loginwithinvalidcredentials(
	            String username,
	            String password,
	            String expectedResult) throws InterruptedException {
		 //test = extent.createTest("TC_002_Loginwithinvalidcredentials");

	        lp = new loginPage(driver);
	        lp.signIn();
	        lp.login1(username, password);
	        if (expectedResult.equalsIgnoreCase("valid")) {
	            Assert.assertTrue(
	                driver.getCurrentUrl().contains("bstackdemo"),
	                "Valid login failed"
	            );
	        } else {
	            Assert.assertTrue(
	                lp.isErrorDisplayed(),
	                "Error message not shown for invalid login"
	            );
	        }
	        }
	 }
	 
	    
	        
	
	



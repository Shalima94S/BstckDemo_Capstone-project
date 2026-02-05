package tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtendManager;
import utils.configReader;
import utils.webDriverFactory;
import org.testng.*;
public class baseTests {
	
	protected WebDriver driver;
	protected ExtentReports extent;
    protected ExtentTest test;
  
    
    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/");
    
    }
    @BeforeClass
    public void setupReport() {
        extent = ExtendManager.getExtent();
    }

    @BeforeMethod
    public void beforeEachTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void captureResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        }
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }
}
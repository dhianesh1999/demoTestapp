package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pomPages.*;

public class BaseClass {

    public static WebDriver driver;

    @BeforeSuite
    public void openApp() throws IOException {
        String browser = utilities.propertyFile("browser").toLowerCase(); // read browser name from config
        
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(utilities.propertyFile("url"));

        PageFactory.initElements(driver, PatientRegPom.class);
        PageFactory.initElements(driver, VisitdetailsPom.class);
        PageFactory.initElements(driver, EndVisitAndDeletePom.class);
    }


	 
	 @AfterMethod
	    public void captureScreenshot(ITestResult result) {
	        String testName = result.getName();
	        utilities.takeScreenshot(driver, testName);
	    }
	 
	 @AfterSuite
	 public void closeApp() {
		 if (driver != null) {
         driver.quit();
     }
	 }
}

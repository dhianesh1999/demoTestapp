package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pomPages.LoginPom;
import pomPages.PatientRegPom;
import pomPages.VisitdetailsPom;



public class BaseClass {
		
	public static WebDriver driver;

		
	 @BeforeSuite
	 public void openApp() throws IOException {
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get(utilities.propertyFile("url"));
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   PageFactory.initElements(driver, LoginPom.class);
		   PageFactory.initElements(driver, PatientRegPom.class);
		   PageFactory.initElements(driver, VisitdetailsPom.class);


}
	 
	 @AfterSuite
	 public void closeApp() {
		 if (driver != null) {
         driver.quit();
     }
	 }
}

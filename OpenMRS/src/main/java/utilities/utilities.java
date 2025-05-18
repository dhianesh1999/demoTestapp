package utilities;

import java.io.File;
import org.openqa.selenium.OutputType;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilities {
	
	public static String propertyFile( String Key) throws IOException {
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
		p.load(fis);
		return p.getProperty(Key);
		}

    public static void takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String path = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + testName + "_" + timeStamp + ".png";
        try {
        	FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
    
	public static void dropdown(WebElement ele,String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public static void waitForElementVisible(WebDriver driver,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // wait max 10 seconds
        wait.until(ExpectedConditions.visibilityOf(ele));

	}
	
	public static void waitUntilElementIsClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

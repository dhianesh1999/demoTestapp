package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomPages.VisitdetailsPom;
import pomPages.PatientRegPom;
import utilities.BaseClass;
import utilities.FieldInputData;
import utilities.utilities;

public class VisitingdetailsTest extends BaseClass {
	
	@Test(priority = 1)
	public void tc_011_startVisit() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", VisitdetailsPom.startVisit);
		utilities.waitUntilElementIsClickable(driver, VisitdetailsPom.startVisit);
		VisitdetailsPom.startVisit.click();
		VisitdetailsPom.confirmPopup.click();
	}
	// check redirected to visit page or not
	@Test(priority = 2)
	public void tc_012_onVisitPage() {
		boolean onVisitPage=VisitdetailsPom.visit.isDisplayed();
		Assert.assertTrue(onVisitPage);
	}
	
	@Test(priority = 3)
	public void tc_013_addAttachment()  {		
		VisitdetailsPom.attachmentButton.click();
		// i used list to find any element has a input type=file key and it have one input type and it was hidden so i use js executor to upload
//		List<WebElement> inputs = driver.findElements(By.tagName("input"));
//		for (WebElement input : inputs) {
//		    System.out.println("Type: " + input.getAttribute("type"));
//		}

		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='block';", fileInput);
		fileInput.sendKeys(System.getProperty("user.dir") +"/src/test/resources/SummarizedReported (14).csv");
		VisitdetailsPom.captionField.sendKeys(FieldInputData.randamAlpha(9));
		VisitdetailsPom.uploadButton.click();
		}
	
	@Test(priority = 4)
	public void tc_014_verifyToast() {
		boolean toast=VisitdetailsPom.verifyToast.isDisplayed();
		Assert.assertTrue(toast);
	}
	
	@Test(priority = 5)
	public void tc_015_checkAddedAttacment() {
		driver.navigate().back();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String patientName=PatientRegPom.givenName.getText();
		Assert.assertEquals(patientName, PatientRegTest.firstName);
        boolean isattachment= VisitdetailsPom.fileIcon.isDisplayed();
		SoftAssert soAssert = new SoftAssert();
		soAssert.assertTrue(isattachment);
		soAssert.assertAll();
	}
	
	@Test(priority = 6)
	public void tc_016_recentVisit() {
		String date=VisitdetailsPom.currentDateVisit.getText();
		Assert.assertEquals(FieldInputData.todayDate(), date);
	}
	
	

}

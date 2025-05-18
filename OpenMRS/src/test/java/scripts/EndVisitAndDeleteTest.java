package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pomPages.EndVisitAndDeletePom;
import utilities.BaseClass;
import utilities.FieldInputData;

public class EndVisitAndDeleteTest extends BaseClass{
	
	@Test(priority= 1)
	public void tc_017_endVisit() {
		EndVisitAndDeletePom.endVisitButton.click();
		EndVisitAndDeletePom.confirmEndVisit.click();
		}
	
	@Test(priority = 2)
	public void tc_018_deletePatient() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", EndVisitAndDeletePom.deleteButton);
		EndVisitAndDeletePom.deleteButton.click();
		EndVisitAndDeletePom.reasonToDelete.sendKeys(FieldInputData.randamAlpha(6));
		EndVisitAndDeletePom.confirmDelete.click();
	}
	@Test(priority = 3)
	public void tc_019_verifyToast() {
		boolean toast=EndVisitAndDeletePom.deleteSuccessToast.isDisplayed();
		Assert.assertTrue(toast);
		}
	
	@Test(priority = 4)
	public void tc_020_searchDeletePatient() {
		EndVisitAndDeletePom.searchBar.sendKeys(PatientRegTest.firstName);
		boolean nodata= EndVisitAndDeletePom.noMatchFound.isDisplayed();
		Assert.assertFalse(nodata);
	}

}

package scripts;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pomPages.PatientRegPom;
import utilities.BaseClass;
import utilities.FieldInputData;
import utilities.utilities;

public class PatientRegTest extends BaseClass {
	static String  firstName="";
	String middleName="";
	String familyName="";
	String gender="";
	String day="";String month="";String year="";
	String address="";
	String phNo="";
	String personName="";String relative="";
	String expectedName = "";
	String expectedGender = "";
	String expecteddob = "";
	String expectedAddress = "";
	String expectedPhNo = "";
	String expectedRelative = "";	
	
	
	
	@Test(priority = 1)
	public void tc_002_patientName() {
		PatientRegPom.regPatient.click();
		PatientRegPom.firstName.clear();
		PatientRegPom.firstName.sendKeys(FieldInputData.randamAlpha(6));
	    firstName= PatientRegPom.firstName.getAttribute("value");
		
		PatientRegPom.middleName.clear();
		PatientRegPom.middleName.sendKeys(FieldInputData.randamAlpha(6));
		String middleName= PatientRegPom.middleName.getAttribute("value");
		
		PatientRegPom.familyName.clear();
		PatientRegPom.familyName.sendKeys(FieldInputData.randamAlpha(6));
		String familyName= PatientRegPom.familyName.getAttribute("value");
		
		expectedName= "Name: " +firstName+", "+middleName+", "+familyName;
		
		PatientRegPom.nextButton.click();	
		
	}
	
	@Test(priority = 2)
	public void tc_003_gender() {
		utilities.dropdown(PatientRegPom.gender, "Male");
		 Select select = new Select(PatientRegPom.gender);
		 gender = select.getFirstSelectedOption().getText();
		PatientRegPom.nextButton.click();
		expectedGender="Gender: "+gender;
		
	}
	
	@Test(priority = 3)
	public void tc_004_dateOfBirth() {
		PatientRegPom.dayField.sendKeys(FieldInputData.day(28));
		day= PatientRegPom.dayField.getAttribute("value");
		utilities.dropdown(PatientRegPom.monthField, "November");
		Select select = new Select(PatientRegPom.monthField);
		month = select.getFirstSelectedOption().getText();
	    PatientRegPom.yearField.sendKeys("2001");
	    year= PatientRegPom.yearField.getAttribute("value");
	    expecteddob="Birthdate: "+day+", "+month+", "+year;
	    PatientRegPom.nextButton.click();
	    		
	}
	
	@Test(priority = 4)
	public void tc_005_address() {
		PatientRegPom.addressField.sendKeys(FieldInputData.randamAlpha(9));
		address= PatientRegPom.addressField.getAttribute("value");
		expectedAddress = "Address: " + address;
		PatientRegPom.nextButton.click();
	}
	@Test(priority = 5)
	public void tc_006_phoneNumber()  {
		PatientRegPom.phoneNoField.sendKeys(FieldInputData.randomPhoneNumber());
		phNo= PatientRegPom.phoneNoField.getAttribute("value");
		expectedPhNo = "Phone Number: " + phNo;
		
		PatientRegPom.nextButton.click();
	}
	@Test(priority = 6)
	public void tc_007_relatives() {
		utilities.dropdown(PatientRegPom.relationField, "Parent");
		Select select = new Select(PatientRegPom.relationField);
		relative = select.getFirstSelectedOption().getText();
		PatientRegPom.personName.sendKeys(FieldInputData.randamAlpha(6));
		personName= PatientRegPom.personName.getAttribute("value");
		expectedRelative = "Relatives: " + personName + " - " + relative;
		PatientRegPom.nextButton.click();
		
	}
	@Test(priority = 7)
	public void tc_008_validationInputData() {
		utilities.waitForElementVisible(driver, PatientRegPom.validateName);
		String actualName=PatientRegPom.validateName.getText();
		Assert.assertEquals(actualName, expectedName);
		
		String actualGender=PatientRegPom.validateGender.getText();
		Assert.assertEquals(actualGender, expectedGender);
		
		String actualDob= PatientRegPom.validateDob.getText();;
		Assert.assertEquals(actualDob, expecteddob);
		
		String actualAddress=PatientRegPom.validateAddress.getText();
		Assert.assertEquals(actualAddress, expectedAddress);
		
		String actualPhNo=PatientRegPom.validatePhNo.getText();
		Assert.assertEquals(actualPhNo, expectedPhNo);
		
		String actualrelative=PatientRegPom.validateRelative.getText();
		Assert.assertEquals(actualrelative, expectedRelative);		
			}
	
	@Test(priority= 8)
	public void tc_009_confirmValidation() {
		PatientRegPom.confirm.click();
		
	}
	
	@Test(priority = 9)
	public void tc_010_patientDetailsPage() {
		utilities.waitForElementVisible(driver, PatientRegPom.givenName);
		String patientDetails=PatientRegPom.givenName.getText();
		Assert.assertEquals(patientDetails, firstName);
		
	}

}

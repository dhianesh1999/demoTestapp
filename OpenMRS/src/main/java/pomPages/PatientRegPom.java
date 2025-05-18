package pomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientRegPom {

	@FindBy(xpath="(//a[@type='button'])[4]")
	public static WebElement regPatient;
	
	@FindBy(name="givenName")
	public static WebElement firstName;
	
	@FindBy(name="middleName")
	public static WebElement middleName;
	
	@FindBy(name="familyName")
	public static WebElement familyName;
	
	@FindBy(id="next-button")
	public static WebElement nextButton;
	
	@FindBy(name="gender")
	public static WebElement gender;
	
	@FindBy(id="birthdateDay-field")
	public static WebElement dayField;
	
	@FindBy(id="birthdateMonth-field")
	public static WebElement monthField;
	
	@FindBy(id="birthdateYear-field")
	public static WebElement yearField;
	
	@FindBy(id="address1")
	public static WebElement addressField;
	
	@FindBy(name="phoneNumber")
	public static WebElement phoneNoField;
	
	@FindBy(id="relationship_type")
	public static WebElement relationField;
	
	@FindBy(xpath="//input[@placeholder='Person Name']")
	public static WebElement personName;
	
	@FindBy(xpath="(//p)[29]")
	//@FindBy(xpath="//p[span[@class='title' and contains(text(),'Name: ')]]")
	public static WebElement validateName;
	
	@FindBy(xpath="(//p)[30]")
	public static WebElement validateGender;
	
	@FindBy(xpath="(//p)[31]")
	public static WebElement validateDob;
	
	@FindBy(xpath="(//p)[32]")
	public static WebElement validateAddress;
	
	@FindBy(xpath="(//p)[33]")
	public static WebElement validatePhNo;
	
	//@FindBy(xpath="//p[span[@class='title' and contains(text(),'Relatives: ')]]")
	@FindBy(xpath="(//p)[34]")
	public static WebElement validateRelative;
	
	@FindBy(id="submit")
	public static WebElement confirm;
	
	@FindBy(xpath="//span[@class='PersonName-givenName']")
	public static WebElement givenName;
	
}

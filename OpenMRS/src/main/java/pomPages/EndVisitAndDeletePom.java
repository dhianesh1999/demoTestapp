package pomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EndVisitAndDeletePom {
	
	@FindBy(xpath="(//div[contains(text(),'End Visit')])[2]")
	public static WebElement endVisitButton;
	
	@FindBy(xpath="(//button[contains(text(),'Yes')])[2]")
	public static WebElement confirmEndVisit;
	
	@FindBy(xpath="//div[contains(text(),'Delete Patient')]")
	public static WebElement deleteButton;
	
	@FindBy(id="delete-reason")
    public static WebElement reasonToDelete;
	
	@FindBy(xpath="(//button[contains(text(),'Confirm')])[4]")
	public static WebElement confirmDelete;
	
	@FindBy(xpath="//p[contains(text(),'Patient has been deleted successfully')]")
	public static WebElement deleteSuccessToast;
	
	@FindBy(id="patient-search")
	public static WebElement searchBar;
	
	@FindBy(xpath="//td[contains(text(),'No matching records found')]")
	public static WebElement noMatchFound;

}

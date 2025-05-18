package pomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisitdetailsPom {
	
	@FindBy(xpath="//div[contains(text(),'Start Visit')]")
	public static WebElement startVisit;

	@FindBy(id="start-visit-with-visittype-confirm")
	public static WebElement confirmPopup;
	
	@FindBy(xpath="(//li[contains(normalize-space(), 'Visits')])[1]")
    public static WebElement visit;
	
	@FindBy(id="attachments.attachments.visitActions.default")
	public static WebElement attachmentButton;
	
	@FindBy(xpath="//div[contains(text(),'Click or drop a file here.')]")
	public static WebElement dropFileField;
	
	@FindBy(xpath="//textarea[@placeholder='Enter a caption']")
	public static WebElement captionField;
	
	@FindBy(xpath="//button[contains(text(),'Upload file')]")
	public static WebElement uploadButton;
	
	@FindBy(xpath="//p[contains(text(),'The attachment was successfully uploaded.')]")
	public static WebElement verifyToast;
	
	@FindBy(className = "icon-file")
    public static WebElement fileIcon;
	
	@FindBy(xpath="//div[contains(text(),'Attachment Upload')]")
	public static WebElement attachmentTag;
	
	@FindBy(xpath="//li //a[@class='ng-binding']")
	public static WebElement currentDateVisit;
	
}

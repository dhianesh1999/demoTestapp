package pomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPom {
	
	@FindBy(id="username")
	public static WebElement username;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(xpath="//li[contains(text(),'Registration Desk')]")
	public static WebElement location;
	
	@FindBy(id="loginButton")
	public static WebElement loginButton;
	

}

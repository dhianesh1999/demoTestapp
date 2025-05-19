package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {

    public LoginPom(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//li[contains(text(),'Registration Desk')]")
    private WebElement location;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutButton;

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void selectLocation() {
        location.click();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean verifyLogin() {
        return logoutButton.isDisplayed();
    }
}


package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomPages.LoginPom;
import utilities.BaseClass;



public class LoginTest extends BaseClass {
		
 
 @Test
 public void tc_001_logIn() {
 LoginPom.username.sendKeys("Admin");
 LoginPom.password.sendKeys("Admin123");
 LoginPom.location.click();
 LoginPom.loginButton.click();
 String title= driver.getTitle();
 Assert.assertEquals(title,"Home");
 

}
 
}

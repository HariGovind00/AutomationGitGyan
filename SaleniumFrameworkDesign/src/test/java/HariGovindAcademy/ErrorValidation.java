package HariGovindAcademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ErrorValidation extends DriverBaseFile {

	
//	  public void SubmitOrder() throws InterruptedException, IOException
//	  {
//		String productName = "zara coat 3";
//		LoginCredentialForUser logcred=new LoginCredentialForUser(driver);
//		logcred.LoginCred();
//		
//		
//	  }
	@Test
	  public void LoginErrorValidation() throws InterruptedException, IOException
	  {
		LandingPage landingpage=new LandingPage(driver);
		landingpage.LoginApplication("Roshan@gmaddil.com", "Roshan123");
		Assert.assertEquals("Incosrrect email or password.", landingpage.getErrorMsg());

	}
	
}
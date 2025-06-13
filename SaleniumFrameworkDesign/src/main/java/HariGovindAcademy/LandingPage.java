package HariGovindAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage extends AbstractComponenet
{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//page factory
	//using that we can reduce the syntex
	  //ie: @FindBy(id,css,cssSelector,xpath etc)
@FindBy(id="userEmail")
WebElement username;
@FindBy(id="userPassword")
WebElement userpassword;
@FindBy(id="login")
WebElement submit;
@FindBy(css="[class*='flyInOut']")
WebElement errormessagetext;

public void LoginApplication(String uname,String upass) throws InterruptedException
{
	username.sendKeys(uname);
	userpassword.sendKeys(upass);
	submit.click();

}

public String getErrorMsg()
{
	WaitForWebElementToAppear(errormessagetext);
	return errormessagetext.getText();

}


public void GoTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}




}

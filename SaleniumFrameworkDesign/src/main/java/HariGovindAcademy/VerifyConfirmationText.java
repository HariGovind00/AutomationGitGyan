package HariGovindAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyConfirmationText extends AbstractComponenet 
{
	WebDriver driver;
	public VerifyConfirmationText(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".hero-primary")
	WebElement verifyText;
	
	public String TextVerification()
	{
		String systemText=verifyText.getText();
		return systemText;
	}
}

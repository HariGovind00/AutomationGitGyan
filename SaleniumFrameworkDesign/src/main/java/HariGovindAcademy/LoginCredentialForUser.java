package HariGovindAcademy;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginCredentialForUser extends LandingPage
{
	WebDriver driver;
public LoginCredentialForUser(WebDriver driver)
{
		super(driver);
		this.driver=driver;
	}


public void LoginCred(String Name,String Password) throws InterruptedException
{
//	Scanner sc1=new Scanner(System.in);
//	System.out.println("Please enter username:");
//	String Name=sc1.nextLine();
//	System.out.println("Please enter password:");
//	String Password=sc1.nextLine();
	LandingPage lp=new LandingPage(driver);
	lp.LoginApplication(Name,Password);
	//Assert.assertEquals("Incorrect email or password.", lp.getErrorMsg());
}

}

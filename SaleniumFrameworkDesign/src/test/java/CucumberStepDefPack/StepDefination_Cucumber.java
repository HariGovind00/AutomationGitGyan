package CucumberStepDefPack;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import HariGovindAcademy.AbstractComponenet;
import HariGovindAcademy.AddToCartPage;
import HariGovindAcademy.DriverBaseFile;
import HariGovindAcademy.LandingPage;
import HariGovindAcademy.ProductCatelog;
import HariGovindAcademy.ProductPaymentDelivery;
import HariGovindAcademy.VerifyConfirmationText;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_Cucumber extends DriverBaseFile
{
	public LandingPage landingpage;
	public AddToCartPage addtocartpage;
	public ProductPaymentDelivery productpaymentdelivery;
	WebDriver driver;
	
	@Given("I landed on Ecom page")
	public void Load_landing_page() throws IOException
	{
		landingpage=launchapplicationdrivers();
	}
	//When we pass regular expression(.+), then pass ^ & $ symbol.
	
	@Given("^Login with username (.+) and password (.+)$")
	public void LoginCredintialForUser(String user, String pass) throws InterruptedException
	{
		landingpage.LoginApplication(user,pass);
	}

	@When("^Add products (.+) to AddMyCart$")
	public void Product_To_Cart(String productName) throws InterruptedException
	{
		ProductCatelog productcatelog=new ProductCatelog(driver);
		List<WebElement>products=productcatelog.getProductList();
		productcatelog.addProductToCart(productName);
		AbstractComponenet abs=new AbstractComponenet(driver);
		productcatelog.clickAddToCartButton();
		
	}
	
	@When("^Checkout the select products (.+) and submit the order$")
	public void checkout_submitOrder(String productName)
	{
		AddToCartPage addtocartpage=new AddToCartPage(driver);
		Boolean match=addtocartpage.VerifyProductAddedToCart("zara coat 3");
		Assert.assertTrue(match);
		addtocartpage.ProductCheckOut();
		ProductPaymentDelivery productpaymentdelivery=new ProductPaymentDelivery(driver);
		productpaymentdelivery.SelectCountryDropdown();
		productpaymentdelivery.placeOrderButton();	}
	
	@Then("verify the {string} message is displayed successfully on confirmation page.")
	public void Text_Confirmation(String string)
	{
		VerifyConfirmationText verText=new VerifyConfirmationText(driver);
		String stext=verText.TextVerification();
		Assert.assertTrue(stext.equalsIgnoreCase(string));
		driver.close();
		
	}
	
	@Then("verify the {string} for the Login credential.")
	public void Login_Cred_Error_Validation(String string)
	{
		Assert.assertEquals(string, landingpage.getErrorMsg());
		driver.close();
	}
	
}

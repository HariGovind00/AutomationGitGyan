package HariGovindAcademy;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends DriverBaseFile

{
	WebDriver driver;
	//@Test(dataProvider="userCredHashMap",groups={"purchase"})
	//@Test(dataProvider = "UserInputCred", groups= {"purchase"})
	@Test
	public void submitOrder() throws InterruptedException
	{
		System.out.println("Hello");
		LandingPage landingPage=new LandingPage(driver);
		//landingPage.LoginApplication(username, pass);
		landingPage.LoginApplication("harigovind@gmail.com", "Welcome123");
		ProductCatelog productcatelog=new ProductCatelog(driver);
		List<WebElement>products=productcatelog.getProductList();
		productcatelog.addProductToCart("zara coat 3");
		AbstractComponenet abs=new AbstractComponenet(driver);
		productcatelog.clickAddToCartButton();
		AddToCartPage addtocartpage=new AddToCartPage(driver);
		Boolean match=addtocartpage.VerifyProductAddedToCart("zara coat 3");
		Assert.assertTrue(match);
		addtocartpage.ProductCheckOut();
		ProductPaymentDelivery productpaymentdelivery=new ProductPaymentDelivery(driver);
		productpaymentdelivery.SelectCountryDropdown();
		productpaymentdelivery.placeOrderButton();
		VerifyConfirmationText verifyconfirmationtext=new VerifyConfirmationText(driver);
		String systemdisplayedtext=verifyconfirmationtext.TextVerification();
		Assert.assertTrue(systemdisplayedtext.equalsIgnoreCase("Thankyou for the order."));

	}
	
//	@DataProvider
//		public Object[][] UserInputCred()
//		{
//		  return new Object[][]{{"Roshan@gmail.com","Roshan123","zara coat 3"},{"harigovind@gmail.com","Welcome123","adidas original"}};
//		}
	
//	@DataProvider
//	public Object[][] userCredHashMap()
//	{
//		HashMap<String, String> upcred=new HashMap<String, String>();
//		upcred.put("email","harigovind@gmail.com");
//		upcred.put("password","Welcome123");
//		upcred.put("product", "zara coat 3");
//		
//		HashMap<String, String> upcred1=new HashMap<String, String>();
//		upcred1.put("email","Roshan@gmail.com");
//		upcred1.put("password","Roshan123");
//		upcred1.put("product", "adidas original");
//		
//		return new Object[][] {{upcred},{upcred1}};
//	}
	
}
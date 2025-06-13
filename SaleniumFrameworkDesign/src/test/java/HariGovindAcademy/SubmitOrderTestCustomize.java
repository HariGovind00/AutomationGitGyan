package HariGovindAcademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrderTestCustomize extends DriverBaseFile {

	@Test(dataProvider = "loginUserCred")
	  public void SubmitOrder(String name,String password) throws InterruptedException, IOException
	  {
		String productName = "zara coat 3";
		LoginCredentialForUser logcred=new LoginCredentialForUser(driver);
		logcred.LoginCred(name,password);
		ProductCatelog productcatelog=new ProductCatelog(driver);
		List<WebElement>products=productcatelog.getProductList();
		productcatelog.addProductToCart(productName);
		AbstractComponenet abs=new AbstractComponenet(driver);
		productcatelog.clickAddToCartButton();
		AddToCartPage addtocartpage=new AddToCartPage(driver);
		Boolean match=addtocartpage.VerifyProductAddedToCart(productName);
		Assert.assertTrue(match);
		addtocartpage.ProductCheckOut();
		ProductPaymentDelivery productpaymentdelivery=new ProductPaymentDelivery(driver);
		productpaymentdelivery.SelectCountryDropdown();
		productpaymentdelivery.placeOrderButton();
		VerifyConfirmationText verifyconfirmationtext=new VerifyConfirmationText(driver);
		String systemdisplayedtext=verifyconfirmationtext.TextVerification();
		Assert.assertTrue(systemdisplayedtext.equalsIgnoreCase("Thankyou for the order."));
	}
	
	@DataProvider
	public Object[][] loginUserCred()
	{
		Object [][] obj=new Object[1][2];
		obj[0][0]="govindharik@gmail.com";
		obj[0][1]="welcome";
		
		return obj;
	}
}
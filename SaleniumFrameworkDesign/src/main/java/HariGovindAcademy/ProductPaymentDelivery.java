package HariGovindAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPaymentDelivery extends AbstractComponenet
{

	WebDriver driver;
	public ProductPaymentDelivery(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countrySelection;
	@FindBy(css=".ta-item:last-child")
	WebElement PickedCountry;
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	public void SelectCountryDropdown()
	{
		Actions act = new Actions(driver);
		act.sendKeys(countrySelection, "India").build().perform();
		PickedCountry.click();
	}
	
	public void placeOrderButton()
	{
		placeOrder.click();
	}

}

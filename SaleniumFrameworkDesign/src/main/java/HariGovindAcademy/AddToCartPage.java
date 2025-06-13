package HariGovindAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends AbstractComponenet
{
public AddToCartPage(WebDriver driver)
{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

WebDriver driver;

@FindBy(css=".cartSection h3")
List<WebElement> verifyProduct;
@FindBy(css=".totalRow button")
WebElement CheckOut;

public Boolean VerifyProductAddedToCart(String productname)
{
	
	Boolean Match = verifyProduct.stream().anyMatch(pro -> pro.getText().equalsIgnoreCase(productname));
	return Match;
}

public void ProductCheckOut()
{
	CheckOut.click();
}
}

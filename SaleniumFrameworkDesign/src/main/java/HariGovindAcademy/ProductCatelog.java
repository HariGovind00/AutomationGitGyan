package HariGovindAcademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCatelog extends AbstractComponenet
{
	WebDriver driver;
	public ProductCatelog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(css=".col-lg-4")
List<WebElement> products;
@FindBy(css=".ng-animating")
WebElement spinnerwait;


By ProductsBy=By.cssSelector(".col-lg-4");
By addtocart=By.cssSelector(".card-body button:last-of-type");
By toastmsg=By.cssSelector("#toast-container");


public List<WebElement> getProductList()
{
	WaitForElementToAppear(ProductsBy);
	return products;
}
//We are calling getProductList() because after that method is loaded this getProductByName method will execute.
public WebElement getProductByName(String products)
{
	WebElement prod=getProductList().stream().filter(pro->pro.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(products)).findFirst().orElse(null);
	
	return prod;
}

public void addProductToCart(String products) throws InterruptedException
{
	WebElement prod=getProductByName(products);
	System.out.println(prod.getText());
	prod.findElement(addtocart).click();
	WaitForElementToAppear(toastmsg);
	waitForElementToDisappear(spinnerwait);

}






}

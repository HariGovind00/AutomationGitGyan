package HariGovindAcademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponenet
{
	WebDriver driver;
public AbstractComponenet(WebDriver driver) 
    {
	
	this.driver=driver;
	}

public void WaitForElementToAppear(By FindBy)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
}

public void WaitForWebElementToAppear(WebElement FindBy)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	wait.until(ExpectedConditions.visibilityOf(FindBy));
}

public void waitForElementToDisappear(WebElement ele) throws InterruptedException
{
	Thread.sleep(3000);
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.invisibilityOf(ele));

}
@FindBy(css=("[routerlink*='cart']"))
WebElement GoToAddToCartPage;

public void clickAddToCartButton()
{
	GoToAddToCartPage.click();
}
}

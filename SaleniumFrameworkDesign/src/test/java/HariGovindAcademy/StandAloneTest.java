package HariGovindAcademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		// username password login page
		driver.findElement(By.id("userEmail")).sendKeys("harigovind@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Welcome123");
		driver.findElement(By.id("login")).click();

		// product page
		String cartProduct = "zara coat 3";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		// List<WebElement> ProductName=driver.findElements(By.cssSelector(".card-body
		// b"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("zara coat 3"))
				.findFirst().orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		// class loading to load
		// explicit wait
		// Below,It will slow down your performance
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		// We are using this to increase a bit performance using
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		// click on the cart page
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> verifyProduct = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = verifyProduct.stream().anyMatch(pro -> pro.getText().equalsIgnoreCase(cartProduct));
		Assert.assertTrue(match);
		System.out.println("Successfully ran the code.");

		// click on the checkout button
		driver.findElement(By.cssSelector(".totalRow button")).click();

		// select the drop down
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group")));
		driver.findElement(By.cssSelector(".ta-item:last-child")).click();
		// Place the order
		driver.findElement(By.cssSelector(".action__submit")).click();

		// verify the successfully ordered text
		String verifytext = driver.findElement(By.cssSelector(".hero-primary")).getText();
		// verifyProduct.stream().filter(vertext->vertext.getText().equalsIgnoreCase("
		// Thankyou for the order. "));
		Assert.assertTrue(verifytext.equalsIgnoreCase("Thankyou for the order."));

		driver.close();

	}
}
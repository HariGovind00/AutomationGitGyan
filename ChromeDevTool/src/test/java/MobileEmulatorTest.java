import java.net.URL;
import java.util.Optional;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.emulation.Emulation;
import org.openqa.selenium.devtools.v114.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v114.page.model.Viewport;
import org.openqa.selenium.devtools.v114.emulation.model.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileEmulatorTest
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtools=driver.getDevTools();
	devtools.createSession();
	devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.<Number> empty(),Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation>empty(), Optional.<Viewport> empty(), Optional.<DisplayFeature> empty()));
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector(".navbar-toggler")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Library")).click();
	
	
}
}

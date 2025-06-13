import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.emulation.Emulation;

public class CdpCommandTest 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtools=driver.getDevTools();
	devtools.createSession();
	Map devmatrix=new HashMap();
	devmatrix.put("width", 600);
	devmatrix.put("height", 1000);
	devmatrix.put("deviceScaleFactor", 50);
	devmatrix.put("mobile", true);
	driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", devmatrix);
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector(".navbar-toggler")).click();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Library")).click();
	
	
}
}

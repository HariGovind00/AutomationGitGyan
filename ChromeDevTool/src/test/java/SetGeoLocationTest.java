import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocationTest 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		Map<String, Object> coordinates=new HashMap<String, Object>();
		coordinates.put("latitude", 17);
		coordinates.put("longitude", 78);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".MBeuO")).get (0).click();
		String title=driver.findElement(By.cssSelector(".default-ltr-cache-19f4kxn")).getText();
		System.out.println(title);
		
		driver.close();		
		
	}

}

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.fetch.Fetch;

public class NetworkMocking
{
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtools=driver.getDevTools();
	devtools.createSession();
	devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
	devtools.addListener(Fetch.requestPaused(), request->
	{
		if(request.getRequest().getUrl().contains("shetty"))
		{
			String mockedurl=request.getRequest().getUrl().replace("=shetty", "=BadGuy");
			System.out.println(mockedurl);
			devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedurl), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		}
		else
		{
			devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

		}
	});
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	Thread.sleep(3000);
	System.out.println(driver.findElement(By.cssSelector("P")).getText());
	
	
}
}

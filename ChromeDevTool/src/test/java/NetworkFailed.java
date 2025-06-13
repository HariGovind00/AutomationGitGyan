import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.fetch.Fetch;
import org.openqa.selenium.devtools.v114.network.model.ErrorReason;
import org.openqa.selenium.devtools.v114.network.model.RequestPattern;

public class NetworkFailed 
{
public static void main(String[] args) 
{
	System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtools=driver.getDevTools();
	devtools.createSession();
	Optional patterns=Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
	devtools.send(Fetch.enable(patterns, Optional.empty()));
	devtools.addListener(Fetch.requestPaused(), request->
	{
		devtools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
	});
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
}
}

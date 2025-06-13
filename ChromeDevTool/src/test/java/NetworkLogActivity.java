import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.model.Response;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.Request;

public class NetworkLogActivity {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.<Integer> empty(), Optional.<Integer> empty(),Optional.<Integer> empty()));
		devtools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req=request.getRequest();
			//System.out.println(req.getUrl());
			
		});
		
		devtools.addListener(Network.responseReceived(), response ->
		{
			Response resp=response.getResponse();
//			System.out.println(resp.getUrl());
//			System.out.println(resp.getStatus());
			if(resp.getUrl().toString().startsWith("2"))
			{
				System.out.println(resp.getUrl()+" :is not working:"+resp.getStatus());
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		driver.close();
		
	}

}

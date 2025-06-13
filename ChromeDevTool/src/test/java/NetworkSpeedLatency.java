import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.ConnectionType;

public class NetworkSpeedLatency 
{
public static void main(String[] args)
{
System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
ChromeDriver driver=new ChromeDriver();
DevTools devtools=driver.getDevTools();	
devtools.createSession();
devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
devtools.send(Network.emulateNetworkConditions(false, 1000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
devtools.addListener(Network.loadingFailed(), loadingFailed->
{
	System.out.println(loadingFailed.getErrorText());
	System.out.println(loadingFailed.getTimestamp());
	System.out.println(loadingFailed.getRequestId());
	System.out.println(loadingFailed.getBlockedReason());
	
});
long starttime=System.currentTimeMillis();
driver.get("https://www.google.com");
long endtime=System.currentTimeMillis();
System.out.println(endtime-starttime);
driver.close();


}
}

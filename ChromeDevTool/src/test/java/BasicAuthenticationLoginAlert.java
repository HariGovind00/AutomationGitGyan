import java.net.URI;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import com.google.common.base.Predicate;

public class BasicAuthenticationLoginAlert 
{
public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver", "E:\\Salenium Application\\Chrome drivers\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	Predicate<URI> uripredicate=uri ->uri.getHost().contains("httpbin.org");
	((HasAuthentication)driver).register(uripredicate,UsernameAndPassword.of("foo", "bar"));
	driver.get("https://httpbin.org/basic-auth/foo/bar");
}
}

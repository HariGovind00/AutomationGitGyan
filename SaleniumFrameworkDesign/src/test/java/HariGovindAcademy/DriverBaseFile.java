package HariGovindAcademy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DriverBaseFile
{
	
public static WebDriver driver;

public static WebDriver initializeDriver() throws IOException
{
	
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\GlobalData.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser")!=null?prop.getProperty("browser"):prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
	{
		

		driver = new ChromeDriver();
		
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
}

@BeforeMethod
public LandingPage launchapplicationdrivers() throws IOException
{
	driver=initializeDriver();
	LandingPage landingPage=new LandingPage(driver);
	landingPage.GoTo();
	return landingPage;
}

public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";

}


@AfterMethod
public void tearbrowsertoclose() throws InterruptedException
{
	driver.close();
	System.out.println("I will be displayed after successful test script ran");

}
}

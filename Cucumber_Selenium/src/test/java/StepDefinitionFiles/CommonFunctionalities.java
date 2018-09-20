package StepDefinitionFiles;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctionalities {

	public static int waitTime=2;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static void IntiatlizeDriver()
	{
		File f=new File(".");
		System.setProperty("webdriver.chrome.driver","Lib/chromedriver.exe");	
		driver = new ChromeDriver();		
		wait=new WebDriverWait(driver, 50);	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}
	public static void waitTime(int Timeout)
	{
		try 
		{
			Thread.sleep(Timeout*1000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void verifyText(By ele,String Expected)
	{
		String actualText2 = driver.findElement(ele).getText().trim();
		Assert.assertEquals(Expected, actualText2.trim()); 

	}
}


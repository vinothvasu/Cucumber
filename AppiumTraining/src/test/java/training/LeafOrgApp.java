package training;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.functions.ExpectedCondition;

public class LeafOrgApp {

	AndroidDriver<WebElement> driver;

	public void switchcontext() {

		Set<String> contextnames=driver.getContextHandles();

		for (String contextname : contextnames) {		
			System.out.println(contextname);
			if(contextname.contains("WEBVIEW")) {			
				driver.context(contextname);
				System.out.println("Context: " +contextname);
			}
		}
	}

	@BeforeTest
	public void invoke() throws MalformedURLException {

		//File targetfile = new File("D:\\Appium\\Second Day\\LeafOrg.apk");

		DesiredCapabilities capabilities= new DesiredCapabilities();

		capabilities.setCapability("deviceName", "abc");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("app", targetfile.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.testleaf.leaforg");
		capabilities.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		capabilities.setCapability("fastReset", "true");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Test(priority=0)
	public void update() throws InterruptedException {	  
		switchcontext();	  
		driver.findElementByXPath("//input[@formcontrolname='email']").sendKeys("sakthivel@testleaf.com");
		driver.findElementByXPath("//input[@formcontrolname='password']").sendKeys("Leaf@123");
		driver.findElementByXPath("//span[contains(text(),'Login')]").click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-t0-2"))); 
		driver.findElementById("tab-t0-2").click();  
		driver.findElementByXPath("(//div[@class='input-wrapper'])[4]").click();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElementByXPath("//span[contains(text(),'SAVE CHANGES')]")).click().perform();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[@class='button-inner'])[14]").click();

	}
   @Test(priority=1)
   public void close() {
		driver.quit();

   }

}


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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.functions.ExpectedCondition;

public class ParallelWithGridRunLeafOrgApp {

	AndroidDriver<WebElement> driver1;
	
	//RemoteWebDriver driver1;

	public void switchcontext() {
		Set<String> contextnames=driver1.getContextHandles();

		for (String contextname : contextnames) {		
			System.out.println(contextname);
			if(contextname.contains("WEBVIEW")) {			
				driver1.context(contextname);
				System.out.println("Context: " +contextname);
				break;
			}
		}
	}

	@Parameters({"device" , "version", "platformname"})
	@BeforeTest
	public void invoke(String device, String version, String plaformname) throws MalformedURLException {

		//File targetfile = new File("D:\\Appium\\Second Day\\LeafOrg.apk");

		DesiredCapabilities capabilities= new DesiredCapabilities();

		capabilities.setCapability("deviceName", device);
		capabilities.setCapability("platformVersion", version);
		capabilities.setCapability("platformName", plaformname);
		//capabilities.setCapability("udid", "066db1760adf9768");
		//capabilities.setCapability("app", targetfile.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.testleaf.leaforg");
		capabilities.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		capabilities.setCapability("fastReset", "true");

		driver1 = new AndroidDriver<WebElement>(new URL("http://192.168.0.104:4444/wd/hub"), capabilities);	
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Test(priority=0)
	public void update() throws InterruptedException {	  
		switchcontext();	  
		driver1.findElementByXPath("//input[@formcontrolname='email']").sendKeys("sakthivel@testleaf.com");
		driver1.findElementByXPath("//input[@formcontrolname='password']").sendKeys("Leaf@123");
		driver1.findElementByXPath("//span[contains(text(),'Login')]").click();
		WebDriverWait wait=new WebDriverWait(driver1, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-t0-2"))); 
		driver1.findElementById("tab-t0-2").click();  
		driver1.findElementByXPath("(//div[@class='input-wrapper'])[4]").click();
		Actions action=new Actions(driver1);
		action.moveToElement(driver1.findElementByXPath("//span[contains(text(),'SAVE CHANGES')]")).click().perform();
		Thread.sleep(2000);
		driver1.findElementByXPath("(//span[@class='button-inner'])[14]").click();

	}
   @Test(priority=1)
   public void close() {
		driver1.quit();

   }

}


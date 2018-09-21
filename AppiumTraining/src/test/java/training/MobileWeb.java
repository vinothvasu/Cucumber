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
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.functions.ExpectedCondition;

public class MobileWeb {

	RemoteWebDriver driver;

	@BeforeTest
	public void invoke() throws MalformedURLException {

		DesiredCapabilities capabilities= new DesiredCapabilities();

		capabilities.setCapability("deviceName", "abc");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("browserName", "chrome");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Test(priority=0)
	public void update() throws InterruptedException {	  

		Actions action = new Actions(driver);
		driver.get("https://www.india.ford.com");	
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='global-ux']/div/following::a)[1]")));		
		Thread.sleep(10000);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome to Ford India mobile website')]/following::input[2]")));
			driver.findElementByXPath("//div[contains(text(),'Welcome to Ford India mobile website')]/following::input[2]").click();
		}catch (Exception e) {

		}
		driver.findElementByXPath("(//div[@id='global-ux']/div/following::a)[1]").click();;
		driver.findElementByXPath("//span[contains(text(), 'Vehicles')]").click();	
		driver.findElementByXPath("//a[contains(text(), 'SUVS')]").click();
		action.moveToElement(driver.findElementByXPath("(//a[contains(text(), 'VIEW ALL VEHICLES')])[2]")).build().perform();
		driver.findElementByXPath("(//a[contains(text(), 'VIEW ALL VEHICLES')])[2]").click();

	}
	@Test(priority=1)
	public void close() {
		driver.quit();

	}

}


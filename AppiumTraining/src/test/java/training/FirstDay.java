package training;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;




public class FirstDay {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<WebElement> driver;

		DesiredCapabilities capabilities= new DesiredCapabilities();

		capabilities.setCapability("deviceName", "abc");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.mms");
		capabilities.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//TouchAction action = new TouchAction(driver);
		
		WebElement search=driver.findElementById("android:id/input");
		
		System.out.println(search.getText());
		
		search.click();
			
		search.sendKeys("ab");
		
		driver.quit();
		
		
		
		
		
		

	}

}

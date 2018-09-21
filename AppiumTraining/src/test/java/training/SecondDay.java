package training;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class SecondDay {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<WebElement> driver;
		
		//File targetfile = new File("D:\\Appium\\Second Day\\LeafOrg.apk");

		DesiredCapabilities capabilities= new DesiredCapabilities();

		capabilities.setCapability("deviceName", "abc");
		capabilities.setCapability("platformName", "Android");
    	//capabilities.setCapability("app", targetfile.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.testleaf.leaforg");
		capabilities.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*ScreenOrientation orientation = driver.getOrientation();
		
		System.out.println(orientation.value());
		
		if(orientation.value().contains("portrait")) {	
			driver.rotate(ScreenOrientation.LANDSCAPE);
			Thread.sleep(3000);
			System.out.println(driver.getOrientation());	
		}else {

			driver.rotate(ScreenOrientation.PORTRAIT);
			System.out.println(orientation.value());
		}*/
		
		driver.setConnection(Connection.WIFI);
		
		driver.quit();
		

	}

}

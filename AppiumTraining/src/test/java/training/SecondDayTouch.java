package training;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class SecondDayTouch {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
        
		AndroidDriver<WebElement> driver;
		
		DesiredCapabilities capabilities= new DesiredCapabilities();

		File file = new File("C:\\Users\\Vinoth Vasu\\Desktop\\MultiTouch Tester.apk");
		capabilities.setCapability("deviceName", "abc");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		capabilities.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		int ht=driver.manage().window().getSize().getHeight();
		
		int width=driver.manage().window().getSize().getWidth();
		
		int htt = (int)(ht*0.20);
		
		int widthh = (int) (width*0.20);
				
		System.out.println(ht);
		
		System.out.println(width);
		
		int x=driver.findElementById("com.the511plus.MultiTouchTester:id/touchStr").getLocation().getX();
		
		int y=driver.findElementById("com.the511plus.MultiTouchTester:id/touchStr").getLocation().getY();
		
		TouchAction action = new TouchAction(driver);
		
		action.tap(driver.findElementById("com.the511plus.MultiTouchTester:id/touchStr"));
		
		action.release().perform();
		
		action.press(300, 300).perform().waitAction(Duration.ofMillis(5000)).release();
		
		action.longPress(widthh,htt).perform().waitAction(Duration.ofMillis(5000)).release();
		
		/*MultiTouchAction multiTouch = new MultiTouchAction(driver);

        TouchAction finger1 = new TouchAction(driver);

        TouchAction finger2 = new TouchAction(driver);

        TouchAction finger3 = new TouchAction(driver);

        TouchAction finger4 = new TouchAction(driver);

        TouchAction finger5 = new TouchAction(driver);

        finger1.press(x+5, y+y).waitAction(Duration.ofMillis(2000)).release();

        finger2.press(x+10,y+10).waitAction(Duration.ofMillis(2000)).release();

        finger3.press(x+20,y+20).waitAction(Duration.ofMillis(2000)).release();

        finger4.press(x+30,y+30).waitAction(Duration.ofMillis(2000)).release();

        finger5.press(x-40,y-40).waitAction(Duration.ofMillis(2000)).release();

        multiTouch.add(finger1).add(finger2).add(finger3).add(finger4).add(finger5).perform();
*/
		
		//MobileElement elementOrder = (MobileElement) driver.findElement(MobileBy.id("com.the511plus.MultiTouchTester:id/touchStr"));

//		 elementOrder.swipe(SwipeElementDirection.UP,5000); --> Deprecated now

		
		 TouchAction finger1 = new TouchAction(driver);

		 finger1.press(550, 920).perform().moveTo(940, 860).perform().release();

		 Thread.sleep(5000);
		Thread.sleep(5000);
		
		
	}

}

package restSelenium;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SeleniumRest {

	public static Object number;

	@Test
	public void createChangeRequest() {

		File file=new File("./changeRequest.xml");

		Response response = RestAssured
				.given()
				.log()
				.all()
				.auth()
				.basic("admin", "Smileplease28#")
				.body(file)
				.contentType(ContentType.XML)
				.accept(ContentType.XML)
				.expect()
				.statusCode(201)
				.when()
				.post("https://dev61953.service-now.com/api/now/table/change_request");

		System.out.println(response.statusCode());

		XmlPath xmlPath = response.xmlPath();

		number = xmlPath.get("response.result.number");

		System.out.println(number);
	}

	@Test(dependsOnMethods="createChangeRequest")
	public void checkRequest() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinoth Vasu\\Desktop\\chromedriver.exe");

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev61953.service-now.com/");
		driver.switchTo().frame(0);

		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("Smileplease28#");
		driver.findElementByXPath("//button[contains(text(),'Login')]").click();

		driver.switchTo().defaultContent();

		driver.findElementById("filter").sendKeys("change");

		WebDriverWait wait=new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(text(),'Open')])[1]")));

		driver.findElementByXPath("(//div[contains(text(),'Open')])[1]").click();

		driver.switchTo().frame(0);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search' and @class='form-control']")));

		String numberr=String.valueOf(number);

		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(numberr);
		driver.findElementByXPath("//input[@placeholder='Search' and @class='form-control']").sendKeys(Keys.ENTER);

		boolean changerqst=	driver.findElementByXPath("//a[contains(text(),'"+number+"')]").isDisplayed();

		if(changerqst=true) {

			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

	}
}

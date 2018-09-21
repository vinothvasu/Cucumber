package testCases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	public ChromeDriver driver;

	@Given("Open the Browser")
	public void invokeBrowser() {	
		System.setProperty("webdriver.chrome.driver", "C:/Users/Vinoth Vasu/Desktop/chromedriver.exe");
		 driver =new ChromeDriver();
	}

	@And("Maximize the window")
	public void maximizeBrowser() {	
		
		driver.manage().window().maximize();
		
	}
	@And("Load the URL")
	public void loadURL() {
		
		driver.get("http://leaftaps.com/opentaps");
	
	}
	@And("Set the TimeOut")
	public void setTimeOut() {	
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	@And("Enter the UserName as (.*)")
	public void userName(String uname) {	
	
		driver.findElementById("username").sendKeys(uname);
	}
	@And("Enter the Password as (.*)")
	public void password(String password) {	
		
		driver.findElementById("password").sendKeys(password);
		
	}
	
	@Given("Enter the Credentials")
	public void password(Map<String,String>data) {	
		driver.findElementById("username").sendKeys(data.get("UserName"));
		driver.findElementById("password").sendKeys(data.get("Password"));
		
	}
	@When("Click on Login")
	public void login() {	
	
		driver.findElementByClassName("decorativeSubmit").click();
	}
	@Then("Verify Login is Successful")
	public void verifyLogin() {	
		
		System.out.println("Login is Succesfull");
		
	}
	
	@But("Verify Login is failed")
	public void LoginFailure() {	
		
		System.out.println("Login is Failed");
		
	}
}

package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class test1 {

	WebDriver driver;
	PageFactory.SelectLocation objLogin;
	PageFactory.HomePage objHomePage;
	
	@BeforeTest
	public void setup(){
		System.out.println("A. Starting the Test 1");
		//Modify the location of Chrome Driver according to your system
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HD\\Documents\\GitHub\\TalentRocket\\src\\resources\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		System.out.println("1. Starting the Browser");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.talentrocket.de");
		System.out.println("2. Navigating to Talent Rocket");
	}


	@Test
	public void verifyHomePageTitleTest(){
		System.out.println("3. Verifying the Title");
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Karriere & Jobs für Juristen | TalentRocket LAW");
		driver.close();
	}
	
//	@AfterTest
//	public void exit(){
//	driver.close();
//	}
	
	}

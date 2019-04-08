package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import PageFactory.HomePage;
import PageFactory.SelectLocation;




public class test2 {

	WebDriver driver;
	SelectLocation objLocate;
	HomePage objHomePage;
	
	@BeforeTest
	public void setup(){
		System.out.println("A. Starting the Test 2");
		//Modify the location of Chrome Driver according to your system
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HD\\Documents\\GitHub\\TalentRocket\\src\\resources\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		System.out.println("1. Starting the Browser");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.talentrocket.de");
		System.out.println("2. Navigating to Talent Rocket");
	}


	@Test(priority=1)
	public void jobSection(){
		
	objLocate = new SelectLocation(driver);
    SelectLocation.jobClick();
    System.out.println("3. Navigating to Job Section");
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	@Test(priority=2)
	public void TitleTest(){
		String title = SelectLocation.verifyTitle();
		System.out.println("3. Verifying the title");
		Assert.assertEquals(title, "Jura Jobs");
	}
	

	
	@Test(priority=3)
	public void selectLocation(){
		System.out.println("4. Selecting Location Filter");
		SelectLocation.locate();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//div[@class='modal-body from-row row']")).click();
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.xpath("//span[@class='mat-checkbox-label'][contains(text(),'Aachen')]")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    String single = driver.findElement(By.xpath("//span[@class='mat-checkbox-label'][contains(text(),'Aachen')]")).getText();
		Assert.assertEquals(single, "Aachen");
	    System.out.println("5. Selecting Single Option");
	    SelectLocation.result();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    System.out.println("6. Clicking on view option");
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    SelectLocation.locate();
	    driver.findElement(By.xpath("//div[@class='modal-body from-row row']")).click();
	    driver.switchTo().activeElement();
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.xpath("//span[contains(text(),'Bonn')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Emmering')]")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    String comboBox = driver.findElement(By.xpath("//span[@class='active-link ng-star-inserted']")).getText();
	    
	    System.out.println("Value : "+ comboBox);
	    System.out.println("7. Selecting Multiple Option");
	    SelectLocation.result();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	
	
	
	@AfterTest
	public void exit(){
	driver.close();
	}
	
}

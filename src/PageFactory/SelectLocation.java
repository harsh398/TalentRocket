package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectLocation {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	static WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'Jobs')]")
	static WebElement jobs;
	
	@FindBy(xpath="//multiple-filter-dropdown[2]//div[1]")
	static WebElement location;
	
	@FindBy(xpath="//button[@class='tr-btn tr-btn-blue d-block tr-btn-sharp-corners tr-btn-large not-hover']")
	static WebElement results;

	public SelectLocation(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public static String verifyTitle(){
		return driver.getTitle();
	}
	public static void locate(){

        location.click();
        
	}
	public static void jobClick(){

		jobs.click();
        
	}
	
	public static void result(){
		results.click();
	}

}

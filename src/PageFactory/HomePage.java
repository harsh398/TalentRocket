package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	static WebDriver driver;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-header[1]/div[1]/app-navbar[1]/nav[1]/div[1]/button[1]")
	WebElement login;
	

	

	public HomePage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
		
		public void clickOnLogin(){
	    login.click();
			
		}	
}

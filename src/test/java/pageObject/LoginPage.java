package pageObject;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="Email")
	WebElement emailTxt;
	
	@FindBy(id="Password")
	WebElement passwordTxt;
	
	@FindBy(xpath=("//button[@class='button-1 login-button']"))
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
	WebElement errorMsg;
	
	
	public void enterEmail(String email) {
		emailTxt.clear();
		emailTxt.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordTxt.clear();
		passwordTxt.sendKeys(password);
	}
	
	public void clickOnLoginButton () {
		loginBtn.click();
	}
	
	public void verifyLoginErrorMessage () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("errorMsg")));
		String actualMsg=errorMsg.getText();
		String expectedMsg="Login was unsuccessful. Please correct the errors and try again.";
		
		if(actualMsg.equals(expectedMsg)) {
			Assert.assertTrue(true);
			System.out.println("Valid error msg....");
		}
		else {
			Assert.assertFalse(false);
			System.out.println("Invalid error mag....");
		}
	}
	
	
}

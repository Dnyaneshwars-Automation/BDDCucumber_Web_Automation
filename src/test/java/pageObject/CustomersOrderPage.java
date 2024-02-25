package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.MyHook;

public class CustomersOrderPage {

	
	public WebDriver driver;
	
	public CustomersOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	MyHook myhook=new MyHook();   //// Create an instance of MyHook class
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Sales')]")
	WebElement salesHiddenBtn;
	
	@FindBy(xpath="//a[@href='/Admin/Order/List']//p[contains(text(),'Orders')]")
	WebElement orderBtn;
	
	@FindBy(xpath="(//span[@class='k-picker-wrap k-state-default']//span[@class='k-icon k-i-calendar'])[1]")
	WebElement clickStartDataCalender;
	
	@FindBy(xpath="//span[@class='k-picker-wrap k-state-default']//input[@id='EndDate']")
	WebElement clickEndDataCalender;
	
	public void clickOnSalesButton() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Sales')]"))));
		salesHiddenBtn.click();		
	}
	
	public void clickOnSalesOrderButton() {
		myhook.explicitlyWait(orderBtn);
//		WebDriverWait wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/Admin/Order/List']//p[contains(text(),'Orders')]"))));
		orderBtn.click();
	}

	public void clickOnStartDataCalenderandSelectStartDate() {
		clickStartDataCalender.click();
		myhook.explicitlyWait(clickStartDataCalender);
//		WebDriverWait wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='k-animation-container']//div[@id='StartDate_dateview']"))));
		String cMonth=driver.findElement(By.xpath("//div[@id='StartDate_dateview']//div[@class='k-header']//a[contains(text(),'January')]")).getText();
		String cYear=driver.findElement(By.xpath("//div[@id='StartDate_dateview']//div[@class='k-header']//a[contains(text(),'2024')]")).getText();
		
		while(!(cMonth.equals("May"))&&(cYear.equals("2024"))) {
			
			WebElement nextBtn=driver.findElement(By.xpath("//div[@id='StartDate_dateview']//span[@class='k-icon k-i-arrow-60-right']"));
			nextBtn.click();
			String sMonth=driver.findElement(By.xpath("//div[@id='StartDate_dateview']//div[@class='k-header']//a[contains(text(),'January')]")).getText();
			String sYear=driver.findElement(By.xpath("//div[@id='StartDate_dateview']//div[@class='k-header']//a[contains(text(),'2024')]")).getText();	
		}
		myhook.explicitlyWait(driver.findElement(By.xpath("(//table[@class='k-content k-month']/tbody/tr[3]/td[5])[1]")));
//		WebDriverWait wait1=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//table[@class='k-content k-month']/tbody/tr[3]/td[5])[1]"))));
		WebElement date=driver.findElement(By.xpath("(//table[@class='k-content k-month']/tbody/tr[3]/td[5])[1]"));
		date.click();
		date.getText();
		
		System.out.println("The date selected as 16/05/2024");
		
	}
	
}
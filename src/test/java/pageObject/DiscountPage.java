package pageObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import hooks.MyHook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import org.openqa.selenium.support.FindBy;

public class DiscountPage {
	
	public WebDriver driver;
	MyHook myhook=new MyHook();
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Promotions')]")
	WebElement pramotionBtn;
	
	@FindBy(xpath="//a[@href='/Admin/Discount/List']//p[contains(text(),'Discounts')]")
	WebElement discountBtn;
	
	@FindBy(xpath="(//span[@class='k-widget k-datepicker']//span[@class='k-icon k-i-calendar'])[1]")
	WebElement startDateCalendarIcon;
	
	@FindBy(xpath="(//span[@class='k-widget k-datepicker']//span[@class='k-icon k-i-calendar'])[2]")
	WebElement endDateCalendarIcon;
	
	@FindBy(id="SearchStartDate")
	WebElement satrtDateTxt;
	
	@FindBy(id="SearchEndDate")
	WebElement endDateTxt;
	
	
	public DiscountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPromotionOptionAndDiscountOption () {
		myhook.explicitlyWait(driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Promotions')]")));
		pramotionBtn.click();
		myhook.explicitlyWait(driver.findElement(By.xpath("//a[@href='/Admin/Discount/List']//p[contains(text(),'Discounts')]")));
		discountBtn.click();
	}
	
	public void verifyUserNavgateOnDiscountPage() {
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
	}
	
	public void clickOnStartDateCalenderAndSelectCurrentDate() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd mmm yyyy");
		String currentDate=sdf.format(date);
		System.out.println(currentDate);
		
		satrtDateTxt.sendKeys(currentDate);
	}
	
//	public void verifyCurrentDate() {
//	 
//	}
	
//	public void clickOnEndDateCalenderAndSelectFutureDate() {
//		LocalDate futureDate=LocalDate.now().plusYears(1).plusMonths(1).plusDays(2);
//		System.out.println(futureDate);
//		endDateTxt.sendKeys(futureDate);
//	}
}

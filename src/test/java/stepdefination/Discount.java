package stepdefination;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.DiscountPage;


public class Discount {

	public WebDriver driver;
	DiscountPage discountpage;

	@And("click on promotion option and Discount Option")
	public void click_on_promotion_option_and_discount_option() {
	driver=DriverFactory.getDriver();
	discountpage=new DiscountPage(driver);
	discountpage.clickOnPromotionOptionAndDiscountOption();
	}

	@Then("verify user navigate on discount search page")
	public void verify_user_navigate_on_discount_search_page() {
		discountpage.verifyUserNavgateOnDiscountPage();
	}

	@And("enter start date and end date")
	public void enter_start_date_and_end_date() {
		discountpage.clickOnStartDateCalenderAndSelectCurrentDate();
	}

	@Then("verify the current date and future date.")
	public void verify_the_current_date_and_future_date() {
		System.out.println("Current Date");
	}
}

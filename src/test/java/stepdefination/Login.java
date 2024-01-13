package stepdefination;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import hooks.MyHook;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;
import pageObject.AddNewCustomer;
import pageObject.CustomersOrderPage;
import pageObject.HomePage;

public class Login {
	
	public static WebDriver driver;
	

	private static Logger logger = LogManager.getLogger(Login.class);
	
       LoginPage loginpage;
       HomePage homepage;
       AddNewCustomer addnewcustomer;
       SearchCustomerPage searchcustomerpage;
       CustomersOrderPage customerorderpage;
       
	
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() {
		logger = LogManager.getLogger("Login");
		logger.info("Logger information message");
		driver=DriverFactory.getDriver();
	}

	@When("user enterd {string} and {string}")
	public void user_enterd_and(String email, String password) {
		driver=DriverFactory.getDriver();
		loginpage=new LoginPage(driver);
		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() {
	   loginpage.clickOnLoginButton();
	}

	@Then("user validate title of homepage")
	public void user_validate_title_of_homepage() {
		homepage=new HomePage(driver);
		homepage.verifyHomePageTitle();
	}

	@Then("user validate error message with invalid password")
	public void user_validate_error_message_with_invalid_password() {
		loginpage.verifyLoginErrorMessage();
	}
	
	// Add New Customers 
	
	@When("click on customers hidden button")
	public void click_on_customers_hidden_button() {
		addnewcustomer= new AddNewCustomer(driver);
		addnewcustomer.clickOnCustomersDropDown();
	}

	@When("click on customers option")
	public void click_on_customers_option() {
		addnewcustomer.clickOnCustomersOption();
	}

	@When("click on Add New button")
	public void click_on_add_new_button() {
		addnewcustomer.clickOnAddNewButton();
	}

	@When("enter customers information")
	public void enter_customers_information() throws InterruptedException {
		addnewcustomer.enterAddNewCustomersDetails();
	}

	@When("click on save button")
	public void click_on_save_button() {
		addnewcustomer.clickOnSaveButton();
	}

	@Then("verify new customer added successfully")
	public void verify_new_customer_added_successfully() {
		addnewcustomer.verifyNewCustomerAddedSuccessfully();
	}
	
	// Search Customer By Name
	
	@Then("customers webtable is display")
	public void customers_webtable_is_display() {
		searchcustomerpage=new SearchCustomerPage(driver);
		searchcustomerpage.verifyCustomersWebTableDisplay();
	}

	@Then("find the number of table row")
	public void find_the_number_of_table_row() {
		searchcustomerpage.findTotalNumberOfRow();
	}

	@Then("find the number of table column")
	public void find_the_number_of_table_column() {
		searchcustomerpage.findTotalNumberOfColumn();
	}

	@Then("find the james pan customer by name")
	public void find_the_james_pan_customer_by_name() {
		searchcustomerpage.findCustomerRow();
	}

	@Then("retrive the all table data")
	public void retrive_the_all_table_data() {
		searchcustomerpage.customerTableData();
	}

	@Then("retrive the indian cricket team customer name and customer role from table")
	public void retrive_the_indian_cricket_team_customer_name_and_customer_role_from_table() {
		searchcustomerpage.retriveIndianCricketTeamNameAndRole();
	}

	// Search Customer By Email
	
	@Then("enter search customer {string}")
	public void enter_search_customer(String emailAddress) {
		searchcustomerpage.enterSearchCustomerEmailAddress(emailAddress);
	}
	
	
	@Then("enter search customer by name {string}")
	public void enter_search_customer_by_name(String customerName) {
		searchcustomerpage.enterSearchCustomerName(customerName);
	}
	
	@Then("click on search button")
	public void click_on_search_button() {
		searchcustomerpage.clickSearchButton();
	}

	@Then("verify the search result from customers table")
	public void verify_the_search_result_from_customers_table_victoria_victoria_nop_commerce_com() {
		searchcustomerpage.verifySearchResultByEmail();
		searchcustomerpage.verifySearchResultByName();
		searchcustomerpage.verifySearchResultByAllDetails();
	}

	@Then("enter search customer all details")
	public void enter_search_customer_all_details(DataTable dataTable) {
		//This is for Single data Map
//		List<String>list=dataTable.asList(String.class);
//		searchcustomerpage.enterEmail(list.get(0));
		
		//This is for Multiple DataLine Maps
//		List<List<String>> list= dataTable.asLists(String.class);
//		for(List<String>li:list) {
//		searchcustomerpage.enterEmail(li.get(0));
//		searchcustomerpage.enterFirstName(li.get(1));
//		searchcustomerpage.enterLastName(li.get(2));
//		searchcustomerpage.enterCompanyName(li.get(3));
		
		//This is for Single data Map
//		Map<String,String>list=dataTable.asMap(String.class,String.class);
//		searchcustomerpage.enterEmail(list.get("Email"));
		
		//This is for Multiple DataLine Maps
		List<Map<String, String>> dataMap=dataTable.asMaps(String.class,String.class);
		for(Map<String,String>list:dataMap) {
		searchcustomerpage.enterEmail(list.get("Email"));
		searchcustomerpage.enterEmail(list.get("FirstName"));
		searchcustomerpage.enterEmail(list.get("LastName"));
		searchcustomerpage.enterEmail(list.get("CompanyName"));
	}
	}

	//Salse Order Page
	
	@And("click on sales hidden button")
	public void click_on_sales_hidden_button() {
		customerorderpage=new 	CustomersOrderPage(driver);
		customerorderpage.clickOnSalesButton();
	}

	@And("click on order option")
	public void click_on_order_option() {
		customerorderpage.clickOnSalesOrderButton();
	}

	@Then("verify the required date selected")
	public void verify_the_required_date_selected() {
		customerorderpage.clickOnStartDataCalenderandSelectStartDate();
	}


}

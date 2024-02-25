package pageObject;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;

public class SearchCustomerPage {
	
	public WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='dataTables_scrollBody']")
	WebElement webTableDisplay;

	@FindBy(xpath="//div[@class='dataTables_scrollBody']//table//tbody//tr")
	List<WebElement> rowCount;
	
	@FindBy(xpath="//div[@class='dataTables_scrollBody']//tbody/tr[1]//td")
	List<WebElement> columnCount;
	
	@FindBy(xpath="//div[@class='dataTables_scrollBody']//tbody//tr[5]//td[4]")
	WebElement findJamesPanRole;
	
	@FindBy(xpath="//div[@class='dataTables_scrollBody']//tbody//tr[2]//td/..")
	WebElement verifyCustomerRowData;
	
	@FindBy(xpath="//input[@id='SearchEmail' or @name='SearchEmail']")
	WebElement searchEmailTxt;
	
	@FindBy(xpath="//input[@id='SearchFirstName' or @name='SearchFirstName']")
	WebElement searchNameTxt;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='SearchLastName' or @name='SearchLastName']")
	WebElement searchLastNameTxt;
	
	@FindBy(xpath="//input[@id='SearchCompany']")
	WebElement companyNameTxt;
	
	public void verifyCustomersWebTableDisplay () {
		webTableDisplay.isDisplayed();
	}
	
	public void findTotalNumberOfRow () {
		System.out.println(rowCount.size());
	}
	
	public void findTotalNumberOfColumn () {
		System.out.println(columnCount.size());
	}
	
	public void findCustomerRow () {
		String customerRow=verifyCustomerRowData.getText();
		System.out.println("The customer row:"+"   "+ customerRow);
	}
	
	public void findJamesPanRole () {
		String jamesRole = findJamesPanRole.getText();
		System.out.println("The role of jamesPal is:"+jamesRole);
	}
	
	public void customerTableData () {
		int tRow= rowCount.size();
		int tColumn= columnCount.size();
		for(int r=1 ;r<=tRow; r++) {
			for(int c=1; c<=tColumn; c++) {
				String data= driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody//tr["+r+"]//td["+c+"]")).getText();
				System.out.println("The table data:"+"     "+data);
			}
		}
		
	}
	
	public void retriveIndianCricketTeamNameAndRole () {
		int tRow= rowCount.size();
		for(int r=1 ;r<=tRow; r++) {
			String companyName= driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody//tr["+r+"]//td[5]")).getText();
			boolean flag= false;
			if(companyName.equals("Indian Cricket Team")) {
				flag=true;
				String name=driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody//tr["+r+"]//td[3]")).getText();
				System.out.println("The name of customer:"+"  "+name);
				String role=driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody//tr["+r+"]//td[4]")).getText();
				System.out.println("The role of customer:"+"  "+role);
			}
			else {
				flag=false;
			}
		}
		
		
	}
	
	public void enterSearchCustomerEmailAddress (String emailAddress) {
		searchEmailTxt.sendKeys(emailAddress);
	}
	
	public void enterSearchCustomerName (String customerName) {
		searchNameTxt.sendKeys(customerName);
	}
	
	public void clickSearchButton () {
		searchBtn.click();
	}
	
	public void verifySearchResultByEmail () {
		int tRow= rowCount.size();
		int tColumn= columnCount.size();
		boolean flag=false;
		 String emailFound="victoria_victoria@nopCommerce.com";
		for(int i=1; i<=tRow; i++) {
			//for(int j=1; j<=tColumn; j++) {
			String searchEmail= driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody//tr["+i+"]//td[2]")).getText();
			
			if(searchEmail.equals(emailFound)) {
			flag=true;
			String dataRow=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr["+i+"]")).getText();
			System.out.println(dataRow);
			System.out.println(searchEmail);
		}
		else {
			flag=false;
		}
			}
		
	}
	
	public void verifySearchResultByName () {
		int tRow= rowCount.size();
		boolean flag=false;
		 String name="Steve";
		for(int i=1; i<=tRow; i++) {
			//for(int j=1; j<=tColumn; j++) {
			String searchName= driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody//tr["+i+"]//td[3]")).getText();
	
			if(searchName.equals(name)) {
			flag=true;
			String dataRow1=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr["+i+"]")).getText();
			System.out.println(dataRow1);
			System.out.println(searchName);
		}
		else {
			flag=false;
		}
			}
		
	}
	
	public void enterEmail(String Email) {
		searchEmailTxt.clear();
		searchEmailTxt.sendKeys(Email);
		}
	
	public void enterFirstName(String FirstName) {	
		searchNameTxt.clear();
		searchNameTxt.sendKeys(FirstName);
		}
		
	public void enterLastName(String LastName) {
		searchLastNameTxt.clear();
		searchLastNameTxt.sendKeys(LastName);
		}
		
	public void enterCompanyName(String CompanyName) {	
		companyNameTxt.clear();
		companyNameTxt.sendKeys(CompanyName);
		
	}
	
	public void verifySearchResultByAllDetails () {
		int tRow= rowCount.size();
		boolean flag=false;
		 String name="John";
		for(int i=1; i<=tRow; i++) {
			//for(int j=1; j<=tColumn; j++) {
			String searchName= driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']//tbody//tr["+i+"]//td[3]")).getText();
	
			if(searchName.equals(name)) {
			flag=true;
			String dataRow1=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//tr["+i+"]")).getText();
			System.out.println(dataRow1);
			System.out.println(searchName);
		}
		else {
			flag=false;
		}
			}
		
	}
		
	}
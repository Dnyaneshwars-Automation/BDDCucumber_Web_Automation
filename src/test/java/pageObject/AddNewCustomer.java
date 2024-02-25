package pageObject;


import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomer {
	
	public WebDriver driver;
	
	public AddNewCustomer (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerOptinonBtn;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customerListBtn;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addNewBtn;
	
	@FindBy(id="Email")
	WebElement addNewCustomerEmailTxt;
	
	@FindBy(id="Password")
	WebElement addNewCustomerPasswordTxt;
	
	@FindBy(id="FirstName")
	WebElement addNewCustomerFirstNameTxt;
	
	@FindBy(id="LastName")
	WebElement addNewCustomerLastNameTxt;
	
	@FindBy(id="Gender_Male")
	WebElement assNewCustomerSelectGender;
	
	@FindBy(xpath="//input[@name='DateOfBirth']")
	WebElement addNewCustomerDateTxt;
	
	@FindBy(xpath="//input[@name='Company']")
	WebElement addNewCustomerCompanyNameTxt;
	
	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement addNewCustomerTaxExamptedCheckBox;
	
	@FindBy(xpath="(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[1]")
	WebElement addNewCustomerNewsLatter;
	
	@FindBy(xpath="//li[contains(text(),'Test store 2')]")
	WebElement addNewCustomerSelectNewsLatter;
	
	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable']")
	WebElement addNewCustomerCompanyRole;
	
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement addNewCustomerSelectRole;
	
	@FindBy(id="Active")
	WebElement addNewCustomerActiveCheckBox;
	
	@FindBy(id="AdminComment")
	WebElement addNewCustomerAdminCommentTxt;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement verifyAddNewCustomerMsg;
	
	public void clickOnCustomersDropDown () {
		customerOptinonBtn.click();
	}
	
	public void clickOnCustomersOption () {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")));
		
		customerListBtn.click();
	}
	
	public void clickOnAddNewButton() {
		addNewBtn.click();
	}
	
	public void enterAddNewCustomersDetails() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
				
		String rsValue=RandomStringUtils.randomAlphabetic(6);
		String pass=rsValue;
		String gmail=rsValue+"@gmail.com";
		
		addNewCustomerEmailTxt.sendKeys(gmail);
		addNewCustomerPasswordTxt.sendKeys(pass);
		addNewCustomerFirstNameTxt.sendKeys("vikas");
		addNewCustomerLastNameTxt.sendKeys("singh");
		addNewCustomerDateTxt.sendKeys("01/06/1990");
		addNewCustomerCompanyNameTxt.sendKeys("Bajaj Auto Ltd");
		addNewCustomerTaxExamptedCheckBox.click();
		addNewCustomerNewsLatter.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Test store 2')]")));
		addNewCustomerSelectNewsLatter.click();
		addNewCustomerCompanyRole.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Administrators')]")));
		addNewCustomerSelectRole.click();
		addNewCustomerActiveCheckBox.click();
		addNewCustomerAdminCommentTxt.click();
	}
	
	public void clickOnSaveButton() {
		saveBtn.click();
	}
	
	public void verifyNewCustomerAddedSuccessfully () {
		WebDriverWait wait = new WebDriverWait(driver,package pageObject;


import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomer {
	
	public WebDriver driver;
	
	public AddNewCustomer (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerOptinonBtn;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customerListBtn;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addNewBtn;
	
	@FindBy(id="Email")
	WebElement addNewCustomerEmailTxt;
	
	@FindBy(id="Password")
	WebElement addNewCustomerPasswordTxt;
	
	@FindBy(id="FirstName")
	WebElement addNewCustomerFirstNameTxt;
	
	@FindBy(id="LastName")
	WebElement addNewCustomerLastNameTxt;
	
	@FindBy(id="Gender_Male")
	WebElement assNewCustomerSelectGender;
	
	@FindBy(xpath="//input[@name='DateOfBirth']")
	WebElement addNewCustomerDateTxt;
	
	@FindBy(xpath="//input[@name='Company']")
	WebElement addNewCustomerCompanyNameTxt;
	
	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement addNewCustomerTaxExamptedCheckBox;
	
	@FindBy(xpath="(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[1]")
	WebElement addNewCustomerNewsLatter;
	
	@FindBy(xpath="//li[contains(text(),'Test store 2')]")
	WebElement addNewCustomerSelectNewsLatter;
	
	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable']")
	WebElement addNewCustomerCompanyRole;
	
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement addNewCustomerSelectRole;
	
	@FindBy(id="Active")
	WebElement addNewCustomerActiveCheckBox;
	
	@FindBy(id="AdminComment")
	WebElement addNewCustomerAdminCommentTxt;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement verifyAddNewCustomerMsg;
	
	public void clickOnCustomersDropDown () {
		customerOptinonBtn.click();
	}
	
	public void clickOnCustomersOption () {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")));
		
		customerListBtn.click();
	}
	
	public void clickOnAddNewButton() {
		addNewBtn.click();
	}
	
	public void enterAddNewCustomersDetails() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
				
		String rsValue=RandomStringUtils.randomAlphabetic(6);
		String pass=rsValue;
		String gmail=rsValue+"@gmail.com";
		
		addNewCustomerEmailTxt.sendKeys(gmail);
		addNewCustomerPasswordTxt.sendKeys(pass);
		addNewCustomerFirstNameTxt.sendKeys("vikas");
		addNewCustomerLastNameTxt.sendKeys("singh");
		addNewCustomerDateTxt.sendKeys("01/06/1990");
		addNewCustomerCompanyNameTxt.sendKeys("Bajaj Auto Ltd");
		addNewCustomerTaxExamptedCheckBox.click();
		addNewCustomerNewsLatter.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Test store 2')]")));
		addNewCustomerSelectNewsLatter.click();
		addNewCustomerCompanyRole.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Administrators')]")));
		addNewCustomerSelectRole.click();
		addNewCustomerActiveCheckBox.click();
		addNewCustomerAdminCommentTxt.click();
	}
	
	public void clickOnSaveButton() {
		saveBtn.click();
	}
	
	public void verifyNewCustomerAddedSuccessfully () {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("verifyAddNewCustomerMsg")));
		
		String aMsgTxt=verifyAddNewCustomerMsg.getText();
		String eMsgTxt="";
		
		if(aMsgTxt.equalsIgnoreCase(eMsgTxt)) {
			Assert.assertTrue(true);
			System.out.println("Customer added successfully ....");
		}
		else {
			Assert.assertFalse(false);
			System.out.println("Customer not added successfully ....");
		}
	}
	
}
);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("verifyAddNewCustomerMsg")));
		
		String aMsgTxt=verifyAddNewCustomerMsg.getText();
		String eMsgTxt="";
		
		if(aMsgTxt.equalsIgnoreCase(eMsgTxt)) {
			Assert.assertTrue(true);
			System.out.println("Customer added successfully ....");
		}
		else {
			Assert.assertFalse(false);
			System.out.println("Customer not added successfully ....");
		}
	}
	
}

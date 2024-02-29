package hooks;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

import org.openqa.selenium.support.ui.WebDriverWait;

public class MyHook {

	public static WebDriver driver;
	
	private static Logger logger = LogManager.getLogger(MyHook.class);
	
	 @Before
	    public void setUpBrowser() {
	        Properties prop = ConfigReader.initializeProperties();
	        DriverFactory.initializebrowser(prop.getProperty("Browser"));
	        driver = DriverFactory.getDriver();
	        if (driver != null) {
	            driver.manage().window().maximize();
	            driver.manage().deleteAllCookies();
	            driver.get(prop.getProperty("URL"));
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            logger.info("Browser SetUp Successfully");
	        } else {
	            logger.error("WebDriver is null. Browser setup failed.");
	        }
	    }

	    @After
	    public void tearDown(Scenario scenario) {
	        if (driver != null) {
	            if (scenario.isFailed()) {
	                try {
	                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                    scenario.attach(screenshot, "image/png", scenario.getName());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            driver.quit(); // Changed from close() to quit() for better cleanup
	            logger.info("Browser Teardown Successfully");
	        } else {
	            logger.error("WebDriver is null. Unable to perform browser teardown.");
	        }
	    }

	
	
	

	public void explicitlyWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	
	 static WebDriver driver;
	
	public static void initializebrowser(String browserName) {
		
		if(browserName == null) {
            throw new IllegalArgumentException("Browser name is null");
        }
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\monal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.setBinary("C:\\Users\\monal\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
			driver=new ChromeDriver(options);
			options.addArguments("--headless");
		}
		
		else if(browserName.equals("edge")) {
		WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			 
		}
		else {
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
		
	}
		
		public static WebDriver getDriver() {
			 if(driver == null) {
		            throw new IllegalStateException("WebDriver is not initialized");
		        }
		return driver;
	}

}

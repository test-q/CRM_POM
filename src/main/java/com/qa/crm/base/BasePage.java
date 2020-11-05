package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.crm.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static Properties prop;
	public static WebDriver driver;
	public static String flashElement;
	OptionsManager manager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	
	
	/**
	 * 
	 * @return This method written synchronized ThreadLocal WebDriver
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	

	/**
	 * This method take properties and give us webdriver
	 * @param prop
	 * @return Webdriver
	 */
	public WebDriver init_driver(Properties prop) {
		flashElement = prop.getProperty("highlights").trim();
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser Name: " +browserName );
		manager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			if (Boolean.parseBoolean(prop.getProperty("remote").trim())) {
				init_remoteWebDriver(browserName);                          // Execute my test on remote machine
			} else {
				// Execute my test on local machine as well as setting browser properties.
				//driver = new ChromeDriver(manager.getChromeOptions());    // When we are using normal driver 
				tlDriver.set(new ChromeDriver(manager.getChromeOptions())); // When we are using thread local driver
			}
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			if (Boolean.parseBoolean(prop.getProperty("remote").trim())) {
				init_remoteWebDriver(browserName);                            // Execute my test on remote machine

			} else {
				// Execute my test on local machine.
				//driver = new FirefoxDriver(manager.getFirefoxOptions());    // When we are using normal driver 
				tlDriver.set(new FirefoxDriver(manager.getFirefoxOptions())); // When we are using thread local driver
			}
		} 
		else {
			System.out.println("Please Pass The Correct Browser Name : " + browserName);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

		return getDriver();
	}

	
	
	
	/**
	 * This method will design the desired capabilities and will initialize the 
	 * driver with capability Also, this method initialize driver with selenium Hub/port
	 * @param browser
	 */
	public void init_remoteWebDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			DesiredCapabilities cap = new DesiredCapabilities().chrome();  
			cap.setCapability(ChromeOptions.CAPABILITY, manager.getChromeOptions());   // set chrome browser property
		
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl").trim()), cap));  // Connect with hub use RemoteWebDriver class
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}		
		}
		else if(browser.equalsIgnoreCase("firefox")){
			DesiredCapabilities cap = new DesiredCapabilities().firefox();
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, manager.getFirefoxOptions());   // set firefox browser property
			
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl").trim()), cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @return Properties read from Config.properties file and return 
	 */
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");

			if (env == null) {
				path = "D:/Rupali/Workspace/CRM_POM/src/main/java/com/qa/crm/config/Config.prod.properties";
				System.out.println("Default Envirnment: " + "PROD");

			} else {
				switch (env) {
				case "prod":
					path = "D:/Rupali/Workspace/CRM_POM/src/main/java/com/qa/crm/config/Config.prod.properties";
					System.out.println("Envirnment: " + "PROD");
					break;
				case "qa":
					path = "D:/Rupali/Workspace/CRM_POM/src/main/java/com/qa/crm/config/Config.qa.properties";
					System.out.println("Envirnment: " + "QA");
					break;
				default:
					System.out.println("Please Pass the Correct Env Value...");
					break;
				}
			}

			FileInputStream finput = new FileInputStream(path);
			prop.load(finput);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}

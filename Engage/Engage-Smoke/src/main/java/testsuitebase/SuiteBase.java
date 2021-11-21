package testsuitebase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.engage.smoke.surveypage.SurveyPage_TC;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.DMXPage;
import pageobjects.DMXPageEngage;
import pageobjects.DataPage;
import pageobjects.LoginPage;
import pageobjects.RMXPage;
import pageobjects.RMXPageEngage;
import pageobjects.SMXPage;
import pageobjects.SurveyPage;
import utility.DecryptPassword;
import utility.ExtentManager;
import utility.FetchExcelDataSet;
import utility.Read_XLS;

public class SuiteBase {

	InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<WebDriver>();
	public Logger Add_Log = null;
	public Properties Config = null;
	public WebDriver ExistingMozillaBrowser;
	public WebDriver ExistingChromeBrowser;
	public WebDriver ExistingIEBrowser;
	public WebDriver ExistingRemoteDriver;
	public Read_XLS TestFile = null;
	public HashMap<String, String> URLs = null;
	public HashMap<String, String> participationURLs = null;
	public String CaseToRun = null;
	public ArrayList<HashMap<String, String>> credentials = null;
	public HashMap<String, String> users = null;
	public String username = null;
	public String password = null;
	public String nogin = null;
	public String encPassword = null;
	public String DeleteCaseURL = null;
	public String DeleteCasePass = null;
	public static ExtentReports extent = null;
	static public HashMap<String, String> TestResultTL = new HashMap<String, String>();
	public SurveyPage sp = new SurveyPage();
	public LoginPage loginPage = new LoginPage();
	public SMXPage smxPage = new SMXPage();
	public DMXPage dmxPage = new DMXPage();
	public DMXPageEngage dmxPage2 = new DMXPageEngage();
	public RMXPage rmxPage = new RMXPage();
	public DataPage dataPage = new DataPage();
	public RMXPageEngage rmxPageEngage = new RMXPageEngage();
	public DecryptPassword decryptPass = new DecryptPassword();
	protected FetchExcelDataSet fetchExcelData = new FetchExcelDataSet();
	public static final String USERNAME = "gauravgolatkar1";
	public static final String AUTOMATE_KEY = "YzA3qocp3CT7pvq2NtKo";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void init() throws Exception {
		System.out.println("Call Init.");
		
		Add_Log = Logger.getLogger("rootLogger");
		extent = ExtentManager.getExtentInstance();
		TestFile = new Read_XLS(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\Engage_Smoke.xlsx");
		Add_Log.info("Excel file initialized successfully.");
		
		Config = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\Config.properties");
		Config.load(fip);
		Add_Log.info("Config.properties file Loaded successfully.");
		
		System.out.println("After Init.");
	}
	
	@SuppressWarnings("deprecation")
	public void loadBrowser() {
		if(Config.getProperty("testBrowser").equalsIgnoreCase("Mozilla") && ExistingMozillaBrowser!=null) {
			driver.set(ExistingMozillaBrowser);
			return;
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("Chrome") && ExistingChromeBrowser!=null) {
			driver.set(ExistingChromeBrowser);
			return;
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("IE") && ExistingIEBrowser!=null) {
			driver.set(ExistingIEBrowser);
			return;
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("Remote") && ExistingRemoteDriver!=null) {
			driver.set(ExistingRemoteDriver);
			return;
		}
		
		if(Config.getProperty("testBrowser").equalsIgnoreCase("Mozilla")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			Add_Log.info("Firefox Driver instance loaded successfully.");
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
			Add_Log.info("IE Driver instance loaded successfully.");
		} else if (Config.getProperty("testBrowser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
			try {
				FileUtils.forceMkdir(new File(downloadFilePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilePath);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--start-maximized");
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("disable-infobars");
			options.addArguments("--ignore-certificate-errors");

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			cap.setCapability(ChromeOptions.CAPABILITY, options);

			driver.set(new ChromeDriver(cap));
			Add_Log.info("Chrome Driver instance loaded successfully.");

		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("Remote")) {
			DesiredCapabilities caps = new DesiredCapabilities();
		    
		    caps.setCapability("os", Config.getProperty("os"));
		    caps.setCapability("os_version", Config.getProperty("os_version"));
		    caps.setCapability("browser", Config.getProperty("browser"));
		    caps.setCapability("browser_version", Config.getProperty("browser_version"));
		    caps.setCapability("resolution", Config.getProperty("resolution"));
		    caps.setCapability("browserstack.local", Config.getProperty("browserstack.local"));
		    caps.setCapability("browserstack.networkLogs", Config.getProperty("browserstack.networkLogs"));
		    caps.setCapability("browserstack.selenium_versions", Config.getProperty("browserstack.selenium_versions"));
		    caps.setCapability("browserstack.console", Config.getProperty("browserstack.console"));
			try {
				driver.set(new RemoteWebDriver(new URL(URL), caps));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			Add_Log.info("Remote Driver instance loaded successfully.");
			getDriver().manage().window().maximize();
		}
	}
	
	/**
	 * Use this method to load browser for dynamic download file path
	 * @param downloadFilePath
	 */
	@SuppressWarnings("deprecation")
	public void loadBrowser(String downloadFilePath) {
		if(Config.getProperty("testBrowser").equalsIgnoreCase("Mozilla") && ExistingMozillaBrowser!=null) {
			driver.set(ExistingMozillaBrowser);
			return;
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("Chrome") && ExistingChromeBrowser!=null) {
			driver.set(ExistingChromeBrowser);
			return;
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("IE") && ExistingIEBrowser!=null) {
			driver.set(ExistingIEBrowser);
			return;
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("Remote") && ExistingRemoteDriver!=null) {
			driver.set(ExistingRemoteDriver);
			return;
		}
		
		if(Config.getProperty("testBrowser").equalsIgnoreCase("Mozilla")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			Add_Log.info("Firefox Driver instance loaded successfully.");
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
			Add_Log.info("IE Driver instance loaded successfully.");
		} else if (Config.getProperty("testBrowser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			try {
				FileUtils.forceMkdir(new File(downloadFilePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilePath);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("--start-maximized");
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("disable-infobars");
			options.addArguments("--ignore-certificate-errors");

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			cap.setCapability(ChromeOptions.CAPABILITY, options);

			driver.set(new ChromeDriver(cap));
			Add_Log.info("Chrome Driver instance loaded successfully.");

		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("Remote")) {
			DesiredCapabilities caps = new DesiredCapabilities();
		    
		    caps.setCapability("os", Config.getProperty("os"));
		    caps.setCapability("os_version", Config.getProperty("os_version"));
		    caps.setCapability("browser", Config.getProperty("browser"));
		    caps.setCapability("browser_version", Config.getProperty("browser_version"));
		    caps.setCapability("resolution", Config.getProperty("resolution"));
		    caps.setCapability("browserstack.local", Config.getProperty("browserstack.local"));
		    caps.setCapability("browserstack.networkLogs", Config.getProperty("browserstack.networkLogs"));
		    caps.setCapability("browserstack.selenium_versions", Config.getProperty("browserstack.selenium_versions"));
		    caps.setCapability("browserstack.console", Config.getProperty("browserstack.console"));
			try {
				driver.set(new RemoteWebDriver(new URL(URL), caps));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			Add_Log.info("Remote Driver instance loaded successfully.");
			getDriver().manage().window().maximize();
		}
	}
	
	public String getData(LinkedHashMap<String, String> data, String key) {
		if(data.get(key)!=null && data.get(key).length() > 0) {
			return data.get(key);
		} else {
			return "";
		}
	}
	
	public void closeWebBrowser() {
		getDriver().quit();
	}
	
	public String captureScreenShot(ITestResult result, String status, WebDriver driver) {
		String destDir = null;
		String passFailResult = result.getMethod().getRealClass().getSimpleName() +"."+ result.getMethod().getMethodName();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		if(status.equalsIgnoreCase("fail")) {
			destDir = "screenshots/failure";
		} else if(status.equalsIgnoreCase("pass")) {
			destDir = "screenshots/success";
		} 
		new File(destDir).mkdirs();
		String destFile = passFailResult+ "-" +dateFormat.format(new Date())+".jpeg";
		
		File destination = new File(destDir+"/"+destFile);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return System.getProperty("user.dir") + "/" + destDir + "/"+ destFile;
	}
	
	public String takescreenshots(WebDriver driver) {
		Date d = new Date();
		String FileName = this.getClass().getSimpleName()+"_"+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		String FilePath = ".\\Extent Reports\\Screenshots\\"+FileName;
		String FilePath2 = ".\\Screenshots\\"+FileName;
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(FilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FilePath2;
	}
}

package testsuitebase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.JavascriptExecutor;
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
import com.engage.performance.EngageNSReading_TC;

import pageobjects.DMXPage;
import pageobjects.HomePage;
import pageobjects.RMXPage;
import pageobjects.SMXPage;
import pageobjects.StaticPage;
import pageobjects.ZarcaStaticPage;
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
	public Read_XLS platformReadingFile = null;
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
	//static public HashMap<String, String> TestResultTL = new HashMap<String, String>();
	public ZarcaStaticPage staticPage = new ZarcaStaticPage();
	public SMXPage smx = new SMXPage();
	public DMXPage dmx = new DMXPage();
	public RMXPage rmx = new RMXPage();
	public HomePage home = new HomePage();
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
		TestFile = new Read_XLS(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\Engage_NSReadings.xlsx");
		platformReadingFile = new Read_XLS(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\Engage_PlatformReadings.xlsx");
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
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\browserdrivers\\geckodriver.exe");
			driver.set(new FirefoxDriver());
			Add_Log.info("Firefox Driver instance loaded successfully.");
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\browserdrivers\\IEDriverServer.exe");
			driver.set(new InternetExplorerDriver());
			Add_Log.info("IE Driver instance loaded successfully.");
		} else if(Config.getProperty("testBrowser").equalsIgnoreCase("Chrome")) {
			
			  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			  + "\\src\\main\\resources\\browserdrivers\\chromedriver.exe");
			  
			  String downloadFilePath = System.getProperty("user.dir") +
			  "\\src\\main\\resources\\downloadfiles\\";
			  
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
			  cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT); 
			  cap.setCapability(ChromeOptions.CAPABILITY,options);
			  
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
			try {
				driver.set(new RemoteWebDriver(new URL(URL), caps));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			Add_Log.info("Remote Driver instance loaded successfully.");
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
	
	public void sendHtmlFormatMail(String subject, String errorPage, String path, String queryString, String ipAddress, String errors, File file) {
		Add_Log.info("===============Email generation started================");
		// Create the email message
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		/*
		 * To avoid javax.mail.AuthenticationFailedException, 
		 * First, make sure you have turned off 2-way authentication of google account 
		 * Second, allow access for less secure apps- https://myaccount.google.com/lesssecureapps
		 */
		email.setAuthenticator(new DefaultAuthenticator(Config.getProperty("authenticatorEmailId"), Config.getProperty("authenticatorPassword")));
		email.setSSLOnConnect(true);

		try {
			email.addTo(Config.getProperty("addToEmail"));
			email.addCc(Config.getProperty("addCcEmail"));
			email.setFrom(Config.getProperty("setFromEmail"), Config.getProperty("setFromName"));
			email.setSubject(subject);

			// set the html message
			email.setHtmlMsg("<html> Error occured on page : " + errorPage +" <br> Path : " + path +" <br> Query String : " + queryString +" <br> IP Address : " + ipAddress +" <br> <br> <strong> ***************Error Description **************** </strong> <br> "+ errors);

			// set the alternative message
			email.setTextMsg("Your email client does not support HTML messages");
			
			email.attach(file);

			// send the email
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Add_Log.info("===============Email sent================");
	}
	
	public String getIpAddress() {
		URL myIp;
		try {
			myIp = new URL("http://myip.dnsomatic.com/");
			BufferedReader in = new BufferedReader(new InputStreamReader(myIp.openStream()));
			return in.readLine();
		}catch (Exception e1) {
			try {
			myIp = new URL("http://icanhazip.com/");
			BufferedReader in = new BufferedReader(new InputStreamReader(myIp.openStream()));
			return in.readLine();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	public String getErrorPage(WebDriver driver) {
		return (String) ((JavascriptExecutor)driver).executeScript("return window.location.href");		 
	}
	


	
}

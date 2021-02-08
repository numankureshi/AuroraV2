package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import property.IHomePage;
import property.IZarcaStaticPage;
import utility.SeleniumUtils;

public class ZarcaStaticPage extends SeleniumUtils implements IZarcaStaticPage, IHomePage {
	
	public double finish, start;
	public double end;
	
	public double login(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		navigateToZarcaLoginPage(driver, param, URL, test);
		waitforElemPresent(driver, testcaseName, 60, user_name, test);
		setText(driver, testcaseName, user_name, username, test);
		setText(driver, testcaseName, user_pass, password, test);
		start = System.currentTimeMillis();
		click(driver, testcaseName, login_button, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, account_settings, test);
		end = System.currentTimeMillis();
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	public double navigateToZarcaLoginPage(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.get(URL);
		start = System.currentTimeMillis();
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, login_img_static, test);
		end = System.currentTimeMillis();
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}

}

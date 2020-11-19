package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import property.IHomePage;
import property.IStaticPage;
import utility.SeleniumUtils;

public class HomePage extends SeleniumUtils implements IHomePage, IStaticPage {
	public double finish, start;
	public double end;
	
	
	public double logout(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String serverURL = driver.getCurrentUrl();
		click(driver, testcaseName, account_settings, test);

		start = System.currentTimeMillis();
		click(driver, testcaseName, logout_popup_option, test);
		waitForJStoLoad(driver, 60);
		if (serverURL.contains("sogo")) {
			waitforElemPresent(driver, testcaseName, 60, sogo_login_img_static, test);
		} else if (serverURL.contains("k12")) {
			waitforElemPresent(driver, testcaseName, 60, k12_login_img_static, test);
		}
		end = System.currentTimeMillis();

		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	

}

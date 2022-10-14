package property;

import org.openqa.selenium.By;

import utility.WebPageElements;

public interface ILoginPage {

	String USER_NAME = "//input[contains(@name,'txtUsername')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String USER_PASS = "//input[contains(@name,'txtPassword')]";
	WebPageElements user_pass = new WebPageElements("User Password", "xpath", USER_PASS);
	
	String LOGIN_BUTTON = "//input[@class='Loginbtn']";
	WebPageElements login_button = new WebPageElements("Login", "xpath", LOGIN_BUTTON);
	
	String ZARCA_ACCOUNT = "(//span[@class='initials'])[2]";
	WebPageElements zarca_account = new WebPageElements("Zarca Account", "xpath", ZARCA_ACCOUNT);
	
	String ZARCA_BUTTON = "//div[@class='Logoimg masterlogin productLogoMain productLogoM']";
	WebPageElements zarca_button = new WebPageElements("zarca_button", "xpath", ZARCA_BUTTON);
	
	String FORGET_PASSWORD = "//a[normalize-space()='Forgot Password?']";
	WebPageElements forget_password = new WebPageElements("forget password", "xpath", FORGET_PASSWORD);
	
	String FORGET_PASSWORD_SUBMIT = "//input[@id='ctl00_Login_or_ForgotPassword_submit']";
	WebPageElements forget_password_submit = new WebPageElements("forget password submit", "xpath", FORGET_PASSWORD_SUBMIT);
	
	String RETURN_LOGIN = "//input[@id='Submit1']";
	WebPageElements return_login = new WebPageElements("return login", "xpath", RETURN_LOGIN);
	
	String FORGET_PASSWORD_TB = "//input[@id='ctl00_Login_or_ForgotPassword_t1";
	WebPageElements forget_password_tb = new WebPageElements("forget password textbox", "xpath", FORGET_PASSWORD_TB);
	
	
}

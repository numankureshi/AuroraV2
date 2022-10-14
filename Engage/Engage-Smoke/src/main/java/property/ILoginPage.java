package property;

import org.openqa.selenium.By;

import utility.WebPageElements;

public interface ILoginPage {

	String USER_NAME = "//input[contains(@name,'txtUsername')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String USER_PASS = "//input[@type='password']";
	WebPageElements user_pass = new WebPageElements("User Password", "xpath", USER_PASS);
	
	String LOGIN_BUTTON = "//input[@class='Loginbtn']";
	WebPageElements login_button = new WebPageElements("Login Button", "xpath", LOGIN_BUTTON);
	
	String K12_ACCOUNT = "(//span[@class='initials'])[2]";
	WebPageElements k12_account = new WebPageElements("K12 Account", "xpath", K12_ACCOUNT);
	
	String K12_ACCOUNT_BUTTON = "//div[@class='Logoimg']";
	WebPageElements k12_account_button = new WebPageElements("K12 Account button ", "xpath", K12_ACCOUNT_BUTTON);
	
	String FORGET_PASSWORD = "//a[normalize-space()='Forgot Password?']";
	WebPageElements forget_password = new WebPageElements("forget password", "xpath", FORGET_PASSWORD);
	
	String FORGET_PASSWORD_SUBMIT = "//input[@name='Submit']";
	WebPageElements forget_password_submit = new WebPageElements("forget password submit", "xpath", FORGET_PASSWORD_SUBMIT);
	
	String RETURN_LOGIN = "//input[@id='Submit1']";
	WebPageElements return_login = new WebPageElements("return login", "xpath", RETURN_LOGIN);
	
	String FORGET_PASSWORD_TB = "//input[@id='ctl00_Login_or_ForgotPassword_t1";
	WebPageElements forget_password_tb = new WebPageElements("forget password textbox", "xpath", FORGET_PASSWORD_TB);
	
	String RETURN_LOGIN2 = "//ul[@id='main_menu']//a[contains(text(),'Log In')]";
	WebPageElements return_login2 = new WebPageElements("return login2", "xpath", RETURN_LOGIN2);
	
	
	String K12_BUTTON = "//a[@id='custom_logo']//img[@alt='K12 insight']";
	WebPageElements k12_button = new WebPageElements("k12 button", "xpath", K12_BUTTON);
}

package property;

import org.openqa.selenium.By;

import utility.WebPageElements;

public interface ILoginPage {

	String USER_NAME = "//input[contains(@name,'txtUsername')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String USER_PASS = "//input[@type='password']";
	WebPageElements user_pass = new WebPageElements("User Password", "xpath", USER_PASS);
	
	String LOGIN_BUTTON = "//input[@class='Loginbtn']";
	WebPageElements login_button = new WebPageElements("Login", "xpath", LOGIN_BUTTON);
	
	String K12_ACCOUNT = "(//span[@class='initials'])[2]";
	WebPageElements k12_account = new WebPageElements("Sogo Account", "xpath", K12_ACCOUNT);
}

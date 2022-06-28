package property;

import org.openqa.selenium.By;

import utility.WebPageElements;

public interface ILoginPage {

	String USER_NAME = "//input[contains(@name,'txtUsername')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String LOGIN_IMG_STATIC = "//div[@class='Logoimg']";
	WebPageElements login_img_static = new WebPageElements("Login Image Static", "xpath", LOGIN_IMG_STATIC);
	
	String USER_PASS = "//input[@type='password']";
	WebPageElements user_pass = new WebPageElements("User Password", "xpath", USER_PASS);
	
	String LOGIN_BUTTON = "//input[@name='submit']";
	WebPageElements login_button = new WebPageElements("Login", "xpath", LOGIN_BUTTON);
	
	
	
	
	
}

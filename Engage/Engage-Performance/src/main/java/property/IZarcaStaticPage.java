package property;

import utility.WebPageElements;

public interface IZarcaStaticPage {
	
	String USER_NAME = "//input[contains(@name,'txtUsername')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String USER_PASS = "//input[contains(@name,'txtPassword')]";
	WebPageElements user_pass = new WebPageElements("User Password", "xpath", USER_PASS);
	
	String LOGIN_BUTTON = "//input[@value='LOG IN']";
	WebPageElements login_button = new WebPageElements("Login", "xpath", LOGIN_BUTTON);
	
	String LOGIN_IMG_STATIC = "//div[@class='zarca-to-sogo-wrapper']";
	WebPageElements login_img_static = new WebPageElements("Login Image Static", "xpath", LOGIN_IMG_STATIC);

}

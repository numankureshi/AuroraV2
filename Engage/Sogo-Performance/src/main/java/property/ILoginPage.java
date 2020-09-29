package property;

import org.openqa.selenium.By;

import utility.WebPageElements;

public interface ILoginPage {

	String USER_NAME = "//input[contains(@name,'txtUserId')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String LOGIN_BUTTON_STATIC = "(//a[text()='Login'])[1]";
	WebPageElements login_button_static = new WebPageElements("Login Button Static", "xpath", LOGIN_BUTTON_STATIC);
	
	String LOGIN_IMG_STATIC = "//img[@title='SoGoSurvey']";
	WebPageElements login_img_static = new WebPageElements("Login Image Static", "xpath", LOGIN_IMG_STATIC);
	
	String USER_PASS = "//input[contains(@name,'txtPassword')]";
	WebPageElements user_pass = new WebPageElements("User Password", "xpath", USER_PASS);
	
	String LOGIN_BUTTON = "//input[@name='btnLogin']";
	WebPageElements login_button = new WebPageElements("Login", "xpath", LOGIN_BUTTON);
	
	String ACCOUNT_NAME = "//input[contains(@name,'txtAccName')]";
	WebPageElements account_name = new WebPageElements("Account Name", "xpath", ACCOUNT_NAME);
	
	String SOGO_ACCOUNT = "(//span[@class='initials'])[2]";
	WebPageElements sogo_account = new WebPageElements("Sogo Account", "xpath", SOGO_ACCOUNT);
	
	String PRODUCT_STATIC = "(//li[contains(@class,'sogo-product-megamenu')]/a[contains(text(),'Products')])[1]";
	WebPageElements products_static = new WebPageElements("Products on Static", "xpath", PRODUCT_STATIC);
	
	String PRICING_STATIC = "(//a[contains(text(),'Pricing')])[1]";
	WebPageElements pricing_static = new WebPageElements("Pricing on Static", "xpath", PRICING_STATIC);
	
	String PRICING_STATIC_TEXT = "//h1[text()='Compare and choose a plan that is right for you.']";
	WebPageElements pricing_static_text = new WebPageElements("Compare and choose a plan that is right for you.", "xpath", PRICING_STATIC_TEXT);
	
	String TAKE_A_TOUR = "(//span[text()='Take a Tour'])[1]";
	WebPageElements take_a_tour = new WebPageElements("Take a Tour", "xpath", TAKE_A_TOUR);
	
	String TAKE_A_TOUR_REQUEST_DEMO = "//div[contains(@class,'buttons-main-sign-up')]/a[text()='Request a Demo']";
	WebPageElements take_a_tour_request_demo = new WebPageElements("Take a Tour - Request a Demo", "xpath", TAKE_A_TOUR_REQUEST_DEMO);
	
	
}

package property;

import org.openqa.selenium.By;

import utility.WebPageElements;

public interface IStaticPage {

	String USER_NAME = "//input[contains(@name,'txtUserId')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String LOGIN_BUTTON_STATIC = "(//a[text()='Login'])[1]";
	WebPageElements login_button_static = new WebPageElements("Login Button Static", "xpath", LOGIN_BUTTON_STATIC);
	
	String SOGO_LOGIN_IMG_STATIC = "//img[@title='Sogolytics']";
	WebPageElements sogo_login_img_static = new WebPageElements("SoGo Static Login Image", "xpath", SOGO_LOGIN_IMG_STATIC);
	
	String K12_LOGIN_IMG_STATIC = "//div[@class='Logoimg']";
	WebPageElements k12_login_img_static = new WebPageElements("K12 Static Login Image", "xpath", K12_LOGIN_IMG_STATIC);
	
	String USER_PASS = "//input[contains(@name,'txtPassword')]";
	WebPageElements user_pass = new WebPageElements("User Password", "xpath", USER_PASS);
	
	String LOGIN_BUTTON = "//input[@name='btnLogin']";
	WebPageElements login_button = new WebPageElements("Login", "xpath", LOGIN_BUTTON);
	
	String ACCOUNT_NAME = "//input[contains(@name,'txtAccName')]";
	WebPageElements account_name = new WebPageElements("Account Name", "xpath", ACCOUNT_NAME);
	
	String SOGO_ACCOUNT = "(//span[@class='initials'])[2]";
	WebPageElements sogo_account = new WebPageElements("Sogo Account", "xpath", SOGO_ACCOUNT);
	
	String PRODUCT_STATIC = "//li[starts-with(@id,'menu-item-')]/a/div[text()='Products ']";
	WebPageElements products_static = new WebPageElements("Products on Static", "xpath", PRODUCT_STATIC);
	
	String PRICING_STATIC = "(//a[contains(text(),'Pricing')])[1]";
	WebPageElements pricing_static = new WebPageElements("Pricing on Static", "xpath", PRICING_STATIC);
	
	String PRICING_STATIC_TEXT = "//h1[text()='Compare and choose a plan that is right for you.']";
	WebPageElements pricing_static_text = new WebPageElements("Compare and choose a plan that is right for you.", "xpath", PRICING_STATIC_TEXT);
	
	String TAKE_A_TOUR = "(//span[text()='Take a Tour'])[1]";
	WebPageElements take_a_tour = new WebPageElements("Take a Tour", "xpath", TAKE_A_TOUR);
	
	String TAKE_A_TOUR_REQUEST_DEMO = "//div[contains(@class,'buttons-main-sign-up')]/a[text()='Request a Demo']";
	WebPageElements take_a_tour_request_demo = new WebPageElements("Take a Tour - Request a Demo", "xpath", TAKE_A_TOUR_REQUEST_DEMO);
	
	String PRICING_BUY_PLUS_PACKAGE= "//a[contains(@id,'btnProfMonthly')]";
	WebPageElements pricing_buy_plus_package = new WebPageElements("Pricing - buy plus package", "xpath", PRICING_BUY_PLUS_PACKAGE);
	
	String PRICING_BUY_PRO_PACKAGE= "//a[contains(@id,'btnEntMonthly')]";
	WebPageElements pricing_buy_pro_package = new WebPageElements("Pricing - buy pro package", "xpath", PRICING_BUY_PRO_PACKAGE);
	
	String PRICING_BUY_PREMIUM_PACKAGE= "//a[contains(@id,'btnEP')]";
	WebPageElements pricing_buy_premium_package = new WebPageElements("Pricing - buy premium package", "xpath", PRICING_BUY_PREMIUM_PACKAGE);
	
	String REGISTRATION_FIRST_NAME= "//input[@id='txtfirstname']";
	WebPageElements registration_first_name = new WebPageElements("Registration - First Name", "xpath", REGISTRATION_FIRST_NAME);
	
	String REGISTRATION_LAST_NAME= "//input[@id='txtlastname']";
	WebPageElements registration_last_name = new WebPageElements("Registration - Last Name", "xpath", REGISTRATION_LAST_NAME);
	
	String REGISTRATION_USERID= "//input[@id='txtuserId']";
	WebPageElements registration_userid = new WebPageElements("Registration - UserID", "xpath", REGISTRATION_USERID);
	
	String REGISTRATION_PASSWORD= "//input[@id='txtpassword']";
	WebPageElements registration_password = new WebPageElements("Registration - Password", "xpath", REGISTRATION_PASSWORD);
	
	String REGISTRATION_REENTER_PASSWORD= "//input[@id='txtConfirmPassword']";
	WebPageElements registration_reenter_password = new WebPageElements("Registration - Re-enter Password", "xpath", REGISTRATION_REENTER_PASSWORD);
	
	String REGISTRATION_EMAIL_ID= "//input[@id='txtEmailId']";
	WebPageElements registration_email_id = new WebPageElements("Registration - Email ID", "xpath", REGISTRATION_EMAIL_ID);
	
	String REGISTRATION_DISCLAIMER_CHECKBOX= "(//label[contains(@class,'sogo-term-condition')])[1]";
	WebPageElements registration_disclaimer_checkbox = new WebPageElements("Registration - Disclaimer Checkbox", "xpath", REGISTRATION_DISCLAIMER_CHECKBOX);
	
	String REGISTRATION_CREATE_ACC= "//input[@id='btnCreateAccWOCompanyInfo']";
	WebPageElements registration_create_acc = new WebPageElements("Registration - Create Account", "xpath", REGISTRATION_CREATE_ACC);
	
	String REGISTRATION_VALIDATE_USERINFO= "//div[@id='userinfo']";
	WebPageElements registration_validate_userinfo = new WebPageElements("Registration - Validate User Info Message", "xpath", REGISTRATION_VALIDATE_USERINFO);
	
	String BILLING_ADDRESS_FIELD= "//input[@id='ctl00_ContentPlaceHolder1_txtAddress']";
	WebPageElements billing_address_field = new WebPageElements("Billing - Address field", "xpath", BILLING_ADDRESS_FIELD);
	
	
	
}

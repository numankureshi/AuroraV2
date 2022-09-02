package property;

import org.openqa.selenium.By;

import utility.WebPageElements;

public interface ISoGoStaticPage {

	String USER_NAME = "//input[contains(@name,'txtUserId')]";
	WebPageElements user_name = new WebPageElements("User Name", "xpath", USER_NAME);
	
	String LOGIN_BUTTON_STATIC = "(//a[text()='Login'])[1]";
	WebPageElements login_button_static = new WebPageElements("Login Button Static", "xpath", LOGIN_BUTTON_STATIC);
	
	String LOGIN_IMG_STATIC = "//img[@title='Sogolytics']";
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
	
	String ALL_PACKAGES = "//div[@class='pricing-section-package-wrapper']";
	WebPageElements all_packages = new WebPageElements("All Packages", "xpath", ALL_PACKAGES);	
	
	String TAKE_A_TOUR = "(//span[text()='Take a Tour'])[1]";
	WebPageElements take_a_tour = new WebPageElements("Take a Tour", "xpath", TAKE_A_TOUR);
	
	String TAKE_A_TOUR_REQUEST_DEMO = "//div[contains(@class,'sogo-inner-banner')]/a[text()='Request a Demo']";
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
	
	String DISPLAY_VALIDATION_MSG= "//div[@id = 'userinfo']";
	WebPageElements registration_validation_msg = new WebPageElements("Registration - Display validation message", "xpath", DISPLAY_VALIDATION_MSG);
	
	String REGISTRATION_VALIDATE_USERINFO= "//span[contains(text(),'Congratulation! This User ID is available.')]";
	WebPageElements registration_validate_userinfo = new WebPageElements("Registration - Validate User Info Message", "xpath", REGISTRATION_VALIDATE_USERINFO);
	
	String BILLING_ADDRESS_FIELD= "//input[@id='ctl00_ContentPlaceHolder1_txtAddress']";
	WebPageElements billing_address_field = new WebPageElements("Billing - Address field", "xpath", BILLING_ADDRESS_FIELD);
	
	String ACCOUNT_SETTINGS= "//div[contains(@id,'dvAccountSettings')]";
	WebPageElements account_settings = new WebPageElements("Account settings", "xpath", ACCOUNT_SETTINGS);
	
	String LOGOUT_POPUP_OPTION= "//div[contains(text(),'Logout')]";
	WebPageElements logout_popup_option = new WebPageElements("Logout - Popup Option", "xpath", LOGOUT_POPUP_OPTION);
	
	String SIGN_UP= "//div[@id='dvSignupLink']/a";
	WebPageElements sign_up = new WebPageElements("Sign Up", "xpath", SIGN_UP);
			
	
	
	
}

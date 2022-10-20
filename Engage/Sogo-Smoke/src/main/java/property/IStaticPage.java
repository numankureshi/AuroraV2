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
	
	String PRODUCT_STATIC = "(//li[contains(@class,'sogo-product-megamenu')]/a[contains(text(),'Products')])[1]";
	WebPageElements products_static = new WebPageElements("Products on Static", "xpath", PRODUCT_STATIC);
	
	String PRICING_STATIC = "(//a[contains(text(),'Pricing')])[1]";
	WebPageElements pricing_static = new WebPageElements("Pricing on Static", "xpath", PRICING_STATIC);
	
	String PRICING_STATIC_TEXT = "//h1[text()='Compare and choose the plan that’s right for you!']";
	WebPageElements pricing_static_text = new WebPageElements("Compare and choose the plan that is right for you!", "xpath", PRICING_STATIC_TEXT);
	
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
	
	String  FACEBOOK = "//span[normalize-space()='Sign in with Facebook']";
	WebPageElements fb = new WebPageElements("Facebook", "xpath", FACEBOOK );
	
	String  FACEBOOK_USERNAME = "//input[@id='email']";
	WebPageElements fb_username = new WebPageElements("FacebookUsername", "xpath", FACEBOOK_USERNAME );
	
	String  FACEBOOK_PASSWORD = "//input[@id='pass']";
	WebPageElements fb_password = new WebPageElements("FacebookPassword", "xpath", FACEBOOK_PASSWORD );
	
	String  FACEBOOK_LOGIN_BUTTON = "//button[@id='loginbutton']";
	WebPageElements fb_login_button = new WebPageElements("Facebookloginbutton", "xpath", FACEBOOK_LOGIN_BUTTON );
	
	String  FACEBOOK_CONTINUE_BUTTON = "//div[@class='l9j0dhe7 du4w35lb j83agx80 pfnyh3mw taijpn5t bp9cbjyn owycx6da btwxx1t3 kt9q3ron ak7q8e6j isp2s0ed ri5dt5u2 rt8b4zig n8ej3o3l agehan2d sk4xxmp2 rq0escxv d1544ag0 tw6a2znq s1i5eluu qypqp5cg']//div[@class='bp9cbjyn j83agx80 taijpn5t c4xchbtz by2jbhx6 a0jftqn4']";
	WebPageElements fb_continue_button = new WebPageElements("FacebookContinuebutton", "xpath", FACEBOOK_CONTINUE_BUTTON );
	
	String  GOOGLE = "//span[normalize-space()='Sign in with Google']";
	WebPageElements google = new WebPageElements("Google", "xpath", GOOGLE );
	
	String  GOOGLE_USERNAME = "//input[@id='identifierId']";
	WebPageElements google_username = new WebPageElements("Google Username", "xpath", GOOGLE_USERNAME );
	
	String  GOOGLE_PASSWORD = "//input[@name='password']";
	WebPageElements google_password = new WebPageElements("Google Password", "xpath", GOOGLE_PASSWORD );
	
	String  GOOGLE_NEXT_BUTTON = "//span[normalize-space()='Next']";
	WebPageElements google_next_button = new WebPageElements("Googlenextbutton", "xpath", GOOGLE_NEXT_BUTTON );
	
	String  INVALID_USERNAME = "//input[@id='txtUserId']";
	WebPageElements invalid_username = new WebPageElements("Invalid Username", "xpath", INVALID_USERNAME );
	
	String  INVALID_PASSWORD = "//input[@id='txtPassword']";
	WebPageElements invalid_password = new WebPageElements("Invalid Password", "xpath", INVALID_PASSWORD );
	
	String  INVALID_ID_PASS = "//span[contains(text(),'Invalid User ID or Password')]";
	WebPageElements invalid_id_pass = new WebPageElements("Invalid Id Pass Alert", "xpath", INVALID_ID_PASS );
	
	String  INVALID_PASSWORD_IMG = "//img[@src='/AllImages/ProductImages/Product_specifics/error-symbol-login.png']";
	WebPageElements invalid_password_img = new WebPageElements("Invalid Password img", "xpath", INVALID_PASSWORD_IMG );
	
	String  FORGET_PASSWORD = "//a[normalize-space()='Forgot Password?']";
	WebPageElements forget_password = new WebPageElements("forget Password", "xpath", FORGET_PASSWORD );
	
	String  FORGET_PASSWORD_SUBMIT = "//input[@id='btnSubmit']";
	WebPageElements forget_password_submit = new WebPageElements("forget Password submit", "xpath", FORGET_PASSWORD_SUBMIT );

	String  RETURN_LOGIN = "//input[@id='btnReturnLogin']";
	WebPageElements return_login = new WebPageElements("RETURN_LOGIN", "xpath", RETURN_LOGIN );
	
	String  SOGO_TITLE = "//img[@title='Sogolytics']";
	WebPageElements sogo_title = new WebPageElements("sogo title", "xpath", SOGO_TITLE );
	
	String SIGN_UP= "//div[@id='dvSignupLink']/a";
	WebPageElements sign_up = new WebPageElements("Sign Up", "xpath", SIGN_UP);
	
	String ALL_PACKAGES = "//div[@class='pricing-section-package-wrapper']";
	WebPageElements all_packages = new WebPageElements("All Packages", "xpath", ALL_PACKAGES);	
	
	
	String  EYE_ICON = "//img[@id='eyeShow']";
	WebPageElements eye_icon = new WebPageElements("eye icon", "xpath", EYE_ICON );
	
	
	String  PRIVACY_POLICY = "//a[normalize-space()='Privacy Policy']";
	WebPageElements privacy_policy = new WebPageElements("privacy policy", "xpath", PRIVACY_POLICY );
	
	String  TERMS_OF_SERVICE = "//a[normalize-space()='Terms of Service']";
	WebPageElements terms_of_service = new WebPageElements("TERMS OF SERVICE", "xpath", TERMS_OF_SERVICE );
	
	String  ANTI_SPAM_POLICY = "//a[normalize-space()='Anti-Spam Policy']";
	WebPageElements anti_spam_policy = new WebPageElements("anti spam policy", "xpath", ANTI_SPAM_POLICY );
	
	String  DATA_AND_SECURITY = "//a[normalize-space()='Data and Security']";
	WebPageElements data_and_security = new WebPageElements("Data and Security", "xpath", DATA_AND_SECURITY );
	
	String  COMMON_XPATH_FOR_RIGHT_DIV_FEATURES = "//div[@class='sliderpost-container']/div/a";
	WebPageElements common_xpath_for_right_div_features = new WebPageElements("common xpath for right div features", "xpath", COMMON_XPATH_FOR_RIGHT_DIV_FEATURES );
	
}

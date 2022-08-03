package property;

import utility.WebPageElements;

public interface IloginPage {
	
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
	WebPageElements google_username = new WebPageElements("GoogleUsername", "xpath", GOOGLE_USERNAME );
	
	String  GOOGLE_PASSWORD = "//input[@name='password']";
	WebPageElements google_password = new WebPageElements("GooglePassword", "xpath", GOOGLE_PASSWORD );
	
	String  GOOGLE_NEXT_BUTTON = "//span[normalize-space()='Next']";
	WebPageElements google_next_button = new WebPageElements("Googlenextbutton", "xpath", GOOGLE_NEXT_BUTTON );
	
	String SOGO_ACCOUNT = "(//span[@class='initials'])[2]";
	WebPageElements sogo_account = new WebPageElements("Sogo Account", "xpath", SOGO_ACCOUNT);
	
	String  INVALID_USERNAME = "//input[@id='txtUserId']";
	WebPageElements invalid_username = new WebPageElements("InvalidUsername", "xpath", INVALID_USERNAME );
	
	String  INVALID_PASSWORD = "//input[@id='txtPassword']";
	WebPageElements invalid_password = new WebPageElements("InvalidPassword", "xpath", INVALID_PASSWORD );
	
	String  LOGIN = "//input[@id='btnLogin']";
	WebPageElements login = new WebPageElements("Login", "xpath", LOGIN );
	
	String  INVALID_ID_PASS = "//span[contains(text(),'Invalid User ID or Password')]";
	WebPageElements invalid_id_pass = new WebPageElements("InvalidIdPass", "xpath", INVALID_ID_PASS );
}

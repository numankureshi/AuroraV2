package property;

import utility.WebPageElements;

public interface ISurveyPage {

	String SURVEY_PAGE = "//div[@class='bg-overlay']";
	WebPageElements survey_page = new WebPageElements("Suvey Page", "xpath", SURVEY_PAGE);
	
	String NEXT_BUTTON = "//input[@name='BUTTON_NEXT']";
	WebPageElements next_button = new WebPageElements("Next Button", "xpath", NEXT_BUTTON);
	
	String SUBMIT_BUTTON = "//input[@name='BUTTON_SUBMIT']";
	WebPageElements submit_button = new WebPageElements("Submit Button", "xpath", SUBMIT_BUTTON);
	
	String BACK_BUTTON = "//span[text()='Back']";
	WebPageElements back_button = new WebPageElements("Back Button", "xpath", BACK_BUTTON);
	
	String FORM_DESCRIPTION = "//textarea[@name='Description']";
	WebPageElements form_description = new WebPageElements("Form Description", "xpath", FORM_DESCRIPTION);
	
	String FORM_NAME = "//input[@name='FName']";
	WebPageElements form_name = new WebPageElements("Form Name", "xpath", FORM_NAME);
	
	String FORM_EMAIL = "//input[@name='Email']";
	WebPageElements form_email = new WebPageElements("Form Email", "xpath", FORM_EMAIL);
	
	String FORM_PHONE = "//input[@name='Contact']";
	WebPageElements form_phone = new WebPageElements("Form Phone Number", "xpath", FORM_PHONE);
	
	String FORM_SUBMIT_BUTTON = "//input[@name='Submit']/parent::div";
	WebPageElements form_submit_button = new WebPageElements("Form Submit Button", "xpath", FORM_SUBMIT_BUTTON);
	
	String FORM_INTRODUCTION_MSG = "//div[@id='dptintromessage']";
	WebPageElements form_introduction_msg = new WebPageElements("Form - Introduction Message", "xpath", FORM_INTRODUCTION_MSG);
	
	String PAGE_BORDER = "//table[@id='pageBorder']";
	WebPageElements page_border = new WebPageElements("Form", "xpath", PAGE_BORDER);
	
	String THANK_YOU_MESSAGE = "//span[contains(@id,'ThankYouMessage_New')]";
	WebPageElements thank_you_message = new WebPageElements("Thank you Message", "xpath", THANK_YOU_MESSAGE);
}

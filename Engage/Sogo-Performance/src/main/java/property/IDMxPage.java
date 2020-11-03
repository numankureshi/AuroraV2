package property;

import utility.WebPageElements;

public interface IDMxPage {
	
	String QUICK_SEND = "//div[@id='inviteddl_divQuickSend']";
	WebPageElements quick_send = new WebPageElements("Quick send button", "xpath", QUICK_SEND);

}

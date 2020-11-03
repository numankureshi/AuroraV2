package utility;

public class WebPageElements {
	String name = null;
	String locator = null;
	String value = null;
	
	public WebPageElements(String name, String locator, String value) {
		this.name = name;
		this.locator = locator;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocator() {
		return locator;
	}
	
	public void setLocator(String locator) {
		this.locator = locator;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}

package utility;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testsuitebase.TestResultStatus;

public class SeleniumUtils {
	public Logger Add_Log = Logger.getLogger("rootLogger");
	
	public void click(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		WebElement element = null;
		try {
			element = getWebElement(driver, testcaseName, ele, test);
			element.click();
			test.log(Status.INFO, "Successfully clicked on "+ ele.getName() +" element.");
			Add_Log.info("Successfully clicked on "+ ele.getName() +" element.");
			Reporter.log("Successfully clicked on "+ ele.getName() +" element.");
		} catch (Exception e) {
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				test.log(Status.INFO, "Successfully clicked on "+ ele.getName() +" element.");
				Add_Log.info("Successfully clicked on "+ ele.getName() +" element.");
				Reporter.log("Successfully clicked on "+ ele.getName() +" element.");
			} catch (Exception e2) {
				test.log(Status.FAIL, "Not able to click on "+ ele.getName() +" element.");
				Add_Log.info("Not able to click on "+ ele.getName() +" element.");
				Reporter.log("Not able to click on "+ ele.getName() +" element.");
				TestResultStatus.failureReason.add(testcaseName + "| Not able to click on "+ ele.getName() +" element.");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}
	}
	
	public void doubleClick(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		WebElement element = null;
		Actions action = new Actions(driver);
		try {
			element = getWebElement(driver, testcaseName, ele, test);
			action.moveToElement(element).doubleClick(element).build().perform();
			test.log(Status.INFO, "Successfully double clicked on "+ ele.getName() +" element.");
			Add_Log.info("Successfully double clicked on "+ ele.getName() +" element.");
			Reporter.log("Successfully double clicked on "+ ele.getName() +" element.");
		} catch (Exception e) {
				test.log(Status.FAIL, "Not able to click on "+ ele.getName() +" element.");
				Add_Log.info("Not able to double click on "+ ele.getName() +" element.");
				Reporter.log("Not able to double click on "+ ele.getName() +" element.");
				TestResultStatus.failureReason.add(testcaseName + "| Not able to double click on "+ ele.getName() +" element.");
				TestResultStatus.TestFail = true;
				Assert.fail();
		}
	}
	
	public void click(WebDriver driver, String testcaseName, By by, String name, ExtentTest test) {
		WebElement element = driver.findElement(by);
		try {
			element.click();
			test.log(Status.INFO, "Successfully clicked on "+ name +" element.");
			Add_Log.info("Successfully clicked on "+ name +" element.");
			Reporter.log("Successfully clicked on "+ name +" element.");
		} catch (Exception e) {
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				test.log(Status.INFO, "Successfully clicked on "+ name +" element.");
				Add_Log.info("Successfully clicked on "+ name +" element.");
				Reporter.log("Successfully clicked on "+ name +" element.");
			} catch (Exception e2) {
				test.log(Status.FAIL, "Not able to click on "+ name +" element.");
				Add_Log.info("Not able to click on "+ name +" element.");
				Reporter.log("Not able to click on "+ name +" element.");
				TestResultStatus.failureReason.add(testcaseName + "| Not able to click on "+ name +" element.");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}
	}
	
	public void click(WebDriver driver, String testcaseName, WebElement element, String name, ExtentTest test) {
		try {
			element.click();
			test.log(Status.INFO, "Successfully clicked on "+ name +" element.");
			Add_Log.info("Successfully clicked on "+ name +" element.");
			Reporter.log("Successfully clicked on "+ name +" element.");
		} catch (Exception e) {
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				test.log(Status.INFO, "Successfully clicked on "+ name +" element.");
				Add_Log.info("Successfully clicked on "+ name +" element.");
				Reporter.log("Successfully clicked on "+ name +" element.");
			} catch (Exception e2) {
				test.log(Status.FAIL, "Not able to click on "+ name +" element.");
				Add_Log.info("Not able to click on "+ name +" element.");
				Reporter.log("Not able to click on "+ name +" element.");
				TestResultStatus.failureReason.add(testcaseName + "| Not able to click on "+ name +" element.");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}
	}
	
	public void setText(WebDriver driver, String testcaseName, WebPageElements ele, String text, ExtentTest test) {
		WebElement element = null;
		if(text != null) {
			try {
				element = getWebElement(driver, testcaseName, ele, test);
				element.sendKeys(text);
				test.log(Status.INFO, "Successfully entered "+ text + " in "+ ele.getName() +" textbox.");
				Add_Log.info("Successfully entered "+ text + " in "+ ele.getName() +" textbox.");
				Reporter.log("Successfully entered "+ text + " in "+ ele.getName() +" textbox.");
			} catch (Exception e) {
				test.log(Status.FAIL, text + " not entered in "+ ele.getName() +" textbox.");
				Add_Log.info(text + " not entered in "+ ele.getName() +" textbox.");
				Reporter.log(text + " not entered in "+ ele.getName() +" textbox.");
				TestResultStatus.failureReason.add(testcaseName + "| "+ text + " not entered in "+ ele.getName() +" textbox.");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		} else {
			test.log(Status.INFO, ele.getName() +" value is blank.");
			Add_Log.info(ele.getName() +" value is blank.");
			Reporter.log(ele.getName() +" value is blank.");
		}
	}
	
	public void setText(WebDriver driver, String testcaseName, By by, String text, String name, ExtentTest test) {
		WebElement element = driver.findElement(by);
		if(text != null) {
			try {
				element.sendKeys(text);
				test.log(Status.INFO, "Successfully entered "+ text + " in "+ name +" textbox.");
				Add_Log.info("Successfully entered "+ text + " in "+ name +" textbox.");
				Reporter.log("Successfully entered "+ text + " in "+ name +" textbox.");
			} catch (Exception e) {
				test.log(Status.FAIL, text + " not entered in "+ name +" textbox.");
				Add_Log.info(text + " not entered in "+ name +" textbox.");
				Reporter.log(text + " not entered in "+ name +" textbox.");
				TestResultStatus.failureReason.add(testcaseName + "| "+ text + " not entered in "+ name +" textbox.");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		} else {
			test.log(Status.INFO, name +" value is blank.");
			Add_Log.info(name +" value is blank.");
			Reporter.log(name +" value is blank.");
		}
	}
	
	public void setText(WebDriver driver, String testcaseName, WebElement element, String text, String name, ExtentTest test) {
		if(text != null) {
			try {
				element.sendKeys(text);
				test.log(Status.INFO, "Successfully entered "+ text + " in "+ name +" textbox.");
				Add_Log.info("Successfully entered "+ text + " in "+ name +" textbox.");
				Reporter.log("Successfully entered "+ text + " in "+ name +" textbox.");
			} catch (Exception e) {
				test.log(Status.FAIL, text + " not entered in "+ name +" textbox.");
				Add_Log.info(text + " not entered in "+ name +" textbox.");
				Reporter.log(text + " not entered in "+ name +" textbox.");
				TestResultStatus.failureReason.add(testcaseName + "| "+ text + " not entered in "+ name +" textbox.");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		} else {
			test.log(Status.INFO, name +" value is blank.");
			Add_Log.info(name +" value is blank.");
			Reporter.log(name +" value is blank.");
		}
	}
	
	public void setTextPass(WebDriver driver, String testcaseName, WebPageElements ele, String text, ExtentTest test) {
		DecryptPassword decrypt = new DecryptPassword();
		WebElement element = null;
		if(text != null) {
			try {
				element = getWebElement(driver, testcaseName, ele, test);
				element.sendKeys(decrypt.decryptUserPassword(text));
				test.log(Status.INFO, "Successfully entered "+ text + " in "+ ele.getName() +" textbox.");
				Add_Log.info("Successfully entered "+ text + " in "+ ele.getName() +" textbox.");
				Reporter.log("Successfully entered "+ text + " in "+ ele.getName() +" textbox.");
			} catch (Exception e) {
				test.log(Status.FAIL, text + " not entered in "+ ele.getName() +" textbox.");
				Add_Log.info(text + " not entered in "+ ele.getName() +" textbox.");
				Reporter.log(text + " not entered in "+ ele.getName() +" textbox.");
				TestResultStatus.TestFail = true;
				TestResultStatus.failureReason.add(testcaseName + "| "+ text + " not entered in "+ ele.getName() +" textbox.");
				Assert.fail();
			}
		} else {
			test.log(Status.INFO, ele.getName() +" value is blank.");
			Add_Log.info(ele.getName() +" value is blank.");
			Reporter.log(ele.getName() +" value is blank.");
		}
	}
	
	public void waitforElemPresent(WebDriver driver, String testcaseName, int seconds, WebPageElements ele, ExtentTest test) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			if(ele.getLocator().equalsIgnoreCase("xpath")) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("id")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("name")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("classname")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("linktext")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("css")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ele.getValue())));
			}
			test.log(Status.INFO, "Successfully waited for "+ ele.getName() +" to be present on page.");
			Add_Log.info("Successfully waited for "+ ele.getName() +" to be present on page.");
			Reporter.log("Successfully waited for "+ ele.getName() +" to be present on page.");
		} catch (Exception e) {
			test.log(Status.FAIL, ele.getName() +" not present on page.");
			Add_Log.info(ele.getName() +" not present on page.");
			Reporter.log(ele.getName() +" not present on page.");
			TestResultStatus.failureReason.add(testcaseName + "| "+ ele.getName() +" not present on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	

	
	public void waitforElemNotVisible(WebDriver driver, String testcaseName, int seconds, WebPageElements ele, ExtentTest test) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			if(ele.getLocator().equalsIgnoreCase("xpath")) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("id")) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("name")) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("classname")) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("linktext")) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(ele.getValue())));
			} else if(ele.getLocator().equalsIgnoreCase("css")) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ele.getValue())));
			}
			test.log(Status.INFO, "Successfully waited for "+ ele.getName() +" to be disappear on page.");
			Add_Log.info("Successfully waited for "+ ele.getName() +" to be disappear on page.");
			Reporter.log("Successfully waited for "+ ele.getName() +" to be disappear on page.");
		} catch (Exception e) {
			test.log(Status.FAIL, ele.getName() +" is still present on page.");
			Add_Log.info(ele.getName() +" is stillot present on page.");
			Reporter.log(ele.getName() +" is still present on page.");
			TestResultStatus.failureReason.add(testcaseName + "| "+ ele.getName() +" is still present on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void waitforElemPresent(WebDriver driver, String testcaseName, int seconds, By by, String name, ExtentTest test) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			test.log(Status.INFO, "Successfully waited for "+ name +" to be present on page.");
			Add_Log.info("Successfully waited for "+ name +" to be present on page.");
			Reporter.log("Successfully waited for "+ name +" to be present on page.");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, name +" not present on page.");
			Add_Log.info(name +" not present on page.");
			Reporter.log(name +" not present on page.");
			TestResultStatus.failureReason.add(testcaseName + "| "+ name +" not present on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();
			
		}
	}
	
	public void waitforElemPresent(WebDriver driver, String testcaseName, int seconds, WebElement element, String name, ExtentTest test) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			test.log(Status.INFO, "Successfully waited for "+ name +" to be present on page.");
			Add_Log.info("Successfully waited for "+ name +" to be present on page.");
			Reporter.log("Successfully waited for "+ name +" to be present on page.");
		} catch (Exception e) {
			test.log(Status.FAIL, name +" not present on page.");
			Add_Log.info(name +" not present on page.");
			Reporter.log(name +" not present on page.");
			TestResultStatus.failureReason.add(testcaseName + "| "+ name +" not present on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void waitForElementToBeVisible(WebDriver driver, String testcaseName, WebPageElements ele, int timeOutInSeconds, int pollingEveryInMilliSec, ExtentTest test) {
		WebElement element = null;
		try {
			element = getWebElement(driver, testcaseName, ele, test);
			Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
					.pollingEvery(Duration.ofMillis(pollingEveryInMilliSec)).ignoring(NoSuchElementException.class);
			fWait.until(ExpectedConditions.visibilityOf(element));
			test.log(Status.INFO, "Successfully waited for " + ele.getName() + " to be present on page.");
			Add_Log.info("Successfully waited for " + ele.getName() + " to be present on page.");
			Reporter.log("Successfully waited for " + ele.getName() + " to be present on page.");
		} catch (Exception e) {
			test.log(Status.FAIL, ele.getName() + "is not present on page.");
			Add_Log.info(ele.getName() + "is not present on page.");
			Reporter.log(ele.getName() + "is not present on page.");
			TestResultStatus.failureReason.add(testcaseName + "| " + ele.getName() + "is not present on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();

		}
	}
	
	public void waitForElementToBeVisible(WebDriver driver, String testcaseName, WebElement element, String name, int timeOutInSeconds, int pollingEveryInMilliSec, ExtentTest test) {
		try {
			Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
					.pollingEvery(Duration.ofMillis(pollingEveryInMilliSec)).ignoring(NoSuchElementException.class);
			fWait.until(ExpectedConditions.visibilityOf(element));
			test.log(Status.INFO, "Successfully waited for " + name + " to be present on page.");
			Add_Log.info("Successfully waited for " + name + " to be present on page.");
			Reporter.log("Successfully waited for " + name + " to be present on page.");
		} catch (Exception e) {
			test.log(Status.FAIL, name + "is not present on page.");
			Add_Log.info(name + "is not present on page.");
			Reporter.log(name + "is not present on page.");
			TestResultStatus.failureReason.add(testcaseName + "| " + name + "is not present on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();

		}
	}
	
	public void waitForElementToBeVisible(WebDriver driver, String testcaseName, By by, String name, int timeOutInSeconds, int pollingEveryInMilliSec, ExtentTest test) {
		try {
			Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
					.pollingEvery(Duration.ofMillis(pollingEveryInMilliSec)).ignoring(NoSuchElementException.class);
			fWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			test.log(Status.INFO, "Successfully waited for " + name + " to be present on page.");
			Add_Log.info("Successfully waited for " + name + " to be present on page.");
			Reporter.log("Successfully waited for " + name + " to be present on page.");
		} catch (Exception e) {
			test.log(Status.FAIL, name + "is not present on page.");
			Add_Log.info(name + "is not present on page.");
			Reporter.log(name + "is not present on page.");
			TestResultStatus.failureReason.add(testcaseName + "| " + name + "is not present on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();

		}
	}
	
	
	public void waitUntilReqAttribute(WebDriver driver,  String testcaseName, int timeOutInSeconds, final WebPageElements ele,
			final String attribute, final String attributeValue, ExtentTest test) {
		try {
		WebElement element = getWebElement(driver, testcaseName, ele, test);
		long startTime = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return element.getAttribute(attribute).contains(attributeValue);
			}
		});
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;  //Get total wait in milliseconds
		test.log(Status.INFO, "Successfully waited for "+ele.getName()+" to change it's "+attribute+ " attribute value to "+attributeValue+" is "+totalTime+" milliseconds");
		Add_Log.info("Successfully waited for "+ele.getName()+" to change it's "+attribute+ " attribute value to "+attributeValue+" is "+totalTime+" milliseconds");
		Reporter.log("Successfully waited for "+ele.getName()+" to change it's "+attribute+ " attribute value to "+attributeValue+" is "+totalTime+" milliseconds");
		}catch(Exception e) {
			test.log(Status.FAIL, "Attribute value of " + ele.getName() + "is not changed");
			Add_Log.info("Attribute value of " + ele.getName() + "is not changed");
			Reporter.log("Attribute value of " + ele.getName() + "is not changed");
			TestResultStatus.failureReason.add(testcaseName + "| " + "Attribute value of " + ele.getName() + "is not changed");
			TestResultStatus.TestFail = true;
			Assert.fail();		
		}
	}
	
	
	public void waitUntilReqCSSValue(WebDriver driver,  String testcaseName, int timeOutInSeconds, final WebPageElements ele, int elementNo,
			final String cssAttribute, final String cssValue, ExtentTest test) {
		try {
		WebElement element = getWebElements(driver, testcaseName, ele, test).get(elementNo);
		long startTime = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return element.getCssValue(cssAttribute).contains(cssValue);
			}
		});
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;  //Get total wait in milliseconds
		test.log(Status.INFO, "Successfully waited for "+ele.getName()+" to change it's "+cssAttribute+ " attribute value to "+cssValue+" is "+totalTime+" milliseconds");
		Add_Log.info("Successfully waited for "+ele.getName()+" to change it's "+cssAttribute+ " attribute value to "+cssValue+" is "+totalTime+" milliseconds");
		Reporter.log("Successfully waited for "+ele.getName()+" to change it's "+cssAttribute+ " attribute value to "+cssValue+" is "+totalTime+" milliseconds");
		}catch(Exception e) {
			test.log(Status.FAIL, "Attribute value of " + ele.getName() + "is not changed");
			Add_Log.info("Attribute value of " + ele.getName() + "is not changed");
			Reporter.log("Attribute value of " + ele.getName() + "is not changed");
			TestResultStatus.failureReason.add(testcaseName + "| " + "Attribute value of " + ele.getName() + "is not changed");
			TestResultStatus.TestFail = true;
			Assert.fail();		
		}
	}
	
	
	public WebElement getWebElement(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		WebElement element = null;
		try {
			if(ele.getLocator().equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("name")) {
				element = driver.findElement(By.name(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("classname")) {
				element = driver.findElement(By.className(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("linktext")) {
				element = driver.findElement(By.linkText(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("partiallinktext")) {
				element = driver.findElement(By.partialLinkText(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("css")) {
				element = driver.findElement(By.cssSelector(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("tagname")) {
				element = driver.findElement(By.tagName(ele.getValue()));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to find element "+ ele.getName() +" on page.");
			Add_Log.info("Not able to find element "+ ele.getName() +" on page.");
			Reporter.log("Not able to find element "+ ele.getName() +" on page.");
			TestResultStatus.failureReason.add(testcaseName + "| Not able to find element "+ ele.getName() +" on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		if(element == null) {
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		return element;
	}
	
	public List<WebElement> getWebElements(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		List<WebElement> element = null;
		try {
			if(ele.getLocator().equalsIgnoreCase("xpath")) {
				element = driver.findElements(By.xpath(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("id")) {
				element = driver.findElements(By.id(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("name")) {
				element = driver.findElements(By.name(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("classname")) {
				element = driver.findElements(By.className(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("linktext")) {
				element = driver.findElements(By.linkText(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("partiallinktext")) {
				element = driver.findElements(By.partialLinkText(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("css")) {
				element = driver.findElements(By.cssSelector(ele.getValue()));
			} else if(ele.getLocator().equalsIgnoreCase("tagname")) {
				element = driver.findElements(By.tagName(ele.getValue()));
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to find element "+ ele.getName() +" on page.");
			Add_Log.info("Not able to find element "+ ele.getName() +" on page.");
			Reporter.log("Not able to find element "+ ele.getName() +" on page.");
			TestResultStatus.failureReason.add(testcaseName + "| Not able to find element "+ ele.getName() +" on page.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		return element;
	}
	
	
	public String getText(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		String text = null;
		WebElement element = null;
			try {
				element = getWebElement(driver, testcaseName, ele, test);
				text = element.getText();
				test.log(Status.INFO, "Successfully fetched text "+ text + " from "+ ele.getName());
				Add_Log.info("Successfully fetched text "+ text + " from "+ ele.getName());
				Reporter.log("Successfully fetched text "+ text + " from "+ ele.getName());
			} catch (Exception e) {
				test.log(Status.FAIL, "Not able to fetch text "+ text + " from "+ ele.getName());
				Add_Log.info("Not able to fetch text "+ text + " from "+ ele.getName());
				Reporter.log("Not able to fetch text "+ text + " from "+ ele.getName());
				TestResultStatus.failureReason.add(testcaseName + "| Not able to fetch text "+ text + " from "+ ele.getName());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		return text;
	}
	
	public String getText(WebDriver driver, String testcaseName, By by, String name, ExtentTest test) {
		String text = null;
		WebElement element = driver.findElement(by);
			try {
				text = element.getText();
				test.log(Status.INFO, "Successfully fetched text "+ text + " from "+ name);
				Add_Log.info("Successfully fetched text "+ text + " from "+ name);
				Reporter.log("Successfully fetched text "+ text + " from "+ name);
			} catch (Exception e) {
				test.log(Status.FAIL, "Not able to fetch text "+ text + " from "+ name);
				Add_Log.info("Not able to fetch text "+ text + " from "+ name);
				Reporter.log("Not able to fetch text "+ text + " from "+ name);
				TestResultStatus.failureReason.add(testcaseName + "| Not able to fetch text "+ text + " from "+ name);
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
			return text;
	}
	
	public String getValue(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		String text = null;
		WebElement element = null;
			try {
				element = getWebElement(driver, testcaseName, ele, test);
				text = element.getAttribute("value");
				test.log(Status.INFO, "Successfully fetched value "+ text + " from "+  ele.getName());
				Add_Log.info("Successfully fetched value "+ text + " from "+ ele.getName());
				Reporter.log("Successfully fetched value "+ text + " from "+ ele.getName());
			} catch (Exception e) {
				test.log(Status.FAIL, "Not able to fetch value "+ text + " from "+ ele.getName());
				Add_Log.info("Not able to fetch value "+ text + " from "+ ele.getName());
				Reporter.log("Not able to fetch value "+ text + " from "+ ele.getName());
				TestResultStatus.failureReason.add(testcaseName + "| Not able to fetch value "+ text + " from "+ ele.getName());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
			return text;
	}
	
	public String getValue(WebDriver driver, String testcaseName, By by, String name, ExtentTest test) {
		String text = null;
		WebElement element = driver.findElement(by);
			try {
				text = element.getAttribute("value");
				test.log(Status.INFO, "Successfully fetched value "+ text + " from "+ name);
				Add_Log.info("Successfully fetched value "+ text + " from "+ name);
				Reporter.log("Successfully fetched value "+ text + " from "+ name);
			} catch (Exception e) {
				test.log(Status.FAIL, "Not able to fetch value "+ text + " from "+ name);
				Add_Log.info("Not able to fetch value "+ text + " from "+ name);
				Reporter.log("Not able to fetch value "+ text + " from "+ name);
				TestResultStatus.failureReason.add(testcaseName + "| Not able to fetch value "+ text + " from "+ name);
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
			return text;
	}
	
	public void clearText(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		WebElement element = null;
			try {
				element = getWebElement(driver, testcaseName, ele, test);
				element.clear();
				test.log(Status.INFO, "Successfully cleared text from "+ ele.getName() +" textbox");
				Add_Log.info("Successfully cleared text from "+ ele.getName() +" textbox");
				Reporter.log("Successfully cleared text from "+ ele.getName() +" textbox");
			} catch (Exception e) {
				test.log(Status.FAIL, "Text not cleared from "+ ele.getName() +" textbox");
				Add_Log.info("Text not cleared from "+ ele.getName() +" textbox");
				Reporter.log("Text not cleared from "+ ele.getName() +" textbox");
				TestResultStatus.failureReason.add(testcaseName + "| Text not cleared from "+ ele.getName() +" textbox");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		
	}
	
	public void clearText(WebDriver driver, String testcaseName, By by, String name, ExtentTest test) {
		WebElement element = driver.findElement(by);
			try {
				element.clear();
				test.log(Status.INFO, "Successfully cleared text from "+ name +" textbox");
				Add_Log.info("Successfully cleared text from "+ name +" textbox");
				Reporter.log("Successfully cleared text from "+ name +" textbox");
			} catch (Exception e) {
				test.log(Status.FAIL, "Text not cleared from "+ name +" textbox");
				Add_Log.info("Text not cleared from "+ name +" textbox");
				Reporter.log("Text not cleared from "+ name +" textbox");
				TestResultStatus.failureReason.add(testcaseName + "| Text not cleared from "+ name +" textbox");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		
	}
	
	public void clearText(WebDriver driver, String testcaseName, WebElement element, String name, ExtentTest test) {
			try {
				element.clear();
				test.log(Status.INFO, "Successfully cleared text from "+ name +" textbox");
				Add_Log.info("Successfully cleared text from "+ name +" textbox");
				Reporter.log("Successfully cleared text from "+ name +" textbox");
			} catch (Exception e) {
				test.log(Status.FAIL, "Text not cleared from "+ name +" textbox");
				Add_Log.info("Text not cleared from "+ name +" textbox");
				Reporter.log("Text not cleared from "+ name +" textbox");
				TestResultStatus.failureReason.add(testcaseName + "| Text not cleared from "+ name +" textbox");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		
	}
	
	public void scrollIntoView(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		try {
			WebElement element = getWebElement(driver, testcaseName, ele, test);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to scrolling on element "+ ele.getName());
			Add_Log.info("Failed to scrolling on element "+ ele.getName());
			Reporter.log("Failed to scrolling on element "+ ele.getName());
			TestResultStatus.failureReason.add(testcaseName + "| Failed to scrolling on element "+ ele.getName());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void scrollIntoView(WebDriver driver, String testcaseName, By by, String name, ExtentTest test) {
		WebElement element = driver.findElement(by);
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to scrolling on element "+ name);
			Add_Log.info("Failed to scrolling on element "+ name);
			Reporter.log("Failed to scrolling on element "+ name);
			TestResultStatus.failureReason.add(testcaseName + "| Failed to scrolling on element "+ name);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void scrollIntoView(WebDriver driver, String testcaseName, WebElement element, String name, ExtentTest test) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to scrolling on element "+ name);
			Add_Log.info("Failed to scrolling on element "+ name);
			Reporter.log("Failed to scrolling on element "+ name);
			TestResultStatus.failureReason.add(testcaseName + "| Failed to scrolling on element "+ name);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void scrollIntoCenter(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		try {
			WebElement element = getWebElement(driver, testcaseName, ele, test);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to scrolling on element "+ ele.getName());
			Add_Log.info("Failed to scrolling on element "+ ele.getName());
			Reporter.log("Failed to scrolling on element "+ ele.getName());
			TestResultStatus.failureReason.add(testcaseName + "| Failed to scrolling on element "+ ele.getName());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void scrollIntoCenter(WebDriver driver, String testcaseName, WebElement element, String name, ExtentTest test) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
			test.log(Status.INFO, "Successfully move to :" +name);
			Add_Log.info("Successfully move to :" +name);
			Reporter.log("Successfully move to :" +name);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to scrolling on element "+ name);
			Add_Log.info("Failed to scrolling on element "+ name);
			Reporter.log("Failed to scrolling on element "+ name);
			TestResultStatus.failureReason.add(testcaseName + "| Failed to scrolling on element "+ name);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void scrollIntoCenter(WebDriver driver, String testcaseName, By by, String name, ExtentTest test) {
		WebElement element = driver.findElement(by);
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
			test.log(Status.INFO, "Successfully move to :" +name);
			Add_Log.info("Successfully move to :" +name);
			Reporter.log("Successfully move to :" +name);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to scrolling on element "+ name);
			Add_Log.info("Failed to scrolling on element "+ name);
			Reporter.log("Failed to scrolling on element "+ name);
			TestResultStatus.failureReason.add(testcaseName + "| Failed to scrolling on element "+ name);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void reportPass(String passMessage, ExtentTest test) {
		Add_Log.info(passMessage);
		Reporter.log(passMessage);
		test.pass(passMessage);
	}
	
	public void reportFail(String testcaseName, String failureMessage, ExtentTest test) {
		Add_Log.info(failureMessage);
		Reporter.log(failureMessage);
		test.fail(failureMessage);
		TestResultStatus.failureReason.add(testcaseName + "| "+ failureMessage);
		TestResultStatus.TestFail = true;
		Assert.fail(failureMessage);
	}
	
	public void waitForLoad(WebDriver driver, String testcaseName, int seconds, ExtentTest test) {
		try {
			try {
				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(1, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
				fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='loader-parent']")));
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='loader-parent']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			} finally {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='loader-parent']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Loader did not disappear.");
			Add_Log.info("Loader did not disappear.");
			Reporter.log("Loader did not disappear.");
			TestResultStatus.failureReason.add(testcaseName + "| Loader did not disappear.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void waitForGhostLoader(WebDriver driver, String testcaseName, int seconds, ExtentTest test) {
		try {
			try {
				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
				fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='loading-skeleton']")));
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='loading-skeleton']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			} finally {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='loading-skeleton']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Loader did not disappear.");
			Add_Log.info("Loader did not disappear.");
			Reporter.log("Loader did not disappear.");
			TestResultStatus.failureReason.add(testcaseName + "| Loader did not disappear.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void waitForInsideLoad(WebDriver driver, String testcaseName, int seconds, ExtentTest test) {
		try {
			try {
				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(1, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
				fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='insideLoader']")));
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='insideLoader']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			} finally {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='insideLoader']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Loader did not disappear.");
			Add_Log.info("Loader did not disappear.");
			Reporter.log("Loader did not disappear.");
			TestResultStatus.failureReason.add(testcaseName + "| Loader did not disappear.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}

	
	public void waitForLoadAttach(WebDriver driver, String testcaseName, int seconds, ExtentTest test) {
		try {
			try {
				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(1, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
				fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='attachedLoader']")));
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='attachedLoader']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			} finally {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='attachedLoader']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Loader did not disappear.");
			Add_Log.info("Loader did not disappear.");
			Reporter.log("Loader did not disappear.");
			TestResultStatus.failureReason.add(testcaseName + "| Loader did not disappear.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	
	
	public void waitForLoad2(WebDriver driver, String testcaseName, int seconds, ExtentTest test) {
		try {
			try {
				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(1, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
				fWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='attachedLoader']")));
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='attachedLoader']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			} finally {
				WebDriverWait wait = new WebDriverWait(driver, seconds);
				wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='attachedLoader']"))));
				test.log(Status.INFO, "Successfully waited for loader to disappear.");
				Add_Log.info("Successfully waited for loader to disappear.");
				Reporter.log("Successfully waited for loader to disappear.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Loader did not disappear.");
			Add_Log.info("Loader did not disappear.");
			Reporter.log("Loader did not disappear.");
			TestResultStatus.failureReason.add(testcaseName + "| Loader did not disappear.");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public boolean waitForJStoLoad(WebDriver driver, long timeOutInSeconds) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		//Thread.sleep(1000);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	
	public void clickAtOffset(WebDriver driver, String testcaseName, WebPageElements ele, int x, int y, ExtentTest test) {
		
		WebElement element = null;
		try {
			Actions act = new Actions(driver);
			element = getWebElement(driver, testcaseName, ele, test);
			act.moveToElement(element, x, y).click().build().perform();
			Add_Log.info("Successfully click on " + ele.getName() +"by offset of (" +x +"\",\"" +y +")");
			test.log(Status.INFO, "Successfully click on " + ele.getName() +"by offset of (" +x +"\",\"" +y +")");
			Reporter.log("Successfully click on " + ele.getName() +"by offset of (" +x +"\",\"" +y +")");
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to click on "+ ele.getName() +" element. Adjust the x and y co-ordinate");
			Add_Log.info("Not able to click on "+ ele.getName() +" element. Adjust the x and y co-ordinate");
			Reporter.log("Not able to click on "+ ele.getName() +" element. Adjust the x and y co-ordinate");
			TestResultStatus.failureReason.add(testcaseName + "| Not able to click on "+ ele.getName() +" element. Adjust the x and y co-ordinate");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		
	}
	
	
	public void switchToIframe(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {
		WebElement element = null;
		try {
			element = getWebElement(driver, testcaseName, ele, test);
			driver.switchTo().frame(element);
			Add_Log.info("Successfully switch to " + ele.getName());
			test.log(Status.INFO, "Successfully switch to " + ele.getName());
			Reporter.log("Successfully switch to " + ele.getName());
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to switch to "+ ele.getName());
			Add_Log.info("Not able to switch to "+ ele.getName());
			Reporter.log("Not able to switch to "+ ele.getName());
			TestResultStatus.failureReason.add(testcaseName + "| Not able to switch to "+ ele.getName());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}

	}
	
	
	public void dragAndDropAction(WebDriver driver, String testcaseName, WebPageElements source, WebPageElements target, ExtentTest test) {		
		WebElement source_element = null;
		WebElement target_element = null;
		try {
			Actions act = new Actions(driver);
			source_element = getWebElement(driver, testcaseName, source, test);
			target_element = getWebElement(driver, testcaseName, target, test);			
			act.dragAndDrop(source_element, target_element).perform();
			Add_Log.info("Successfully moved " + source.getName() +" to " +target.getName());
			test.log(Status.INFO, "Successfully moved " + source.getName() +" to " +target.getName());
			Reporter.log("Successfully moved " + source.getName() +" to " +target.getName());
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to move "+ source.getName() +"to " +target.getName());
			Add_Log.info("Not able to move "+ source.getName() +"to " +target.getName());
			Reporter.log("Not able to move "+ source.getName() +"to " +target.getName());
			TestResultStatus.failureReason.add(testcaseName + "| Not able to move "+ source.getName() +"to " +target.getName());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}	
	}
	
	public void dragAndDropAction2(WebDriver driver, String testcaseName, WebPageElements source, WebElement target, ExtentTest test) {		
		WebElement source_element = null;
		try {
			Actions act = new Actions(driver);
			source_element = getWebElement(driver, testcaseName, source, test);
			act.dragAndDrop(source_element, target).perform();
			Add_Log.info("Successfully moved " + source.getName() +" to target");
			test.log(Status.INFO, "Successfully moved " + source.getName() +" to target");
			Reporter.log("Successfully moved " + source.getName() +" to target");
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to move "+ source.getName() +"to target");
			Add_Log.info("Not able to move "+ source.getName() +"to target");
			Reporter.log("Not able to move "+ source.getName() +"to target");
			TestResultStatus.failureReason.add(testcaseName + "| Not able to move "+ source.getName() +"to target");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}	
	}
	
	
	public void hoverAction(WebDriver driver, String testcaseName, WebPageElements ele, ExtentTest test) {		
		WebElement element = null;
		try {
			Actions act = new Actions(driver);
			element = getWebElement(driver, testcaseName, ele, test);
			act.moveToElement(element).perform();
			Add_Log.info("Successfully move on to " + ele.getName());
			test.log(Status.INFO, "Successfully move on to " + ele.getName());
			Reporter.log("Successfully move on to " + ele.getName());
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to move to "+ ele.getName());
			Add_Log.info("Not able to move to "+ ele.getName());
			Reporter.log("Not able to move to "+ ele.getName());
			TestResultStatus.failureReason.add(testcaseName + "| Not able to move to "+ ele.getName());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}	
	}
	
	public void hoverAction(WebDriver driver, String testcaseName, By by, String name, ExtentTest test) {		
		WebElement element = null;
		try {
			Actions act = new Actions(driver);
			element = driver.findElement(by);
			act.moveToElement(element).perform();
			Add_Log.info("Successfully move on to " + name);
			test.log(Status.INFO, "Successfully move on to " + name);
			Reporter.log("Successfully move on to " + name);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to move to "+ name);
			Add_Log.info("Not able to move to "+ name);
			Reporter.log("Not able to move to "+ name);
			TestResultStatus.failureReason.add(testcaseName + "| Not able to move to "+ name);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}	
	}
	
	
	public void hoverAction(WebDriver driver, String testcaseName, WebElement element, String name, ExtentTest test) {		
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			Add_Log.info("Successfully hover on to " + name);
			test.log(Status.INFO, "Successfully hover on to " + name);
			Reporter.log("Successfully hover on to " + name);
		} catch (Exception e) {
			test.log(Status.FAIL, "Not able to hover to "+ name);
			Add_Log.info("Not able to hover to "+ name);
			Reporter.log("Not able to hover to "+ name);
			TestResultStatus.failureReason.add(testcaseName + "| Not able to hover to "+ name);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}	
	}
	
	
	
	
	
	public Object executeScript(WebDriver driver, String testcaseName, String script, ExtentTest test) {
		Object result = null;
		try {
			JavascriptExecutor exe = (JavascriptExecutor) driver;
			result = exe.executeScript(script);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to execute script :" + script);
			Add_Log.info("Failed to execute script :" + script);
			Reporter.log("Failed to execute script :" + script);
			TestResultStatus.failureReason.add(testcaseName + "| Failed to execute script :" + script);
			TestResultStatus.TestFail = true;
			Assert.fail();

		}
		return result;
	}
	
	public Object executeScript(WebDriver driver, String testcaseName, String script, WebElement element, ExtentTest test) {
		Object result = null;
		try {
			JavascriptExecutor exe = (JavascriptExecutor) driver;
			result = exe.executeScript(script, element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to execute script :" + script);
			Add_Log.info("Failed to execute script :" + script);
			Reporter.log("Failed to execute script :" + script);
			TestResultStatus.failureReason.add(testcaseName + "| Failed to execute script :" + script);
			TestResultStatus.TestFail = true;
			Assert.fail();

		}
		return result;
	}
	
	public Object executeScript(WebDriver driver, String testcaseName, String script, WebPageElements ele, ExtentTest test) {
		Object result = null;
		WebElement element = null;
		try {
			element = getWebElement(driver, testcaseName, ele, test);
			JavascriptExecutor exe = (JavascriptExecutor) driver;
			result = exe.executeScript(script,element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to execute script :" + script);
			Add_Log.info("Failed to execute script :" + script);
			Reporter.log("Failed to execute script :" + script);
			TestResultStatus.failureReason.add(testcaseName + "| Failed to execute script :" + script);
			TestResultStatus.TestFail = true;
			Assert.fail();

		}
		return result;
	}
	
	
	public void waitForElementToBePresentOnDOM(WebDriver driver, String testcaseName, int timeOutInSeconds,
			WebPageElements ele, ExtentTest test) {
		List<WebElement> element = getWebElements(driver, testcaseName, ele, test);
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return element.size() > 0;
				}
			});
			Add_Log.info("Successfully waited for " + ele.getName() + " to be appear on DOM");
			test.log(Status.INFO, "Successfully waited for " + ele.getName() + " to be appear on DOM");
			Reporter.log("Successfully waited for " + ele.getName() + " to be appear on DOM");
		} catch (Exception e) {
			test.log(Status.FAIL, ele.getName() + " did not appear on DOM");
			Add_Log.info(ele.getName() + " did not appear on DOM");
			Reporter.log(ele.getName() + " did not appear on DOM");
			TestResultStatus.failureReason.add(testcaseName + "| " + ele.getName() + " did not appear on DOM");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}

	}
	
	
	public void selectByVisibleText(WebDriver driver, String testcaseName, WebPageElements ele, String visibleText,
			ExtentTest test) {
		Select select = new Select(getWebElement(driver, testcaseName, ele, test));
		List<WebElement> listOfOptions = select.getOptions();
		String selValue = null;
		try {
			for (WebElement option : listOfOptions) {
				String optionText = Jsoup.parse(option.getAttribute("innerHTML")).text();
				if (optionText.contains(visibleText)) {
					selValue = option.getAttribute("value");
					select.selectByValue(selValue);
					Add_Log.info("Successfully selected option containing text "+visibleText);
					test.log(Status.INFO, "Successfully selected option containing text "+visibleText);
					Reporter.log("Successfully selected option containing text "+visibleText);
					break;
				}
	
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Did not find the option containing text "+visibleText);
			Add_Log.info("Did not find the option containing text "+visibleText);
			Reporter.log("Did not find the option containing text "+visibleText);
			TestResultStatus.failureReason.add(testcaseName + "| " + "Did not find the option containing text "+visibleText);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void selectByVisibleText(WebDriver driver, String testcaseName, By by, String visibleText,
			ExtentTest test) {
		Select select = new Select(driver.findElement(by));
		List<WebElement> listOfOptions = select.getOptions();
		String selValue = null;
		try {
			for (WebElement option : listOfOptions) {
				String optionText = Jsoup.parse(option.getAttribute("innerHTML")).text();
				if (optionText.contains(visibleText)) {
					selValue = option.getAttribute("value");
					select.selectByValue(selValue);
					Add_Log.info("Successfully selected option containing text "+visibleText);
					test.log(Status.INFO, "Successfully selected option containing text "+visibleText);
					Reporter.log("Successfully selected option containing text "+visibleText);
					break;
				}	
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Did not find the option containing text "+visibleText);
			Add_Log.info("Did not find the option containing text "+visibleText);
			Reporter.log("Did not find the option containing text "+visibleText);
			TestResultStatus.failureReason.add(testcaseName + "| " + "Did not find the option containing text "+visibleText);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void selectByVisibleText(WebDriver driver, String testcaseName, WebElement element, String visibleText,
			ExtentTest test) {
		Select select = new Select(element);
		List<WebElement> listOfOptions = select.getOptions();
		String selValue = null;
		try {
			for (WebElement option : listOfOptions) {
				String optionText = Jsoup.parse(option.getAttribute("innerHTML")).text();
				if (optionText.contains(visibleText)) {
					selValue = option.getAttribute("value");
					select.selectByValue(selValue);
					Add_Log.info("Successfully selected option containing text "+visibleText);
					test.log(Status.INFO, "Successfully selected option containing text "+visibleText);
					Reporter.log("Successfully selected option containing text "+visibleText);
					break;
				}	
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Did not find the option containing text "+visibleText);
			Add_Log.info("Did not find the option containing text "+visibleText);
			Reporter.log("Did not find the option containing text "+visibleText);
			TestResultStatus.failureReason.add(testcaseName + "| " + "Did not find the option containing text "+visibleText);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void selectByExactVisibleText(WebDriver driver, String testcaseName, WebPageElements ele, String visibleText,
			ExtentTest test) {
		Select select = new Select(getWebElement(driver, testcaseName, ele, test));
		try {
			select.selectByVisibleText(visibleText);
			Add_Log.info("Successfully selected option maching with text " + visibleText);
			test.log(Status.INFO, "Successfully selected option maching with text " + visibleText);
			Reporter.log("Successfully selected option maching with text " + visibleText);
		}
		 catch (Exception e) {
			test.log(Status.FAIL, "Did not find the option maching with text "+visibleText);
			Add_Log.info("Did not find the option maching with text "+visibleText);
			Reporter.log("Did not find the option maching with text "+visibleText);
			TestResultStatus.failureReason.add(testcaseName + "| " + "Did not find the option maching with text "+visibleText);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
	}
	
	public void waitForAlert(WebDriver driver, String testcaseName, int seconds, ExtentTest test) {
			try {
				FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).ignoring(NoAlertPresentException.class).withTimeout(Duration.ofSeconds(seconds))
						.pollingEvery(Duration.ofMillis(100));
				fWait.until(ExpectedConditions.alertIsPresent());
				Add_Log.info("Successfully waited for alert.");
				test.log(Status.INFO, "Successfully waited for alert.");
				Reporter.log("Successfully waited for alert.");
			} catch (Exception e) {
				test.log(Status.FAIL, "Did not find the alert.");
				Add_Log.info("Did not find the alert.");
				Reporter.log("Did not find the alert.");
				TestResultStatus.failureReason.add(testcaseName + "| " + "Did not find the alert.");
				TestResultStatus.TestFail = true;
				Assert.fail();
			} 
	}

	
	

}

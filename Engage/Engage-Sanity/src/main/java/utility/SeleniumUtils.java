package utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
			action.doubleClick(element).build().perform();
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
	
	public void waitforElemPresent(WebDriver driver, String testcaseName, int seconds, By by, String name, ExtentTest test) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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
		Thread.sleep(1000);
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

}

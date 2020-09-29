package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.ISurveyPage;
import utility.SeleniumUtils;

public class SurveyPage extends SeleniumUtils implements ISurveyPage {

	public void checkSurveyForm(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.get(param.get("URL"));
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 100, survey_page, test);
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		click(driver, testcaseName,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		String value = driver.findElement(By.xpath("//span[text()='" + param.get("radiovalue") + "']"))
				.getCssValue("font-weight");
		if (driver.findElement(By.xpath("//span[text()='" + param.get("radiovalue") + "']")).getCssValue("font-weight")
				.contains("700")) {
			reportPass("The Radio button '" + param.get("radiovalue") + "' is selected on the survey page", test);
		} else {
			reportFail(testcaseName,
					"The Radio button '" + param.get("radiovalue") + "' is not selected on the survey page", test);
		}
		waitforElemPresent(driver, testcaseName, 10, next_button, test);
		click(driver, testcaseName, next_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 10, back_button, test);
		click(driver, testcaseName, back_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 10, next_button, test);
		click(driver, testcaseName, next_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		click(driver, testcaseName,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		if (driver.findElement(By.xpath("//span[text()='" + param.get("radiovalue") + "']")).getCssValue("font-weight")
				.contains("700")) {
			reportPass("The Radio button '" + param.get("radiovalue") + "' is selected on the survey page", test);
		} else {
			reportFail(testcaseName,
					"The Radio button '" + param.get("radiovalue") + "' is not selected on the survey page", test);
		}
		waitforElemPresent(driver, testcaseName, 10, next_button, test);
		click(driver, testcaseName, next_button, test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		click(driver, testcaseName,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		if (driver.findElement(By.xpath("//span[text()='" + param.get("radiovalue") + "']")).getCssValue("font-weight")
				.contains("700")) {
			reportPass("The Radio button '" + param.get("radiovalue") + "' is selected on the survey page", test);
		} else {
			reportFail(testcaseName,
					"The Radio button '" + param.get("radiovalue") + "' is not selected on the survey page", test);
		}
		waitforElemPresent(driver, testcaseName, 10, next_button, test);
		click(driver, testcaseName, next_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		click(driver, testcaseName,
				By.xpath("//span[text()='" + param.get("radiovalue") + "']/parent::span/preceding-sibling::span[1]"),
				"Radio Value:" + param.get("radiovalue"), test);
		if (driver.findElement(By.xpath("//span[text()='" + param.get("radiovalue") + "']")).getCssValue("font-weight")
				.contains("700")) {
			reportPass("The Radio button '" + param.get("radiovalue") + "' is selected on the survey page", test);
		} else {
			reportFail(testcaseName,
					"The Radio button '" + param.get("radiovalue") + "' is not selected on the survey page", test);
		}
		waitforElemPresent(driver, testcaseName, 10, submit_button, test);
		click(driver, testcaseName, submit_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//span[text()='" + param.get("expected") + "']"),
				"Thank you Page", test);

	}

	public void surveyParticipation(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.get(param.get("URL"));
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 100, page_border, test);
		pageOne(driver, param, test);
		pageTwo(driver, param, test);
		pageThree(driver, param, test);
		checkThankYouMessage(driver, param, test);
	}

	public void pageOne(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		surveyHeader(driver, param, test);
		checkTextBox(driver, param, test);
		checkRadioButton(driver, param, param.get("RadioBtn"), test);
		checkCheckBox(driver, param, test);
		checkDropDown(driver, param, test);
		checkDemographics(driver, param, test);
		checkRatingSlider(driver, param, test);
		checkMultiRatings(driver, param, test);
		checkRadioButton(driver, param, param.get("Like"), test);
		checkMultiDropDown(driver, param, param.get("MultiDropDown"), test);
		checkRating(driver, param, test);
		checkSelectImage(driver, param, test);
		goNext(driver, param, test);
	}

	public void pageTwo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		checkMTB(driver, param, test);
		checkMDD(driver, param, test);
		checkRadioButton3(driver, param, param.get("RG"), test);
		checkCheckBoxes3(driver, param, param.get("CBG"), test);
		checkRadioButton3(driver, param, param.get("RRG"), test);
		checkRDDG(driver, param, test);
		checkRadioButton3(driver, param, param.get("RSG"), test);
		checkMG1(driver, param, param.get("MG1"), test);
		checkMG2(driver, param, param.get("MG2"), test);
		goNext(driver, param, test);
	}

	public void pageThree(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		checkRadioButton2(driver, param, param.get("RadioBtn2"), test);
		checkMTB2(driver, param, test);
		checkDrillDown(driver, param, test);
		checkRRB(driver, param, test);
		checkRDD(driver, param, test);
		checkLB(driver, param, test);
		checkAttachment(driver, param, test);
		clickSubmit(driver, param, test);
	}

	public void clickSubmit(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, submit_button, test);
		click(driver, testcaseName, submit_button, test);
		Thread.sleep(1000);
	}
	
	public void checkThankYouMessage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, thank_you_message, test);
		String thanksMessage = getText(driver, testcaseName, thank_you_message, test);
		thanksMessage = thanksMessage.replaceAll("\\s+", " ").trim();
		if (thanksMessage.equals(param.get("ThanksMsg"))) {
			reportPass("The Thank You Message '" + param.get("ThanksMsg") + "' was displayed on submitting the Survey Form.", test);
		} else {
			reportFail(testcaseName,
					"The Thank You Message '" + param.get("ThanksMsg") + "' was not displayed on submitting the Survey Form.", test);
		}
	}
	
	public void goNext(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, next_button, test);
		click(driver, testcaseName, next_button, test);
		Thread.sleep(1000);
	}

	public void surveyHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		try {
			driver.findElement(By.xpath("//span[text()='" + param.get("header") + "']")).isDisplayed();
			reportPass("The Survey Header '" + param.get("header") + "' is displayed on the survey page", test);
		} catch (Exception e) {
			reportFail(testcaseName,
					"The Survey Header '" + param.get("header") + "' is not displayed on the survey page", test);
		}
	}

	public void checkTextBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String txtBox[] = param.get("TextBox").split(";");
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//td[text()=\"" + txtBox[0]
						+ "\"]/ancestor::div[@class='div-title']/following-sibling::table//input)[1]"),
				"Text Box " + txtBox[0], test);
		setText(driver, testcaseName,
				By.xpath("(//td[text()=\"" + txtBox[0]
						+ "\"]/ancestor::div[@class='div-title']/following-sibling::table//input)[1]"),
				txtBox[1], "Text Box " + txtBox[0], test);
		Thread.sleep(500);
	}

	public void checkRadioButton(WebDriver driver, HashMap<String, String> param, String strRadio, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String radio[] = strRadio.split(";");
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//td[text()=\"" + radio[0]
						+ "\"]/ancestor::div[@class='div-title']/following-sibling::table//label[text()='" + radio[1]
						+ "'])[1]"),
				"Radio Button " + radio[0], test);
		click(driver, testcaseName,
				By.xpath("(//td[text()=\"" + radio[0]
						+ "\"]/ancestor::div[@class='div-title']/following-sibling::table//label[text()='" + radio[1]
						+ "'])[1]"),
				"Radio Button " + radio[0], test);
		Thread.sleep(500);
	}

	public void checkRadioButton2(WebDriver driver, HashMap<String, String> param, String strRadio, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String radio[] = strRadio.split(";");
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//td[contains(text(),\"" + radio[0]
						+ "\")]/ancestor::div[@class='div-title']/following-sibling::table//label[text()='" + radio[1]
						+ "'])[1]"),
				"Radio Button " + radio[0], test);
		click(driver, testcaseName,
				By.xpath("(//td[contains(text(),\"" + radio[0]
						+ "\")]/ancestor::div[@class='div-title']/following-sibling::table//label[text()='" + radio[1]
						+ "'])[1]"),
				"Radio Button " + radio[0], test);
		Thread.sleep(500);
	}
	
	public void checkRRB(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
//		waitforElemPresent(driver, testcaseName, 10,
//				By.xpath("(//label[contains(text(),\""+ param.get("RRB") +"\")]/preceding::input)[1]"),
//				"Radio Button " + param.get("RRB"), test);
		click(driver, testcaseName,
				By.xpath("(//label[contains(text(),\""+param.get("RRB") +"\")]/parent::td/preceding-sibling::td/input)[1]"),
				"Radio Button " + param.get("RRB"), test);
		Thread.sleep(500);
	}


	public void checkSelectImage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String image[] = param.get("Image").split(";");
		scrollIntoView(driver, testcaseName,
				By.xpath("(//td[text()=\"" + image[0]
						+ "\"]/ancestor::div[@class='div-title']/following-sibling::table//input[@value='" + image[1]
						+ "'])[1]"),
				"Image Radio " + image[0], test);
		Thread.sleep(500);
//		waitforElemPresent(driver, testcaseName, 10, By.xpath("(//td[text()=\""+ image[0] +"\"]/ancestor::div[@class='div-title']/following-sibling::table//input[@value='"+ image[1] +"'])[1]"), "Image Radio "+image[0], test);
		click(driver, testcaseName,
				By.xpath("(//td[text()=\"" + image[0]
						+ "\"]/ancestor::div[@class='div-title']/following-sibling::table//input[@value='" + image[1]
						+ "'])[1]"),
				"Image Radio " + image[0], test);
		Thread.sleep(500);
	}

	public void checkCheckBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String checkbox[] = param.get("CheckBox").split(";");
		String value[] = checkbox[1].split(",");
		for (int i = 0; i < value.length; i++) {
			waitforElemPresent(driver, testcaseName, 10,
					By.xpath("(//td[contains(text(),'" + checkbox[0]
							+ "')]/ancestor::div[@class='div-title']/following-sibling::table//label[text()='"
							+ value[i] + "'])[1]"),
					"Check Box " + checkbox[0], test);
			click(driver, testcaseName,
					By.xpath("(//td[contains(text(),'" + checkbox[0]
							+ "')]/ancestor::div[@class='div-title']/following-sibling::table//label[text()='"
							+ value[i] + "'])[1]"),
					"Check Box " + checkbox[0], test);
			Thread.sleep(500);
		}

	}

	public void checkDropDown(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String dropdown[] = param.get("DropDown").split(";");
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//td[contains(text(),'" + dropdown[0]
						+ "')]/ancestor::div[@class='div-title']/following-sibling::table//select)[1]"),
				"Drop Down " + dropdown[0], test);
		click(driver, testcaseName,
				By.xpath("(//td[contains(text(),'" + dropdown[0]
						+ "')]/ancestor::div[@class='div-title']/following-sibling::table//select)[1]"),
				"Drop Down " + dropdown[0], test);
		Thread.sleep(500);
		Select select = new Select(driver.findElement(By.xpath("(//td[contains(text(),'" + dropdown[0]
				+ "')]/ancestor::div[@class='div-title']/following-sibling::table//select)[1]")));
		select.selectByVisibleText(dropdown[1]);
		Thread.sleep(500);
	}
	
	public void checkRDD(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String dropdown[] = param.get("RDD").split(";");
//		waitforElemPresent(driver, testcaseName, 10,
//				By.xpath("(//td[contains(text(),'" + dropdown[0]
//						+ "')]/ancestor::div[@class='div-title']/following-sibling::table//select)[1]"),
//				"Drop Down " + dropdown[0], test);
		click(driver, testcaseName,
				By.xpath("(//td[contains(text(),'" + dropdown[0]
						+ "')]/ancestor::div[@class='div-title']/following-sibling::table//select)[1]"),
				"Drop Down " + dropdown[0], test);
		Thread.sleep(500);
		Select select = new Select(driver.findElement(By.xpath("(//td[contains(text(),'" + dropdown[0]
				+ "')]/ancestor::div[@class='div-title']/following-sibling::table//select)[1]")));
		select.selectByVisibleText(dropdown[1]);
		Thread.sleep(500);
	}

	public void checkDropDown2(WebDriver driver, HashMap<String, String> param, String strDropDown, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String dropdown[] = strDropDown.split(";");
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//span[contains(text(),\"" + dropdown[0] + "\")]/following::select)[1]"),
				"Drop Down " + dropdown[0], test);
		click(driver, testcaseName, By.xpath("(//span[contains(text(),\"" + dropdown[0] + "\")]/following::select)[1]"),
				"Drop Down " + dropdown[0], test);
		Thread.sleep(500);
		Select select = new Select(driver
				.findElement(By.xpath("(//span[contains(text(),\"" + dropdown[0] + "\")]/following::select)[1]")));
		select.selectByVisibleText(dropdown[1]);
		Thread.sleep(500);
	}

	public void checkRadio3(WebDriver driver, HashMap<String, String> param, String strRadio, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String radio[] = strRadio.split(";");
//		waitforElemPresent(driver, testcaseName, 10,
//				By.xpath("(//span[contains(text(),\""+ radio[0] +"\")]/following::input[@value='"+ radio[1] +"'])[1]"),
//				"Radio Button " + radio[0], test);
		click(driver, testcaseName, By.xpath(
				"(//span[contains(text(),\"" + radio[0] + "\")]/following::input[@value='" + radio[1] + "'])[1]"),
				"Radio Button " + radio[0], test);
		Thread.sleep(500);
	}

	public void checkCheckbox3(WebDriver driver, HashMap<String, String> param, String strCheckBox, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String checkBox[] = strCheckBox.split(";");
		String boxes[] = checkBox[1].split(",");
		for (int i = 0; i < boxes.length; i++) {
//			waitforElemPresent(driver, testcaseName, 10,
//			By.xpath("(//span[contains(text(),\""+ checkBox[0] +"\")]/following::input[contains(@id,'"+ boxes[i] +"') and @type='checkbox'])[1]"),
//			"Check Box " + checkBox[0], test);
			click(driver, testcaseName, By.xpath("(//span[contains(text(),\"" + checkBox[0]
					+ "\")]/following::input[contains(@id,'" + boxes[i] + "') and @type='checkbox'])[1]"),
					"Check Box " + checkBox[0], test);
			Thread.sleep(500);
		}

	}
	
	public void checkLB(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String checkBox[] = param.get("LB").split(";");
		for (int i = 0; i < checkBox.length; i++) {
//			waitforElemPresent(driver, testcaseName, 10,
//			By.xpath("(//label[contains(text(),\""+ checkBox[i] +"\")]/preceding::input[@type='checkbox'])[1]"),
//			"Check Box " + checkBox[0], test);
			click(driver, testcaseName, By.xpath("(//label[contains(text(),\""+ checkBox[i] +"\")]/parent::td/preceding-sibling::td/input[@type='checkbox'])[1]"),
					"Check Box " + checkBox[i], test);
			Thread.sleep(500);
		}

	}

	public void checkCheckbox4(WebDriver driver, HashMap<String, String> param, String strCheckBox, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String checkBox[] = strCheckBox.split(";");
		String boxes[] = checkBox[1].split(",");
		for (int i = 0; i < boxes.length; i++) {
//			waitforElemPresent(driver, testcaseName, 10,
//			By.xpath("(//span[contains(text(),\""+ checkBox[0] +"\")]/following::input[contains(@id,'"+ boxes[i] +"') and @type='checkbox'])[1]"),
//			"Check Box " + checkBox[0], test);
			click(driver, testcaseName, By.xpath("(//span[contains(text(),\"" + checkBox[0]
					+ "\")]/following::input[contains(@id,'" + boxes[i] + "') and @type='checkbox'])[1]"),
					"Check Box " + checkBox[0], test);
			Thread.sleep(500);
		}

	}

	public void checkDropDown3(WebDriver driver, HashMap<String, String> param, String strDropDown, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String dropdown[] = strDropDown.split(";");
		scrollIntoView(driver, testcaseName,
				By.xpath("(//span[contains(text(),'" + dropdown[0] + "')]/following::select)[1]"),
				"Drop Down " + dropdown[0], test);
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//span[contains(text(),'" + dropdown[0] + "')]/following::select)[1]"),
				"Drop Down " + dropdown[0], test);
		click(driver, testcaseName, By.xpath("(//span[contains(text(),'" + dropdown[0] + "')]/following::select)[1]"),
				"Drop Down " + dropdown[0], test);
		Thread.sleep(500);
		Select select = new Select(
				driver.findElement(By.xpath("(//span[contains(text(),'" + dropdown[0] + "')]/following::select)[1]")));
		select.selectByVisibleText(dropdown[1]);
		Thread.sleep(500);
	}

	public void checkMultiDropDown(WebDriver driver, HashMap<String, String> param, String strDropDown, ExtentTest test)
			throws InterruptedException {
		String dropdown[] = strDropDown.split("\\|");
		checkDropDown2(driver, param, dropdown[0], test);
		checkDropDown2(driver, param, dropdown[1], test);
		checkDropDown2(driver, param, dropdown[2], test);
	}

	public void checkTextBox2(WebDriver driver, HashMap<String, String> param, String strTextBox, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String txtBox[] = strTextBox.split(";");
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//span[contains(text(),\"" + txtBox[0] + "\")]/following::input)[1]"),
				"Text Box " + txtBox[0], test);
		setText(driver, testcaseName, By.xpath("(//span[contains(text(),\"" + txtBox[0] + "\")]/following::input)[1]"),
				txtBox[1], "Text Box " + txtBox[0], test);
		Thread.sleep(500);
	}
	
	public void checkDrillDown(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String txtBox[] = param.get("DrillDown").split("\\|");
		for(int i = 0; i < txtBox.length; i++) {
			String singleTxtBox[] = txtBox[i].split(";");
			scrollIntoView(driver, testcaseName, By.xpath("(//span[contains(text(),\"" + singleTxtBox[0] + "\")]/following::input[contains(@class,'ui-autocomplete-input')])[1]"),
					"Text Box " + singleTxtBox[0], test);
			Thread.sleep(500);
			waitforElemPresent(driver, testcaseName, 10,
					By.xpath("(//span[contains(text(),\"" + singleTxtBox[0] + "\")]/following::input[contains(@class,'ui-autocomplete-input')])[1]"),
					"Text Box " + singleTxtBox[0], test);
			setText(driver, testcaseName, By.xpath("(//span[contains(text(),\"" + singleTxtBox[0] + "\")]/following::input[contains(@class,'ui-autocomplete-input')])[1]"),
					singleTxtBox[1], "Text Box " + singleTxtBox[0], test);
			Thread.sleep(500);
			waitforElemPresent(driver, testcaseName, 10,
					By.xpath("//li//strong[text()='"+ singleTxtBox[1] +"']"),
					"Text Box " + singleTxtBox[0], test);
			click(driver, testcaseName, By.xpath("//li//strong[text()='"+ singleTxtBox[1] +"']"),
					"Text Box " + singleTxtBox[0], test);
			Thread.sleep(500);
		}
		
	}

	public void checkTextBox3(WebDriver driver, HashMap<String, String> param, String strTextBox, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String txtBox[] = strTextBox.split(";");
		waitforElemPresent(driver, testcaseName, 10,
				By.xpath("(//label[contains(text(),\"" + txtBox[0] + "\")]/following::input)[1]"),
				"Text Box " + txtBox[0], test);
		setText(driver, testcaseName, By.xpath("(//label[contains(text(),\"" + txtBox[0] + "\")]/following::input)[1]"),
				txtBox[1], "Text Box " + txtBox[0], test);
		Thread.sleep(500);
	}
	
	public void checkAttachment(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String attachments[] = param.get("Attachments").split("\\|");
		for(int i = 0; i < attachments.length; i++) {
			String singleAttachment[] = attachments[i].split(";");
//			waitforElemPresent(driver, testcaseName, 10,
//					By.xpath("(//span[contains(text(),\"" + singleAttachment[0] + "\")]/following::input[contains(@id,'File')])[1]"),
//					"Attachments " + singleAttachment[0], test);
			
			driver.findElement(By.xpath("(//span[contains(text(),\"" + singleAttachment[0] + "\")]/following::input[contains(@id,'File')])[1]")).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + singleAttachment[1]);
			Thread.sleep(500);
			waitForLoad2(driver, testcaseName, 30, test);
			Thread.sleep(500);
		}
		
	}


	public void checkDemographics(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		checkDropDown2(driver, param, param.get("Gender"), test);
		checkTextBox2(driver, param, param.get("Grade"), test);
		checkTextBox2(driver, param, param.get("DOB"), test);
		checkTextBox2(driver, param, param.get("Email"), test);
	}

	public void checkMTB(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String[] mtbs = param.get("MTB").split("\\|");
		for (int i = 0; i < mtbs.length; i++) {
			checkTextBox2(driver, param, mtbs[i], test);
		}

	}

	public void checkMTB2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String[] mtbs = param.get("MTB2").split("\\|");
		for (int i = 0; i < mtbs.length; i++) {
			checkTextBox3(driver, param, mtbs[i], test);
		}

	}

	public void checkRadioButton3(WebDriver driver, HashMap<String, String> param, String strRadio, ExtentTest test)
			throws InterruptedException {
		String[] radios = strRadio.split("\\|");
		for (int i = 0; i < radios.length; i++) {
			checkRadio3(driver, param, radios[i], test);
		}

	}

	public void checkMG1(WebDriver driver, HashMap<String, String> param, String strMG, ExtentTest test)
			throws InterruptedException {
		String[] mgs = strMG.split("\\|");
		for (int i = 0; i < mgs.length; i++) {
			checkRadio3(driver, param, mgs[i], test);
		}

	}

	public void checkMG2(WebDriver driver, HashMap<String, String> param, String strMG, ExtentTest test)
			throws InterruptedException {
		String[] mgs = strMG.split("\\|");

		for (int i = 0; i < mgs.length; i++) {
			checkCheckbox4(driver, param, mgs[i], test);
		}

	}

	public void checkCheckBoxes3(WebDriver driver, HashMap<String, String> param, String strCheckBox, ExtentTest test)
			throws InterruptedException {
		String[] checkBox = strCheckBox.split("\\|");
		for (int i = 0; i < checkBox.length; i++) {
			checkCheckbox3(driver, param, checkBox[i], test);
		}

	}

	public void checkMDD(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String[] mdds = param.get("MDD").split("\\|");
		for (int i = 0; i < mdds.length; i++) {
			checkDropDown2(driver, param, mdds[i], test);
		}

	}

	public void checkRDDG(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String[] rddgs = param.get("RDDG").split("\\|");
		for (int i = 0; i < rddgs.length; i++) {
			checkDropDown3(driver, param, rddgs[i], test);
		}

	}

	public void checkRG(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String[] rgs = param.get("RG").split("\\|");
		for (int i = 0; i < rgs.length; i++) {
			checkDropDown2(driver, param, rgs[i], test);
		}

	}

	public void checkRating(WebDriver driver, HashMap<String, String> param, String strRating, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String rating[] = strRating.split(";");
		scrollIntoView(driver, testcaseName, By.xpath("(//td[contains(text(),\"" + rating[0]
				+ "\")]/following::div[@class='" + rating[1] + "']//input[@value='" + rating[2] + "'])[1]"),
				"Multi Ratings " + rating[0], test);
		Thread.sleep(500);
//		waitforElemPresent(driver, testcaseName, 10,
//				By.xpath("(//td[contains(text(),\""+ rating[0] +"\")]/following::div[@class='"+ rating[1] +"']//input[@value='"+ rating[2] +"'])[1]"),
//				"Multi Ratings " + rating[0], test);
		click(driver, testcaseName, By.xpath("(//td[contains(text(),\"" + rating[0] + "\")]/following::div[@class='"
				+ rating[1] + "']//input[@value='" + rating[2] + "'])[1]"), "Multi Ratings " + rating[0], test);
		Thread.sleep(500);
	}

	public void checkMultiRatings(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String[] ratings = param.get("Ratings").split("\\|");
		checkRating(driver, param, ratings[0], test);
		checkRating(driver, param, ratings[1], test);
		checkRating(driver, param, ratings[2], test);
		checkRating(driver, param, ratings[3], test);
		checkRating(driver, param, ratings[4], test);
	}

	public void checkRatingSlider(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String rating[] = param.get("Slider").split(";");
		scrollIntoView(driver, testcaseName,
				By.xpath("(//td[contains(text(),\"" + rating[0]
						+ "\")]/ancestor::div[@class='div-title']/following-sibling::table//input[@value='" + rating[1]
						+ "'])[1]"),
				"Slider Ratings " + rating[0], test);
		Thread.sleep(500);
		Actions action = new Actions(driver);
		action.dragAndDropBy(
				driver.findElement(
						By.xpath("//div[contains(@class,'ui-slider-range ui-widget-header ui-slider-range-min')]")),
				40, 0).build().perform();
		;
		Thread.sleep(500);
	}

	public void checkRating(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String rating[] = param.get("RatingNumber").split(";");
		scrollIntoView(driver, testcaseName,
				By.xpath("(//td[contains(text(),\"" + rating[0]
						+ "\")]/ancestor::div[@class='div-title']/following-sibling::table//div[contains(@for,'"
						+ rating[1] + "')])[1]"),
				"Ratings " + rating[0], test);
		Thread.sleep(500);
//		waitforElemPresent(driver, testcaseName, 10,
//				By.xpath("(//td[contains(text(),\""+ rating[0] +"\")]/ancestor::div[@class='div-title']/following-sibling::table//div[contains(@for,'"+ rating[1] +"')])[1]"),
//				"Ratings " + rating[0], test);
		click(driver, testcaseName,
				By.xpath("(//td[contains(text(),\"" + rating[0]
						+ "\")]/ancestor::div[@class='div-title']/following-sibling::table//div[contains(@for,'"
						+ rating[1] + "')])[1]"),
				"Ratings " + rating[0], test);
		Thread.sleep(500);
	}
}

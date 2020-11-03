package pageobjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import property.IHomePage;
import property.ISMxPage;
import testsuitebase.TestResultStatus;
import utility.SeleniumUtils;

public class SMxPage extends SeleniumUtils implements ISMxPage{
	public double finish, start;
	public double end;
	
	public double goToDesignerPage(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		new StaticPage().login(driver, param, username, password, URL, test);
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
		setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
		click(driver, testcaseName, IHomePage.search_icon, test);
		WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
		new Actions(driver).moveToElement(survey).perform();
		waitForElementToBeVisible(driver, testcaseName, IHomePage.edit_icon, 10, 100, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, IHomePage.edit_icon, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	/**
	 * Use this method to get String Array of ZarcaQIDs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<String> getZarcaQIDs(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		ArrayList<Object> pageQuestionData = new ArrayList<Object>();
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		String script = "return SurveyJson.PageQuestion;";
		pageQuestionData = (ArrayList<Object>) executeScript(driver, testcaseName, script, test);
		Iterator<Object> iterator = pageQuestionData.iterator();
		while(iterator.hasNext()) {
			Map<String, Object> temp =  (Map<String, Object>) iterator.next();
			zarcaQIDs.add(temp.get("QID").toString());
		}
		return zarcaQIDs;	
	}
	
	private Boolean chooseCategory(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		Boolean isCategoryFound = false;
		// Execute for loop on categoryList and break the loop once the condition is satisfied
		List<WebElement> categoryList = getWebElements(driver, testcaseName, category_list, test);
		for (int i =0; i<categoryList.size(); i++) {
			WebElement category = categoryList.get(i);
			// Remove the leading and trailing white space to prevent NumberFormatException, that is it will convert String " 81 " to "81" and then convert String to Integer
			int questioncount = Integer.parseInt(category.getAttribute("questioncount").strip()); 
			//Check question count before depositing the question to prevent getting JS message of exhausted limit
			if (questioncount<100) {
				String categoryTitle = category.getAttribute("title");
				WebElement searchField = driver.findElement(By.xpath("(//input[contains(@class,'SearchInput')])[2]"));
				searchField.sendKeys(categoryTitle);
				category.click();
				test.log(Status.INFO, categoryTitle +" has been selected");
				Add_Log.info(categoryTitle +" has been selected");
				Reporter.log(categoryTitle +" has been selected");
				isCategoryFound = true;

				break;	
			}
			
		}
		return isCategoryFound;
		
	}
	
	
	public void selectCategoryFromQBList(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		Boolean isCategoryFound = false;
		click(driver, testcaseName, drop_down_of_select_category, test);
		isCategoryFound = chooseCategory(driver, param, test);
		if(isCategoryFound == false) {
			Calendar calendar = Calendar.getInstance();
			String newCategoryName = "Category : " + calendar.getTime();
			click(driver, testcaseName, add_category, test);
			setText(driver, testcaseName, add_category_input_field, newCategoryName, test);
			click(driver, testcaseName, save_category_name, test);
			waitForLoad(driver, testcaseName, 60, test);	
			waitforElemPresent(driver, testcaseName, 60, toaster_msg_of_category_added, test);
			click(driver, testcaseName, close_toaster_msg, test);
			waitforElemNotVisible(driver, testcaseName, 60, toaster_msg_of_category_added, test);
			test.log(Status.INFO, "Category "+ newCategoryName + " added");
			Add_Log.info("Category "+ newCategoryName + " added");
			Reporter.log("Category "+ newCategoryName + " added");
			click(driver, testcaseName, drop_down_of_select_category, test);
			chooseCategory(driver, param, test);
			
		}
	}
	
	public double depositeQuestionToQuestionBank(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		zarcaQIDs = getZarcaQIDs(driver,param,test); // Store all zarca qids in a array
		WebElement firstQue_WebElement = driver.findElement(By.xpath("//div[contains(@id,'qted_" + zarcaQIDs.get(0) + "')]"));
		new Actions(driver).moveToElement(firstQue_WebElement).perform();
		waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
		click(driver, testcaseName, question_menu_more_options, test);
		click(driver, testcaseName, deposite_to_question_bank_option, test);
		waitforElemPresent(driver, testcaseName, 60, deposite_to_question_bank_modal, test);
		waitUntilReqCSSValue(driver, testcaseName, 60, deposite_to_question_bank_modal, "width", "363px", test);
		String width = getWebElement(driver, testcaseName, deposite_to_question_bank_modal, test).getCssValue("width");
		System.out.println("Width = "+width);
		
		selectCategoryFromQBList(driver, param, test);
		String placeholderText = getWebElement(driver, testcaseName, drop_down_of_select_category_placeholder, test).getAttribute("innerText");
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, deposite_button, test);
		waitforElemPresent(driver, testcaseName, 60, toaster_msg_of_deposite_to_question_bank, test);
		end = System.currentTimeMillis();
		
		test.log(Status.INFO, "Question is deposited under "+ placeholderText + " category");
		Add_Log.info("Question is deposited under "+ placeholderText + " category");
		Reporter.log("Question is deposited under "+ placeholderText + " category");
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	
	public double addComment(WebDriver driver, HashMap<String, String> param, String descrText, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		zarcaQIDs = getZarcaQIDs(driver,param,test); // Store all zarca qids in a array
		WebElement firstQue_WebElement = driver.findElement(By.xpath("//div[contains(@id,'qted_" + zarcaQIDs.get(0) + "')]"));
		dragAndDropAction2(driver, testcaseName, question_descriptive_text, firstQue_WebElement, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, question_text_content, test);
		//waitforElemPresent(driver, testcaseName, 60, iframe_descriptive_text, test);
		switchToIframe(driver, testcaseName, iframe_descriptive_text, test);
		waitforElemPresent(driver, testcaseName, 60, question_descriptive_text_input_field, test);
		executeScript(driver, testcaseName, "arguments[0].innerHTML='" +descrText +"'" , question_descriptive_text_input_field, test);
		driver.switchTo().defaultContent();
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	

	public double deleteComment(WebDriver driver, HashMap<String, String> param, String descrText, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Boolean isDescipTextFound = false;
		List<WebElement> questionList = initQuestionList(driver, param, test);
		int qustionListCount = questionList.size();
		for (int i= 0; i<qustionListCount; i++) {
			WebElement question = questionList.get(i);
			scrollIntoView(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
			// Check qno attribute for each element, for comment question type qno = 'Ci', where, i=1,2,3....n.
			if(question.getAttribute("qno").contains("C")) {
				scrollIntoCenter(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				hoverAction(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
				click(driver, testcaseName, question_menu_delete_option, test);	
				
				start = System.currentTimeMillis();
				driver.switchTo().alert().accept();
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, designer_button, test);
				end = System.currentTimeMillis();
				
				isDescipTextFound = true;
				break;
				
			}
			waitforElemNotVisible(driver, testcaseName, 60, question_page_loader, test);
			Thread.sleep(600);
			questionList = initQuestionList(driver, param, test); //Initialize webelement list after every loop to handle async question loading.
			qustionListCount = questionList.size();
				
		}			
		if (isDescipTextFound == false) {
			click(driver, testcaseName, page_number_drop_down, test);
			List<WebElement> surveyPages = getWebElements(driver, testcaseName, list_of_survey_pages, test);
			click(driver, testcaseName, surveyPages.get(0), "Page No 1", test);
			waitForElementToBePresentOnDOM(driver, testcaseName, 60, page_number_drop_down_value_1, test);		
			addComment(driver, param, descrText, test);
			hoverAction(driver, testcaseName, By.xpath("//span[contains(text(),'" + descrText + "')]"),
					"Description Question - Added via addComment method", test);
			click(driver, testcaseName, question_menu_delete_option, test);

			start = System.currentTimeMillis();
			driver.switchTo().alert().accept();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 60, designer_button, test);
			end = System.currentTimeMillis();
		}
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	public double movePage(WebDriver driver, HashMap<String, String> param, int pageNo, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, page_number_drop_down, test);
		List<WebElement> surveyPages = getWebElements(driver, testcaseName, list_of_survey_pages, test);
		click(driver, testcaseName, surveyPages.get(pageNo-1), "Page "+pageNo, test);
		waitforElemPresent(driver, testcaseName, 60, page_actions, test);
		click(driver, testcaseName, page_actions, test);
		click(driver, testcaseName, move_page, test);		
		Select select = new Select(getWebElement(driver, testcaseName, move_page_options, test));
		
		start = System.currentTimeMillis();
		select.selectByValue("2");
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, page_number_drop_down, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	private List<WebElement> initQuestionList(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		List<WebElement> questionList = getWebElements(driver, testcaseName, list_of_question_in_survey, test);
		return questionList;
	}
	
	
	public double moveMatrixGrid(WebDriver driver, HashMap<String, String> param, String SID, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Boolean isMatrixGridFound = false;
		
		//Long lastLoadQuestion = (Long) executeScript(driver, testcaseName, "return SurveyJson.LastLoadquestion;", test);
		//Long pageQuestionLength = (Long) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion.length;", test);
		//String uniqueqno = (String) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion[" +(pageQuestionLength-1) +"].uniqueqno;", test);
		List<WebElement> questionList = initQuestionList(driver, param, test);
		int qustionListCount = questionList.size();
		for (int i= 0; i<qustionListCount; i++) {
			WebElement question = questionList.get(i);
			scrollIntoView(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
			// Check subqno attribute for each element, for grid subqno = '1', else it's 0
			if(question.getAttribute("subqno").contains("1")) {
				scrollIntoCenter(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				hoverAction(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
				click(driver, testcaseName, question_menu_more_options, test);
				click(driver, testcaseName, move_question, test);
				
				start = System.currentTimeMillis();
				click(driver, testcaseName, getWebElements(driver, testcaseName, move_question_options, test).get(0), "First options in Move side menu", test);
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, designer_button, test);
				end = System.currentTimeMillis();
				
				isMatrixGridFound = true;
				break;				
			}
			waitforElemNotVisible(driver, testcaseName, 60, question_page_loader, test);
			Thread.sleep(600);
			questionList = initQuestionList(driver, param, test); //Initialize webelement list after every loop to handle async question loading.
			qustionListCount = questionList.size();
			
		}
		if (isMatrixGridFound == false) {
			test.log(Status.INFO, "Matrix grid question is not found in survey SID : " + SID);
			Add_Log.info("Matrix grid question is not found in survey SID : " + SID);
			Reporter.log("Matrix grid question is not found in survey SID : " + SID);	
			TestResultStatus.failureReason.add(testcaseName + "| Matrix grid question is not found in survey SID : " + SID);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
			
		end = System.currentTimeMillis();
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}

	

}

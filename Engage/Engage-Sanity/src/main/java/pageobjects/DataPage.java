package pageobjects;


import java.io.File;
import java.io.FileFilter;
import java.lang.module.FindException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.time.CalendarUtils;
import org.apache.poi.ss.util.DateFormatConverter;
import org.apache.poi.xdgf.usermodel.section.geometry.MoveTo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import property.IDataPage;
import property.IHomePage;
import testsuitebase.TestResultStatus;
import utility.SeleniumUtils;
import utility.WebPageElements;


import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;


public class DataPage extends SeleniumUtils implements IDataPage {
	
	public double finish, start, totalTime;
	public double end;
	String strtotalTime= null;
	public DecimalFormat df = new DecimalFormat("#.##");
	
	public void validateEmail( HashMap<String, String> param, Date currentTime, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String[] hostArray = param.get("emailhost").split(",");
		String[] emailArray = param.get("stremailaddress").split(",");
		String[] passwordArray = param.get("emailPassword").split(",");
		String sub = param.get("subject");
		String survey_ID = param.get("surveyid");
		String SID="";
		
		for(int i=0; i<emailArray.length; i++) {
			HashMap<String, String> emailData = readRecentEmail(param, hostArray[i], emailArray[i], passwordArray[i], sub, currentTime, test);
			try {
				String[] emailContent = emailData.get("Message Content").split(" ");
				System.out.println("Email Received Having Subject:  " + sub );
				//String participationLink="";
				
				for (String content : emailContent) {
					if (content.contains("Survey ID:") && content.contains(survey_ID)) {
						SID = content.substring(content.indexOf("Survey ID:"));
						 System.out.println(SID);		
						 System.out.println("Email is present");	
						break;		
					}	
				}
				Reporter.log("Email has been received with Subject <b>"+emailData.get("Subject") +"</b> from <b> "+(emailData.get("Sent From").replaceAll("[<>]*", "")) +"</b> to <b>"+ emailArray[i] +"</b> on <b>"+emailData.get("Date") +"</b> and Survey id is : <b>"+survey_ID+"</b>.");  // Add log in testNG report
				test.info("Email has been received with Subject <b>"+emailData.get("Subject") +"</b> from <b> "+(emailData.get("Sent From").replaceAll("[<>]*", "")) +"</b> to <b>"+ emailArray[i] +"</b> on <b>"+emailData.get("Date") +"</b> and Survey id is : <b>"+survey_ID+"</b>.");		// Add log in extent report		
			}catch(StringIndexOutOfBoundsException ex) {
				Reporter.log("Email not found in the INBOX of email id : <b>" +emailArray[i]+"</b>");
				test.log(Status.FATAL, "Email not found in INBOX of email id : <b>" +emailArray[i]+"</b>");
			}
		}
	
	}

	 		public void validateImportDataExePage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
				throws InterruptedException {
			String testcaseName = param.get("TestCaseName");	
			Date currentTime = Calendar.getInstance().getTime();
			if(driver.getCurrentUrl().contains("https://www.sogolytics.com")) {
				String URL = "https://www.sogolytics.com/misc/importexequeue.aspx";
				executeScript(driver, testcaseName, "window.open()", test);
				
				Set<String> handles = driver.getWindowHandles();
				String currentWindowHandle = driver.getWindowHandle();
				param.put("currentWindowHandle", currentWindowHandle);
				for (String handle : handles) {
				System.out.println(handle);
				System.out.println(currentWindowHandle);
				if (!currentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
				}
				}
			    driver.get(URL);
			    Thread.sleep(5000);
			    
			    String ImportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
			    System.out.println(ImportStatus);
			    
			   if (ImportStatus.equals("Done")) {
				   reportPass("Import Status is Done", test);		
			} else {
				for (int i=1; i<=60; i++){
					TimeUnit.SECONDS.sleep(30);	
					driver.navigate().refresh();
					String LatestImportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
					System.out.println(LatestImportStatus);
				    
					if (LatestImportStatus.equals("Done")) {
						 reportPass("Import Status is Done", test);
						 break;
					} else {
						System.out.println("Waiting for 30mins, Import Status is not Done");				
					}			
				}	
				//reportFail(testcaseName,"Import Status is not Done" , test);
				String Sogo_Import_Queue = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
				if (Sogo_Import_Queue.equals("Done")) {
					 reportPass("Sogo Import Status is Done", test);
				} else {
					reportFail(testcaseName,"Sogo Import Status is not Done" , test);				
				}	
				
			}
			}else if(driver.getCurrentUrl().contains("https://research.k12insight.com")) {
				String URL = "https://research.k12insight.com//misc/importexequeue.aspx";
				executeScript(driver, testcaseName, "window.open()", test);
				
				Set<String> handles = driver.getWindowHandles();
				String currentWindowHandle = driver.getWindowHandle();
				param.put("currentWindowHandle", currentWindowHandle);
				for (String handle : handles) {
				System.out.println(handle);
				System.out.println(currentWindowHandle);
				if (!currentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
				}
				}
			    driver.get(URL);
			    Thread.sleep(5000);
			    
			    String ImportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
			    System.out.println(ImportStatus);
			    
			   if (ImportStatus.equals("Done")) {
				   reportPass("Import Status is Done", test);
				   
			} else {
				for (int i=1; i<=60; i++){
					TimeUnit.SECONDS.sleep(30);	
					driver.navigate().refresh();
					String LatestImportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
					System.out.println(LatestImportStatus);
				    
					if (LatestImportStatus.equals("Done")) {
						 reportPass("Import Status is Done", test);
						 break;
					} else {
						System.out.println("Waiting for 30mins, Import Status is not Done");				
					}			
				}	
				//reportFail(testcaseName,"Import Status is not Done" , test);
				String K12_Import_Queue = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
				if (K12_Import_Queue.equals("Done")) {
					 reportPass("K12 Import Status is Done", test);
				} else {
					reportFail(testcaseName,"K12 Import Status is not Done" , test);				
				}
			}
			} else {
	    	  String URL = "https://research.zarca.com/misc/importexequeue.aspx";
				executeScript(driver, testcaseName, "window.open()", test);
				
				Set<String> handles = driver.getWindowHandles();
				String currentWindowHandle = driver.getWindowHandle();
				param.put("currentWindowHandle", currentWindowHandle);
				for (String handle : handles) {
				System.out.println(handle);
				System.out.println(currentWindowHandle);
				if (!currentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
				}
				}
			    driver.get(URL);
			    Thread.sleep(5000);
			    
			    String ImportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
			    System.out.println(ImportStatus);
			    
			   if (ImportStatus.equals("Done")) {
				   reportPass("Import Status is Done", test);		
			} else {
				for (int i=1; i<=60; i++){
					TimeUnit.SECONDS.sleep(30);	
					driver.navigate().refresh();
					String LatestImportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
					System.out.println(LatestImportStatus);
				    
					if (LatestImportStatus.equals("Done")) {
						 reportPass("Import Status is Done", test);
						 break;
					} else {
						System.out.println("Waiting for 30mins, Import Status is not Done");				
					}			
				}	
				//reportFail(testcaseName,"Import Status is not Done" , test);
				String Zarca_Import_Queue = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[3]")).getAttribute("innerHTML"));
				if (Zarca_Import_Queue.equals("Done")) {
					 reportPass("Zarca Import Status is Done", test);
				} else {
					reportFail(testcaseName,"Zarca Import Status is not Done" , test);				
				}
			}
	      }
				validateEmail(param, currentTime, test);  
	}
	
	 		public void validateExportDataExePage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
	 		String testcaseName = param.get("TestCaseName");
	 		Date currentTime = Calendar.getInstance().getTime();
		    if(driver.getCurrentUrl().contains("https://www.sogolytics.com")) {
			String URL = "https://www.sogolytics.com/misc/exportexequeue.aspx";
			executeScript(driver, testcaseName, "window.open()", test);
			
			Set<String> handles = driver.getWindowHandles();
			String currentWindowHandle = driver.getWindowHandle();
			param.put("currentWindowHandle", currentWindowHandle);
			for (String handle : handles) {
			System.out.println(handle);
			System.out.println(currentWindowHandle);
			if (!currentWindowHandle.equals(handle)) {
			driver.switchTo().window(handle);
			}
			}
		    driver.get(URL);
		    Thread.sleep(5000);
		    
		    String ExportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getText());
		    System.out.println(ExportStatus);
		    
		    if (ExportStatus.equals("Done")) {
				   reportPass("Export Status is Done", test);		
			} else {
				for (int i=1; i<=60; i++){
					TimeUnit.SECONDS.sleep(30);
					driver.navigate().refresh();
					String LatestExportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getText());
					System.out.println(LatestExportStatus);
					if (LatestExportStatus.equals("Done")) {
						 reportPass("Export Status is Done", test);
						 break;
					} else {
						System.out.println("Waiting for 30mins, Export Status is not Done");				
					}			
				} 
				//reportFail(testcaseName,"Export Status is not Done" , test);
				String Sogo_Export_Queue = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getText());
				if (Sogo_Export_Queue.equals("Done")) {
					 reportPass("Sogo Export Status is Done", test);
				} else {
					reportFail(testcaseName,"Sogo Export Status is not Done" , test);				
				}	
			}    
		}		
		
		
		    else if(driver.getCurrentUrl().contains("https://research.k12insight.com")) {
			String URL = "https://research.k12insight.com//misc/exportexequeue.aspx";
			executeScript(driver, testcaseName, "window.open()", test);
			
			Set<String> handles = driver.getWindowHandles();
			String currentWindowHandle = driver.getWindowHandle();
			param.put("currentWindowHandle", currentWindowHandle);
			for (String handle : handles) {
			System.out.println(handle);
			System.out.println(currentWindowHandle);
			if (!currentWindowHandle.equals(handle)) {
			driver.switchTo().window(handle);
			}
			}
		    driver.get(URL);
		    Thread.sleep(5000);
		    
		    String ExportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getText());
		    System.out.println(ExportStatus);
		    
		    if (ExportStatus.equals("Done")) {
				   reportPass("Export Status is Done", test);		
			} else {
				for (int i=1; i<=60; i++){
					TimeUnit.SECONDS.sleep(30);	
					driver.navigate().refresh();
					String LatestExportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getText());
					System.out.println(LatestExportStatus);
					if (LatestExportStatus.equals("Done")) {
						 reportPass("Export Status is Done", test);
						 break;
					} else {
						System.out.println("Waiting for 30mins, Export Status is not Done");				
					}			
				} 
				//reportFail(testcaseName,"Export Status is not Done" , test);
				String K12_Import_Queue = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getAttribute("innerHTML"));
				if (K12_Import_Queue.equals("Done")) {
					 reportPass("K12 Export Status is Done", test);
				} else {
					reportFail(testcaseName,"K12 Export Status is not Done" , test);				
				}
			}   
		}
		
		
		  else {
    	  String URL = "https://research.zarca.com/misc/exportexequeue.aspx";
			executeScript(driver, testcaseName, "window.open()", test);
			
			Set<String> handles = driver.getWindowHandles();
			String currentWindowHandle = driver.getWindowHandle();
			param.put("currentWindowHandle", currentWindowHandle);
			for (String handle : handles) {
			System.out.println(handle);
			System.out.println(currentWindowHandle);
			if (!currentWindowHandle.equals(handle)) {
			driver.switchTo().window(handle);
			}
			}
		    driver.get(URL);
		    Thread.sleep(5000);
		    
		    String ExportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getText());
		    System.out.println(ExportStatus);
		    
		    if (ExportStatus.equals("Done")) {
				   reportPass("Export Status is Done", test);		
			} else {
				for (int i=1; i<=60; i++){
					TimeUnit.SECONDS.sleep(30);	
					driver.navigate().refresh();
					String LatestExportStatus = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getText());
					System.out.println(LatestExportStatus);
					if (LatestExportStatus.equals("Done")) {
						 reportPass("Export Status is Done", test);
						 break;
					} else {
						System.out.println("Waiting for 30mins, Export Status is not Done");				
					}			
				} 
				//reportFail(testcaseName,"Export Status is not Done" , test);
				String Zarca_Export_Queue = (driver.findElement(By.xpath("//td[normalize-space()='g_golatkar@outlook.com']/following-sibling::td[6]")).getAttribute("innerHTML"));
				if (Zarca_Export_Queue.equals("Done")) {
					 reportPass("Zarca Export Status is Done", test);
				} else {
					reportFail(testcaseName,"Zarca Export Status is not Done" , test);				
				}
			}   
      }
		    	validateEmail(param, currentTime, test);
   }
	 		
	 		public HashMap<String, String> readRecentEmail(HashMap<String, String> param, String host, String userName, String password, String sub, Date currentTime, ExtentTest test) {
	 			String testcaseName = param.get("TestCaseName");
	 			HashMap<String, String> emailData = new HashMap<String, String>();
	 			String saveDirectory = System.getProperty("user.dir") + "\\SaveEmails";
	 			String Date = "";
	 			String sentFrom = "";
	 			String subject = "";
	 			String messageContent = "";
	 			boolean isMailReceived = false;
	 			
	 			System.out.println("Current time : "+currentTime);
	 			
	 	        Properties properties = new Properties();
	 	        properties.setProperty("mail.store.protocol", "imaps");
	 	        try {
	 	            double endTime = 300;    // Run loop for 300 seconds
	 	            double startTime = System.currentTimeMillis();
	 	            do {
	 	            	Session session = Session.getDefaultInstance(properties, null);
	 	                Store store = session.getStore("imaps");
	 	                
	 	    			if (host.equalsIgnoreCase("gmail")) {
	 	    				store.connect("imap.gmail.com", userName, password);
	 	    			} else if (host.equalsIgnoreCase("yahoo")) {
	 	    				store.connect("imap.mail.yahoo.com", userName, password);
	 	    			} else if (host.equalsIgnoreCase("outlook")) {
	 	    				store.connect("outlook.office365.com", userName, password);
	 	    			} else if (host.equalsIgnoreCase("bluwberry")) {
	 	    				store.connect("corp.bluwberry.com", userName, password);
	 	    			}
	 	            	Folder inbox = store.getFolder("INBOX");
	 	            	 
	 	                int unreadMailCount = inbox.getUnreadMessageCount();
	 	                System.out.println("No. of Unread Mails = " + unreadMailCount);
	 	     
	 	                inbox.open(Folder.READ_WRITE);
	 	                
	 	                Message messages[] = inbox.getMessages();
	 	                System.out.println("No. of Total Mails = " + messages.length);
	 	            	//Get latest message
	 	                Message message = messages[messages.length-1];
	 	 
	 	                Address[] from = message.getFrom();
	 	                System.out.println("====================================== Mail no.: " + messages.length + " start ======================================");
	 	                Date = message.getSentDate().toString();
	 	                sentFrom = from[0].toString();
	 	                subject = message.getSubject();
	 	                
	 	                System.out.println("Date: " + Date);
	 	                System.out.println("From: " + sentFrom);
	 	                System.out.println("Subject: " + subject);
	 	                
	 	                
	 	                String contentType = message.getContentType();
	 	 
	 	                // store attachment file name, separated by comma
	 	                String attachFiles = "";
	 	 
	 	                if (contentType.contains("multipart")) {
	 	                    // content may contain attachments
	 	                    Multipart multiPart = (Multipart) message.getContent();
	 	                    int numberOfParts = multiPart.getCount();
	 	                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
	 	                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
	 	                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
	 	                            // this part is attachment
	 	                            String fileName = part.getFileName();
	 	                            attachFiles += fileName + ", ";
	 	                            part.saveFile(saveDirectory + File.separator + fileName);
	 							}
	 							// this part may be the message content
	 	                        if (part.getContentType().contains("multipart")) {
	 	                        	messageContent = ((Multipart) (part.getContent())).getBodyPart(partCount).getContent().toString();
	 	                        }else {
	 	                        	messageContent = part.getContent().toString();
	 	                        }
	 							
	 							System.out.println("Message content : " + (messageContent));

	 	                    }
	 	 
	 	                    if (attachFiles.length() > 1) {
	 	                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
	 	                    }
	 	                } else if (contentType.contains("text/plain")
	 	                        || contentType.contains("text/html")) {
	 	                    Object content = message.getContent();
	 	                    if (content != null) {
	 	                        messageContent = content.toString();
	 	                        System.out.println("Message content : "+messageContent);
	 	                    }
	 	                }
	 	                System.out.println("Attachments: " + attachFiles);
	 	             
	 	                System.out.println("====================================== Mail no.: " + messages.length + " end ======================================");
	 	                System.out.println(subject.equalsIgnoreCase(sub));
	 	                System.out.println(message.getSentDate().after(currentTime));
	 	                System.out.println( message.getSentDate().equals(currentTime));
	 	                System.out.println(currentTime);
	 	                System.out.println(message.getSentDate());
	 	                
	 	                if (subject.equalsIgnoreCase(sub) && (message.getSentDate().after(currentTime) || message.getSentDate().equals(currentTime))) {
	 	                	isMailReceived = true;
	 	                	break;
	 	                }
	 	                // disconnect
	 	                inbox.close(false);
	 	                store.close();
	 	                Thread.sleep(3000);
	 	            }while(((System.currentTimeMillis()-startTime)/1000) < endTime);  // Exit the loop after 300 seconds
	 	            
	 	            //Fail the test case if mail is not received.
	 	            if(isMailReceived == false) {
	 	            	test.log(Status.FAIL,"Expected mail with subject <b>"+sub +"</b> is not received.");
	 					Add_Log.info("Expected mail with subject "+sub +" is not received.");
	 					Reporter.log("Expected mail with subject <b>"+sub +"</b> is not received.");
	 					TestResultStatus.failureReason.add(testcaseName + "| "+ "Expected mail with subject "+sub +" is not received.");
	 					TestResultStatus.TestFail = true;
	 					Assert.fail();
	 	            }
	 	            
	 	        } catch (NoSuchProviderException ex) {
	 	            System.out.println("No provider for pop3.");
	 	            ex.printStackTrace();
	 	        } catch (MessagingException ex) {
	 	            System.out.println("Could not connect to the message store");
	 	            ex.printStackTrace();
	 	        } catch (IOException ex) {
	 	            ex.printStackTrace();
	 	        } catch (InterruptedException e) {
	 				e.printStackTrace();
	 			}
	 	        emailData.put("Date", Date);
	 	        emailData.put("Sent From", sentFrom);
	 	        emailData.put("Subject", subject);
	 	        emailData.put("Message Content", messageContent);
	 	        
	 	        return emailData;
	 		}
	
	
	
	public double goToDataPage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		new DMXPage().goToDistributePage(driver, param, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, data_module, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, import_module, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	public void dataImport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, import_module, test);
		click(driver, testcaseName, import_module, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		driver.findElement(By.xpath(IMPORT_FILE)).sendKeys(System.getProperty("user.dir")
				+"\\src\\main\\resources\\excelfiles\\uploadfiles\\" + param.get("file"));
		Thread.sleep(500);	
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//b[text()='"+ param.get("file") +"']"), param.get("file"), test);
		click(driver, testcaseName, import_map,test);
		waitforElemPresent(driver, testcaseName, 30, import_data, test);
		click(driver, testcaseName, import_data, test);
		try {
			if(driver.findElement(By.xpath(import_continue.getValue())).isDisplayed()){
				click(driver, testcaseName, import_continue, test);
			}		
		}catch(NoSuchElementException e) {
			System.out.println("No mismatch occured, hence mismatch wizard step skipped");
		}
		waitforElemPresent(driver, testcaseName, 30, import_loadresponses, test);
	}
	
	public void dataExportExcel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_excel, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
		
	}
	
	public void dataExportCSV(WebDriver driver, HashMap<String, String> param,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_csv, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
		
	}
	
	public void dataExportXML(WebDriver driver, HashMap<String, String> param,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_xml, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	
	public void dataExportSPSS(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_spss, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	
	public void dataExportAccess(WebDriver driver, HashMap<String, String> param,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_access, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	public void dataExportWord(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_word, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
	}
	
	public void dataExportHtml(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_html, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	public void dataExportK12Insight(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_sogosurvey, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		click(driver, testcaseName, export_continue, test);
//		click(driver, testcaseName, export_responses, test);
//		//click(driver, testcaseName, selectex_continue2, test);
//		//click(driver, testcaseName, selectex_continue2, test);
//		//click(driver, testcaseName, select_export, test);
}
	
	public void dataExportAll(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		LocalDate date = LocalDate.now();  
		DayOfWeek day = date.getDayOfWeek();
		int noDay = day.getValue();

        switch(noDay) {
        case 1:
           	dataExportExcel(driver, param, test);
            break;
        case 2:
        	dataExportCSV(driver, param, test);
            break;
        case 3:
        	dataExportXML(driver, param, test);
            break;
        case 4:
        	dataExportSPSS(driver, param, test);
            break;
        case 5:
        	dataExportAccess(driver, param, test);
            break;
        case 6:
        	dataExportWord(driver, param, test);
            break;
        case 7:
        	dataExportHtml(driver, param, test);
            break;
        default:
            break;
        }
}

	/****
	 * Data platform reading : Gaurav Golatkar
	 */
	
	public Map<String, String> getDataModuleReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		readingData.put(param.get("Step1"), goToDataPage(driver, param, test));
		click(driver, testcaseName, IHomePage.logo_home, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitForGhostLoader(driver, testcaseName, 30, test);
		readingData.put(param.get("Step2"), goToDataPageFromRecentProjects(driver, param, test));
		
		return readingData;
	}

	public String goToDataPageFromRecentProjects(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		try {
			if(driver.findElement(By.xpath("//span[@title=\""+  param.get("surveyTitle") +"\"]")).isDisplayed()) {
				new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[@title=\""+  param.get("surveyTitle") +"\"]"))).build().perform();;
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//li[@class='hd-dropdown-row hd-dd-data']/a[contains(@onclick,'" + param.get("SID") + "')]"), 
						"Data Icon", test);
				
				start = System.currentTimeMillis();	
				click(driver, testcaseName, By.xpath("//li[@class='hd-dropdown-row hd-dd-data']/a[contains(@onclick,'" + param.get("SID") + "')]"), "Data Icon", test);
				waitForLoad(driver, testcaseName, 30, test);
				waitforElemPresent(driver, testcaseName, 60, import_module, test);
				end = System.currentTimeMillis();
				
				totalTime = ((end - start)) / 1000;
				strtotalTime = df.format(totalTime);
				
			}
			
		}catch(NoSuchElementException e) {
			test.log(Status.FAIL, param.get("surveyTitle") + " is not present in recent projects");
			Add_Log.info(param.get("surveyTitle") + " is not present in recent projects");
			Reporter.log(param.get("surveyTitle") + " is not present in recent projects");
			TestResultStatus.failureReason.add(testcaseName + "| "+ param.get("surveyTitle") + " is not present in recent projects");
			e.printStackTrace();
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		return strtotalTime;
	}

	public String goToDataPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		
		waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
		setText(driver, testcaseName, IHomePage.new_search_bar, param.get("surveyTitle"), test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 120, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" +  param.get("surveyTitle") +"\"]"),  param.get("surveyTitle"), 60, 100, test);
		WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" +  param.get("surveyTitle") +"\"]"));
		new Actions(driver).moveToElement(survey).build().perform();
		waitForElementToBeVisible(driver, testcaseName, IHomePage.new_data_icon, 60, 100, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, IHomePage.new_data_icon, test);
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, import_module, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	public Map<String, String> getExcelExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		readingData.put(param.get("Step1"), selectAllQuestionExcel(driver, param, test));
		readingData.put(param.get("Step2"), selectSurveyAttr(driver, param, test));
		readingData.put(param.get("Step3"), applyFilter(driver, param, test));
		readingData.put(param.get("Step4"), applyAssignCode(driver, param, test));
		readingData.put(param.get("Step5"), selectRange(driver, param, test));
		readingData.put(param.get("Step6"), exportData(driver, param, test));
		
		return readingData;
	}
	
	
	private String selectAllQuestionExcel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_excel, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			//	Fail the test case if data is being prepared in run time.
			if(driver.findElement(By.xpath(EXPORT_PREPARE_NOTE)).isDisplayed()) {
				test.log(Status.FAIL, "Data is being prepared in survey");
				Add_Log.info("Data is being prepared in survey");
				Reporter.log("Data is being prepared in survey");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Data is being prepared in survey");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}catch (NoSuchElementException e) {
			waitforElemPresent(driver, testcaseName, 30, select_all_questions, test);			
		}finally {
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	private String selectSurveyAttr(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		//click(driver, testcaseName, select_all_questions, test);
		scrollIntoCenter(driver, testcaseName, continuebtn, test);
		waitforElemPresent(driver, testcaseName, 30, continuebtn, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, continuebtn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, respondent_attr, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}

	private String applyFilter(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String[] toggleList = param.get("toggleData").split(",");
		
		//	Toggle on the respective options which are given in toggleList
		for(String t: toggleList) {
			switch (t) {
			case "IP":
				click(driver, testcaseName, toggle_resp_ip, test);
				break;
			case "emailAddr":
				click(driver, testcaseName, toggle_resp_email, test);
				break;
			case "browserType":
				click(driver, testcaseName, toggle_browser_type, test);
				break;
			case "OS":
				click(driver, testcaseName, toggle_os, test);
				break;
			case "screenRes":
				click(driver, testcaseName, toggle_screen_res, test);
				break;
			case "startEndTime":
				click(driver, testcaseName, toggle_res_sent, test);
				break;
			case "lang":
				click(driver, testcaseName, toggle_lang, test);
				break;
			default:
				break;
			}
		}
		start = System.currentTimeMillis();
		click(driver, testcaseName, continuebtn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, toggle_condition, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}

	private String applyAssignCode(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, toggle_condition, test);
		waitforElemPresent(driver, testcaseName, 30, select_que_dd, test);
		selectByVisibleText(driver, testcaseName, select_que_dd, param.get("filterQue"), test);
		waitForJStoLoad(driver, 30);
		selectByVisibleText(driver, testcaseName, select_condition_dd, param.get("filterCondition"), test);
		setText(driver, testcaseName, ans_text, param.get("ansText"), test);
		click(driver, testcaseName, add_condition, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//td[@class='rowColor'][text()=\"" + param.get("filterQue") +"\"]"), 
				param.get("filterQue") +" condition added", 30, 10, test);
		click(driver, testcaseName, toggle_resp_period, test);
		waitforElemPresent(driver, testcaseName, 30, select_resp_period_dd, test);
		selectByVisibleText(driver, testcaseName, select_resp_period_dd, param.get("respCondition"), test);
		waitForJStoLoad(driver, 30);
		selectCalendar(driver, param, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, continuebtn, test);
		waitForLoad(driver, testcaseName, 30, test);
		if(driver.getTitle().contains("SPSS")) {
			waitforElemPresent(driver, testcaseName, 30, spss_assign_code_note, test);
		}else {
			waitforElemPresent(driver, testcaseName, 30, toggle_assign_code, test);
		}
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public void selectCalendar(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		LocalDate fromDate = LocalDate.parse(param.get("fromDate"), DateTimeFormatter.ofPattern("dd-MMM-yyyy"));	
		String month = getMonth(fromDate.getMonthValue());
		
		waitforElemPresent(driver, testcaseName, 30, cal_from_date, test);
		click(driver, testcaseName, cal_from_date, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, select_year, test);
		selectByVisibleText(driver, testcaseName, select_year, String.valueOf(fromDate.getYear()), test);
		
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, select_month, test);
		selectByVisibleText(driver, testcaseName, select_month, month, test);
		
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//td[@data-handler='selectDay']/a[text()='"+ String.valueOf(fromDate.getDayOfMonth()) +"']"), 
				String.valueOf(fromDate.getDayOfMonth()), test);
		click(driver, testcaseName, By.xpath("//td[@data-handler='selectDay']/a[text()='"+ String.valueOf(fromDate.getDayOfMonth()) +"']"), 
				String.valueOf(fromDate.getDayOfMonth()), test);
		Thread.sleep(1000);
		
		LocalDate toDate = LocalDate.parse(param.get("toDate"), DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		month = getMonth(toDate.getMonthValue());
		
		waitforElemPresent(driver, testcaseName, 30, cal_to_date, test);
		click(driver, testcaseName, cal_to_date, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, select_year, test);
		selectByVisibleText(driver, testcaseName, select_year, String.valueOf(toDate.getYear()), test);
		
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, select_month, test);
		selectByVisibleText(driver, testcaseName, select_month, month, test);
		
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//td[@data-handler='selectDay']/a[text()='"+ String.valueOf(toDate.getDayOfMonth()) +"']"), 
				String.valueOf(toDate.getDayOfMonth()), test);
		click(driver, testcaseName, By.xpath("//td[@data-handler='selectDay']/a[text()='"+ String.valueOf(toDate.getDayOfMonth()) +"']"), 
				String.valueOf(toDate.getDayOfMonth()), test);
		Thread.sleep(1000);
		
	}
	
	private String getMonth(int i) {
		String month = null;
		switch(i) {
		case 1:
			month = "Jan";
			break;
		case 2:
			month = "Feb";
			break;
		case 3:
			month = "Mar";
			break;
		case 4:
			month = "Apr";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "Jun";
			break;
		case 7:
			month = "Jul";
			break;	
		case 8:
			month = "Aug";
			break;
		case 9:
			month = "Sep";
			break;
		case 10:
			month = "Oct";
			break;
		case 11:
			month = "Nov";
			break;
		case 12:
			month = "Dec";
			break;
		}
		return month;
		
	}

	private String selectRange(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		if(!driver.getTitle().contains("SPSS")) {
			click(driver, testcaseName, toggle_assign_code, test);
		}
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//table[@class='bgStep4tbl']"), "Assign Code Table", 30, 100, test);
		scrollIntoCenter(driver, testcaseName, continuebtn, test);
		waitforElemPresent(driver, testcaseName, 30, continuebtn, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, continuebtn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, select_range, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	private String exportData(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		if(driver.getTitle().contains("Excel")) {
			downloadFile(driver, param, "xls", export, test);
		}else if(driver.getTitle().contains("CSV")) {
			downloadFile(driver, param, "csv", export, test);
		}else if(driver.getTitle().contains("XML")) {
			downloadFile(driver, param, "xml", export, test);
		}else if(driver.getTitle().contains("Access")) {
			downloadFile(driver, param, "mdb", export, test);
		}else if(driver.getTitle().contains("Word")) {
			downloadFile(driver, param, "doc", export, test);
		}else if(driver.getTitle().contains("HTML")) {
			downloadFile(driver, param, "html", export, test);
		}else if(driver.getTitle().contains("SPSS")) {
			downloadFile(driver, param, "sav", export, test);
		}
		

		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}

	public String downloadFile(WebDriver driver, HashMap<String, String> param, String fileExtension, WebPageElements ele, ExtentTest test)
	{	
		String testcaseName = param.get("TestCaseName");
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;
	
		//default timeout in seconds
		long timeOut = 300; 
		try 
		{					
			Path downloadFolderPath = Paths.get(param.get("downloadFilePath"));
			WatchService watchService = FileSystems.getDefault().newWatchService();
			downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			waitforElemPresent(driver, testcaseName, 30, ele, test);
			click(driver, testcaseName, ele, test);
			start = System.currentTimeMillis();
			long startTime = System.currentTimeMillis();
			do 
			{
				WatchKey watchKey;
				watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
				long currentTime = (System.currentTimeMillis()-startTime)/1000;
				if(currentTime>timeOut)
				{
					System.out.println("Download operation timed out.. Expected file was not downloaded");
					return downloadedFileName;
				}
				
				for(WatchEvent<?> event : watchKey.pollEvents()) {
					Kind<?> kind = event.kind();
					if(kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
						String fileName = event.context().toString();
						System.out.println("New File Created:" + fileName);
						if(fileName.endsWith(fileExtension)) {
							downloadedFileName = fileName;
							System.out.println("Downloaded file found with extension " + fileExtension + ". File name is " +fileName);
							end = System.currentTimeMillis();
							System.out.println("File is downloaded in "+(end-start)/1000 +" seconds");
							Thread.sleep(100);
							found = true;
							break;
						}
					}
				}
				
				if(found)
				{
					return downloadedFileName;
				}
				else
				{
					currentTime = (System.currentTimeMillis()-startTime)/1000;
					if(currentTime>timeOut)
					{
						System.out.println("Failed to download expected file");
						return downloadedFileName;
					}
					valid = watchKey.reset();
				}
			} while (valid);
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Interrupted error - " + e.getMessage());
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			System.out.println("Download operation timed out.. Expected file was not downloaded");
		}
		catch (Exception e)
		{
			System.out.println("Error occured - " + e.getMessage());
			e.printStackTrace();
		}
		return downloadedFileName;
	}
	
	public String downloadFile(WebDriver driver, HashMap<String, String> param, String fileExtension, ExtentTest test)
	{	
		String testcaseName = param.get("TestCaseName");
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;
	
		//default timeout in seconds
		long timeOut = 300; 
		try 
		{					
			Path downloadFolderPath = Paths.get(param.get("downloadFilePath"));
			WatchService watchService = FileSystems.getDefault().newWatchService();
			downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			long startTime = System.currentTimeMillis();
			do 
			{
				WatchKey watchKey;
				watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
				long currentTime = (System.currentTimeMillis()-startTime)/1000;
				if(currentTime>timeOut)
				{
					System.out.println("Download operation timed out.. Expected file was not downloaded");
					return downloadedFileName;
				}
				
				for(WatchEvent<?> event : watchKey.pollEvents()) {
					Kind<?> kind = event.kind();
					if(kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
						String fileName = event.context().toString();
						System.out.println("New File Created:" + fileName);
						if(fileName.endsWith(fileExtension)) {
							downloadedFileName = fileName;
							System.out.println("Downloaded file found with extension " + fileExtension + ". File name is " +fileName);
							end = System.currentTimeMillis();
							System.out.println("File is downloaded in "+(end-start)/1000 +" seconds");
							Thread.sleep(100);
							found = true;
							break;
						}
					}
				}
				
				if(found)
				{
					return downloadedFileName;
				}
				else
				{
					currentTime = (System.currentTimeMillis()-startTime)/1000;
					if(currentTime>timeOut)
					{
						System.out.println("Failed to download expected file");
						return downloadedFileName;
					}
					valid = watchKey.reset();
				}
			} while (valid);
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Interrupted error - " + e.getMessage());
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			System.out.println("Download operation timed out.. Expected file was not downloaded");
		}
		catch (Exception e)
		{
			System.out.println("Error occured - " + e.getMessage());
			e.printStackTrace();
		}
		return downloadedFileName;
	}
	
	public Map<String, String> getCSVExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		readingData.put(param.get("Step1"), selectAllQuestionCSV(driver, param, test));
		readingData.put(param.get("Step2"), selectSurveyAttr(driver, param, test));
		readingData.put(param.get("Step3"), applyFilter(driver, param, test));
		readingData.put(param.get("Step4"), applyAssignCode(driver, param, test));
		readingData.put(param.get("Step5"), selectRange(driver, param, test));
		readingData.put(param.get("Step6"), exportData(driver, param, test));
		
		return readingData;
	}
	
	private String selectAllQuestionCSV(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_csv, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			//	Fail the test case if data is being prepared in run time.
			if(driver.findElement(By.xpath(EXPORT_PREPARE_NOTE)).isDisplayed()) {
				test.log(Status.FAIL, "Data is being prepared in survey");
				Add_Log.info("Data is being prepared in survey");
				Reporter.log("Data is being prepared in survey");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Data is being prepared in survey");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}catch (NoSuchElementException e) {
			waitforElemPresent(driver, testcaseName, 30, select_all_questions, test);			
		}finally {
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	public Map<String, String> getXMLExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		readingData.put(param.get("Step1"), selectAllQuestionXML(driver, param, test));
		readingData.put(param.get("Step2"), selectSurveyAttr(driver, param, test));
		readingData.put(param.get("Step3"), applyFilter(driver, param, test));
		readingData.put(param.get("Step4"), applyAssignCode(driver, param, test));
		readingData.put(param.get("Step5"), selectRange(driver, param, test));
		readingData.put(param.get("Step6"), exportData(driver, param, test));
		
		return readingData;
	}

	private String selectAllQuestionXML(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_xml, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			//	Fail the test case if data is being prepared in run time.
			if(driver.findElement(By.xpath(EXPORT_PREPARE_NOTE)).isDisplayed()) {
				test.log(Status.FAIL, "Data is being prepared in survey");
				Add_Log.info("Data is being prepared in survey");
				Reporter.log("Data is being prepared in survey");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Data is being prepared in survey");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}catch (NoSuchElementException e) {
			waitforElemPresent(driver, testcaseName, 30, select_all_questions, test);			
		}finally {
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	public Map<String, String> getAccessExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		readingData.put(param.get("Step1"), selectAllQuestionAceess(driver, param, test));
		readingData.put(param.get("Step2"), selectSurveyAttr(driver, param, test));
		readingData.put(param.get("Step3"), applyFilter(driver, param, test));
		readingData.put(param.get("Step4"), applyAssignCode(driver, param, test));
		readingData.put(param.get("Step5"), selectRange(driver, param, test));
		readingData.put(param.get("Step6"), exportData(driver, param, test));
		
		return readingData;
	}

	private String selectAllQuestionAceess(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_access, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			//	Fail the test case if data is being prepared in run time.
			if(driver.findElement(By.xpath(EXPORT_PREPARE_NOTE)).isDisplayed()) {
				test.log(Status.FAIL, "Data is being prepared in survey");
				Add_Log.info("Data is being prepared in survey");
				Reporter.log("Data is being prepared in survey");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Data is being prepared in survey");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}catch (NoSuchElementException e) {
			waitforElemPresent(driver, testcaseName, 30, select_all_questions, test);			
		}finally {
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	public Map<String, String> getWordExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		readingData.put(param.get("Step1"), selectAllQuestionWord(driver, param, test));
		readingData.put(param.get("Step2"), selectSurveyAttr(driver, param, test));
		readingData.put(param.get("Step3"), applyFilter(driver, param, test));
		readingData.put(param.get("Step4"), applyAssignCode(driver, param, test));
		readingData.put(param.get("Step5"), selectRange(driver, param, test));
		readingData.put(param.get("Step6"), exportData(driver, param, test));
		
		return readingData;
	}

	private String selectAllQuestionWord(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_word, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			//	Fail the test case if data is being prepared in run time.
			if(driver.findElement(By.xpath(EXPORT_PREPARE_NOTE)).isDisplayed()) {
				test.log(Status.FAIL, "Data is being prepared in survey");
				Add_Log.info("Data is being prepared in survey");
				Reporter.log("Data is being prepared in survey");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Data is being prepared in survey");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}catch (NoSuchElementException e) {
			waitforElemPresent(driver, testcaseName, 30, select_all_questions, test);			
		}finally {
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	public Map<String, String> getHtmlExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		readingData.put(param.get("Step1"), selectAllQuestionHtml(driver, param, test));
		readingData.put(param.get("Step2"), selectSurveyAttr(driver, param, test));
		readingData.put(param.get("Step3"), applyFilter(driver, param, test));
		readingData.put(param.get("Step4"), applyAssignCode(driver, param, test));
		readingData.put(param.get("Step5"), selectRange(driver, param, test));
		readingData.put(param.get("Step6"), exportData(driver, param, test));
		
		return readingData;
	}

	private String selectAllQuestionHtml(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_html, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			//	Fail the test case if data is being prepared in run time.
			if(driver.findElement(By.xpath(EXPORT_PREPARE_NOTE)).isDisplayed()) {
				test.log(Status.FAIL, "Data is being prepared in survey");
				Add_Log.info("Data is being prepared in survey");
				Reporter.log("Data is being prepared in survey");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Data is being prepared in survey");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}catch (NoSuchElementException e) {
			waitforElemPresent(driver, testcaseName, 30, select_all_questions, test);			
		}finally {
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	public Map<String, String> getSPSSExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		readingData.put(param.get("Step1"), selectAllQuestionSPSS(driver, param, test));
		readingData.put(param.get("Step2"), selectSurveyAttr(driver, param, test));
		readingData.put(param.get("Step3"), applyFilter(driver, param, test));
		readingData.put(param.get("Step4"), applyAssignCode(driver, param, test));
		readingData.put(param.get("Step5"), selectRange(driver, param, test));
		readingData.put(param.get("Step6"), exportData(driver, param, test));
		
		return readingData;
	}

	private String selectAllQuestionSPSS(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_spss, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			//	Fail the test case if data is being prepared in run time.
			if(driver.findElement(By.xpath(EXPORT_PREPARE_NOTE)).isDisplayed()) {
				test.log(Status.FAIL, "Data is being prepared in survey");
				Add_Log.info("Data is being prepared in survey");
				Reporter.log("Data is being prepared in survey");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Data is being prepared in survey");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}catch (NoSuchElementException e) {
			waitforElemPresent(driver, testcaseName, 30, select_all_questions, test);			
		}finally {
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	public Map<String, String> getProductExportReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		goToDataPage(driver, param, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, export_sogosurvey, test);
		waitForLoad(driver, testcaseName, 30, test);
		downloadFile(driver, param, "xls", test);
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		readingData.put(param.get("Step1"), strtotalTime);
		
		return readingData;
	}
	
}


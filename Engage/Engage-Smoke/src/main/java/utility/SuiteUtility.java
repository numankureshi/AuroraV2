package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;

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

import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import testsuitebase.TestResultStatus;

public class SuiteUtility {
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String colName, HashMap<String, String> TestResultTL) {
		return xls.writeResult(sheetName, colName, TestResultTL);
	}
	
	public static boolean WriteResultUtility1(Read_XLS xls, String sheetName, String colName, ArrayList<String> failureReasons) {
		return xls.writeFailureReasons(sheetName, colName, failureReasons);
	}
	
	public static boolean isValidEmailAddrss(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
	
	public static HashMap<String, String> waitForEmailToBeReceived(HashMap<String, String> param, String host, String userName, String password, String sub, Date currentTime, ExtentTest test) {
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
	
	public static int checkStatusCode(String strUrl) {
		int statusCode = 0;
		try {
			URL url = new URL(strUrl);
			HttpURLConnection.setFollowRedirects(false);
			URLConnection urlConnecttion = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlConnecttion;
			httpUrlConnection.setConnectTimeout(30000);
			httpUrlConnection.connect();
			statusCode = httpUrlConnection.getResponseCode();
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusCode;
	}
	
	public static Map<String, List<String>> getResponseHeaders(String strUrl) {
		Map<String, List<String>> headerFields = new LinkedHashMap<>();
		try {
			URL url = new URL(strUrl);
			HttpURLConnection.setFollowRedirects(false);
			URLConnection urlConnection = url.openConnection();
			headerFields = urlConnection.getHeaderFields();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return headerFields;
	}
	
	public static void saveFile(String strUrl, String strFileName) {
		URL url;
		try {
			url = new URL(strUrl);
			ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
			FileOutputStream fileOutputStream = new FileOutputStream(strFileName);
			FileChannel fileChannel = fileOutputStream.getChannel();
			fileOutputStream.getChannel()
			  .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
			fileChannel.close();
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int randomNumberGenerator(int bound) {
		Random random = new Random();
		return random.nextInt(bound);
	}
	
	public static boolean compareImages(String actualImagePath, String expectedImagePath, String diffImagePath){
		boolean isImageMatches = false;
		//load images to be compared:
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(expectedImagePath);
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(actualImagePath);

        //Create ImageComparison object and compare the images.
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage).compareImages();
        
        //Check the result
        try {
        	Assert.assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
        	isImageMatches = true;
        }catch (AssertionError e) {
        	File outputFile = new File(diffImagePath);
            BufferedImage result = imageComparisonResult.getResult();
            ImageComparisonUtil.saveImage(outputFile, result);
		}
        return isImageMatches;
	}
	
	public static String getHost(String strUrl) {
		String host = null;
		try {
			URL url = new URL(strUrl);
			host = url.getHost();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return host;
	}
}

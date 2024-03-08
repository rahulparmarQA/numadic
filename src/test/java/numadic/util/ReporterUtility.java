package numadic.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

//Extent report 5.x...//version

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import numadic.base.BaseClass;

public class ReporterUtility implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		sparkReporter.config().setDocumentTitle("Numadic Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Numadic");
		extent.setSystemInfo("Module", "Career");
		extent.setSystemInfo("Sub Module", "Engineering");
		extent.setSystemInfo("User Name", "Rahul Parmar");
		extent.setSystemInfo("Environemnt", "QA");

		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + " got successfully executed");

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {

		extent.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// sendEmail("abc@gmail.com","xyz123xyz","xyz@gmail.com");
	}

	/*
	 * public void sendEmail(String senderEmail,String senderPassword,String
	 * recipientEmail) {
	 * 
	 * Properties properties = new Properties(); properties.put("mail.smtp.auth",
	 * "true"); properties.put("mail.smtp.starttls.enable", "true");
	 * properties.put("mail.smtp.host", "smtp.gmail.com");
	 * properties.put("mail.smtp.port", "587");
	 * 
	 * Session session = Session.getInstance(properties, new Authenticator() {
	 * protected PasswordAuthentication getPasswordAuthentication() { return new
	 * PasswordAuthentication(senderEmail, senderPassword); } });
	 * 
	 * try { // Create a MimeMessage object Message message = new
	 * MimeMessage(session);
	 * 
	 * // Set the sender and recipient addresses message.setFrom(new
	 * InternetAddress(senderEmail)); message.setRecipient(Message.RecipientType.TO,
	 * new InternetAddress(recipientEmail));
	 * 
	 * // Set the subject message.setSubject("Test Report with attachment");
	 * 
	 * // Create a MimeMultipart object Multipart multipart = new MimeMultipart();
	 * 
	 * // Attach the file String filePath = ".\\reports\\"+repName; String fileName
	 * = repName;
	 * 
	 * MimeBodyPart attachmentPart = new MimeBodyPart();
	 * attachmentPart.attachFile(filePath); attachmentPart.setFileName(fileName);
	 * 
	 * // Create a MimeBodyPart for the text content MimeBodyPart textPart = new
	 * MimeBodyPart(); textPart.setText("Please find the attached file.");
	 * 
	 * // Add the parts to the multipart multipart.addBodyPart(textPart);
	 * multipart.addBodyPart(attachmentPart);
	 * 
	 * // Set the content of the message message.setContent(multipart);
	 * 
	 * // Send the message Transport.send(message);
	 * 
	 * System.out.println("Email sent successfully!");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

}

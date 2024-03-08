package numadic.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobDesPage extends BasePage {

	public JobDesPage(WebDriver driver) {
		super(driver);
	}

	BasePage bp = new BasePage(driver);

	@FindBy(xpath = "//h1[normalize-space()='QA Engineer']")
	WebElement headerText;

	@FindBy(xpath = "//lyte-button[@id='detail-page-applybtn']//button[@type='button']")
	WebElement imInterestedBtn;

	@FindBy(xpath = "//span[normalize-space()='Job application']")
	WebElement jobApplicationText;

	@FindBy(xpath = "//lyte-drop-button[contains(@data-zcqa,'manual_Salutation')]")
	WebElement salutionDrop;

	@FindBy(xpath = "//lyte-drop-item[contains(@id,'Lyte_Drop_Item_')]")
	List<WebElement> salutionDropList;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement email;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement mobile;

	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement street;

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement city;

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement state;

	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement postalCode;

	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement country;

	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement currentEmployer;

	@FindBy(xpath = "//lyte-drop-button[contains(@data-zcqa,'manual_Current_Job_Title')]//span[contains(@class,'lyteDropPlaceholderNormal')][normalize-space()='-None-']")
	WebElement jobDrop;

	@FindBy(xpath = "//lyte-drop-item[contains(@id,'Lyte_Drop_Item_')]")
	List<WebElement> jobDropList;

	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement currentCTC;

	@FindBy(xpath = "(//input[@type='text'])[12]")
	WebElement expectedCTC;

	@FindBy(xpath = "(//input[@type='text'])[13]")
	WebElement noticePeriod;

	@FindBy(xpath = "(//input[@type='text'])[14]")
	WebElement reason;

	@FindBy(xpath = "(//input[@type='text'])[15]")
	WebElement whyJoin;

	@FindBy(xpath = "(//input[@type='text'])[16]")
	WebElement linkedIn;

	@FindBy(xpath = "//span[text()='First Name cannot be empty.']")
	WebElement firstnameVal;

	@FindBy(xpath = "//span[text()='Last Name cannot be empty.']")
	WebElement lastnameVal;

	@FindBy(xpath = "//span[text()='Email cannot be empty.']")
	WebElement emailVal;

	@FindBy(xpath = "//span[text()='Mobile cannot be empty.']")
	WebElement mobileVal;

	@FindBy(xpath = "//span[text()='Current Employer cannot be empty.']")
	WebElement currentEmpVal;

	@FindBy(xpath = "//span[text()='Current Job Title cannot be empty.']")
	WebElement currentJobVal;

	@FindBy(xpath = "//span[text()='Current CTC cannot be empty.']")
	WebElement currentCTCVal;

	@FindBy(xpath = "//span[text()='Expected CTC cannot be empty.']")
	WebElement expectedCTCVal;

	@FindBy(xpath = "//span[text()='Notice Period (days) cannot be empty.']")
	WebElement NoticePeriodVal;

	@FindBy(xpath = "//span[text()='Reason for change from current organization? cannot be empty.']")
	WebElement reasonVal;

	@FindBy(xpath = "//span[text()='Resume cannot be empty.']")
	WebElement resumeVal;

	@FindBy(xpath = "//lyte-yield[normalize-space()='Submit Application']")
	WebElement submitBtn;

	public String getHeaderText() {
		String text = headerText.getText();
		return text;
	}

	public String getPageTitleText() {
		String text = driver.getTitle();
		return text;
	}

	public void clickImInterested() {
		if (imInterestedBtn.isEnabled()) {
			imInterestedBtn.click();
		}
	}

	public String getJobAppText() {
		return jobApplicationText.getText();
	}

	public void clickSubmit() {
		bp.scrollToElement(submitBtn);
		submitBtn.click();
	}

	public String getFirstNameValidation() {
		bp.scrollToElement(firstnameVal);
		return firstnameVal.getText();
	}

	public String getLastNameValidation() {
		bp.scrollToElement(lastnameVal);
		return lastnameVal.getText();
	}

	public String getEmailValidation() {
		bp.scrollToElement(emailVal);
		return emailVal.getText();
	}

	public String getMobileValidation() {
		bp.scrollToElement(mobileVal);
		return mobileVal.getText();
	}

	public String getEmployerValidation() {
		bp.scrollToElement(currentEmpVal);
		return currentEmpVal.getText();
	}

	public String getjobValidation() {
		bp.scrollToElement(currentJobVal);
		return currentJobVal.getText();
	}

	public String getCurrentCTCValidation() {
		bp.scrollToElement(currentCTCVal);
		return currentCTCVal.getText();
	}

	public String getExpectedCTCValidation() {
		bp.scrollToElement(expectedCTCVal);
		return expectedCTCVal.getText();
	}

	public String getnoticePeriodValidation() {
		bp.scrollToElement(NoticePeriodVal);
		return NoticePeriodVal.getText();
	}

	public String getReasonValidation() {
		bp.scrollToElement(reasonVal);
		return reasonVal.getText();
	}

	public String getResumeValidation() {
		bp.scrollToElement(resumeVal);
		return resumeVal.getText();
	}

	public void setFirstname(String text) {
		bp.scrollToElement(firstName);
		firstName.sendKeys(text);
	}

	public void setLastname(String text) {
		lastName.sendKeys(text);
	}

	public void setEmail(String text) {
		email.sendKeys(text);
	}

	public void setMobile(String text) {
		mobile.sendKeys(text);
	}
	public void setEmployer(String text) {
		bp.scrollToElement(currentEmployer);
		currentEmployer.sendKeys(text);
	}
	public void setJob(String text) {
		jobDrop.click();
		jobDropList.get(1).click();
	}
	public void setCurrentCTC(String text) {
		currentCTC.sendKeys(text);
	}
	public void setExpectedCTC(String text) {
		expectedCTC.sendKeys(text);
	}
	public void setNoticePeriod(String text) {
		bp.scrollToElement(noticePeriod);
		noticePeriod.sendKeys(text);
	}
	public void setReason(String text) {
		reason.sendKeys(text);
	}

}

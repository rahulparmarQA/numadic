package numadic.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import numadic.base.BaseClass;
import numadic.pom.JobDesPage;
import numadic.pom.JobsPage;
import numadic.util.YamlDataUtil;

public class Test_01 extends BaseClass {

	@Test(priority = 1, dataProviderClass = YamlDataUtil.class, dataProvider = "verifyHeader")
	public void verifyHeader(HashMap<String, String> hp) {
		JobsPage jp = new JobsPage(driver);
		Assert.assertEquals(jp.getHeaderText(), hp.get("text"));
	}

	@Test(priority = 2, dataProviderClass = YamlDataUtil.class, dataProvider = "filterQA")
	public void filterQA(HashMap<String, String> hp) {
		JobsPage jp = new JobsPage(driver);
		jp.selectFilter(hp.get("filterby"));
		jp.selectQAJob();
		JobDesPage jd = new JobDesPage(driver);
		Assert.assertEquals(jd.getHeaderText(), hp.get("job"));
	}

	@Test(priority = 3, dataProviderClass = YamlDataUtil.class, dataProvider = "verifyPageTitle")
	public void verifyPageTitle(HashMap<String, String> hp) {
		JobDesPage jd = new JobDesPage(driver);
		Assert.assertEquals(jd.getPageTitleText(), hp.get("title"));

	}

	@Test(priority = 4, dataProviderClass = YamlDataUtil.class, dataProvider = "clickInterested")
	public void clickInterested(HashMap<String, String> hp) {
		JobDesPage jd = new JobDesPage(driver);
		jd.clickImInterested();
		Assert.assertEquals(jd.getJobAppText(), hp.get("text"));
	}

	@Test(priority = 5, dataProviderClass = YamlDataUtil.class, dataProvider = "verifyValidation")
	public void verifyValidation(HashMap<String, String> hp) {
		JobDesPage jd = new JobDesPage(driver);

		jd.clickSubmit();

		SoftAssert myassert = new SoftAssert();
		myassert.assertEquals(jd.getFirstNameValidation(), hp.get("firstname"));
		myassert.assertEquals(jd.getLastNameValidation(), hp.get("lastname"));
		myassert.assertEquals(jd.getEmailValidation(), hp.get("email"));
		myassert.assertEquals(jd.getMobileValidation(), hp.get("mobile"));

		myassert.assertEquals(jd.getEmployerValidation(), hp.get("employer"));
		myassert.assertEquals(jd.getjobValidation(), hp.get("job"));
		myassert.assertEquals(jd.getCurrentCTCValidation(), hp.get("currentctc"));
		myassert.assertEquals(jd.getExpectedCTCValidation(), hp.get("expectedctc"));

		myassert.assertEquals(jd.getnoticePeriodValidation(), hp.get("noticeperiod"));
		myassert.assertEquals(jd.getReasonValidation(), hp.get("reason"));

		myassert.assertEquals(jd.getResumeValidation(), hp.get("resume"));

		myassert.assertAll();
	}

	@Test(priority = 6, dataProviderClass = YamlDataUtil.class, dataProvider = "applcationFill")
	public void applcationFill(HashMap<String, String> hp) {
		JobDesPage jd = new JobDesPage(driver);
		jd.setFirstname(hp.get("firstname"));
		jd.setLastname(hp.get("lastname"));
		jd.setEmail(hp.get("email"));
		jd.setMobile(hp.get("mobile"));
		jd.setEmployer(hp.get("employer"));
		jd.setJob(hp.get("job"));
		jd.setCurrentCTC(hp.get("currentctc"));
		jd.setExpectedCTC(hp.get("expectedctc"));
		jd.setNoticePeriod(hp.get("noticeperiod"));
		jd.setReason(hp.get("reason"));

		jd.clickSubmit();

		Assert.assertFalse(false);

	}
}

package numadic.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsPage extends BasePage {

	public JobsPage(WebDriver driver) {
		super(driver);
	}

	BasePage bp = new BasePage(driver);

	@FindBy(xpath = "//h2[normalize-space()='JOIN OUR CREW']")
	WebElement headerText;

	@FindBy(tagName = "lyte-drop-button")
	WebElement filterBy;

	@FindBy(xpath = "//lyte-drop-item[@id='Lyte_Drop_Item_2']")
	WebElement engineerFilter;

	@FindBy(xpath = "//*[contains(text(),'QA Engineer')]")
	WebElement qaJobOption;

	public String getHeaderText() {
		String text = headerText.getText();
		return text;
	}

	public void selectFilter(String text) {

		bp.scrollToElement(filterBy);
		filterBy.click();
		if (text.equalsIgnoreCase(engineerFilter.getText())) {
			engineerFilter.click();
		} else {
			engineerFilter.click();
		}
	}

	public void selectQAJob() {
		if (qaJobOption.isDisplayed()) {
			bp.scrollToElement(qaJobOption);
			qaJobOption.click();
		} else {
			qaJobOption.click();
		}
	}

}

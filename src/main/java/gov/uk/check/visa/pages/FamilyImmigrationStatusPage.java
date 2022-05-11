package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyImmigrationStatusPage extends Utility {
    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    @FindBy(xpath = "//div[@class='govuk-radios']//input[@id='response-0']")
    WebElement yesRadio;
    @FindBy(xpath = "//div[@class='govuk-radios']//input[@id='response-1']")
    WebElement noRadio;

    public void clickNextStepButton() {
        CustomListeners.test.log(Status.PASS, "click on next button : " + nextStepButton);
        clickOnElement(nextStepButton);
    }

    public void selectImmigrationStatus(String status) {

        switch (status) {
            case "yes":
                CustomListeners.test.log(Status.PASS, "Selecting on Yes : " + status+ " to " + yesRadio);
                clickOnElement(yesRadio);
                break;
            case "no":
                CustomListeners.test.log(Status.PASS, "Selecting on No : " + status+ " to " + noRadio);
                clickOnElement(noRadio);
                break;
        }
    }


}

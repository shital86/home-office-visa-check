package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    @FindBy(xpath = "//div[@class='govuk-radios']//div/input")
    List<WebElement> reasonForVisitList;
    public void clickNextStepButton(){
        CustomListeners.test.log(Status.PASS, "click on Next: " + nextStepButton);
        clickOnElement(nextStepButton);

    }

    public void selectReasonForVisit(String reason) {
        CustomListeners.test.log(Status.PASS, "Reason For Visit List: " + reasonForVisitList);
        int size = reasonForVisitList.size();
        for (int i = 0; i < size; i++) {
            String val = reasonForVisitList.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(reason)) {
                reasonForVisitList.get(i).click();
                break;
            }
        }
    }
}

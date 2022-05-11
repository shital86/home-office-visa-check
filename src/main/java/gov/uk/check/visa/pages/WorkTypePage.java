package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkTypePage extends Utility {

    public WorkTypePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    @FindBy(xpath = "//div[@class='govuk-radios']//div/input")
    List<WebElement> selectJobtypeList;

    public void selectJobType(String job) {
        CustomListeners.test.log(Status.PASS, "Select Job Type: " + selectJobtypeList);
        int size = selectJobtypeList.size();
        for (int i = 0; i < size; i++) {
            String val = selectJobtypeList.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(job))
                selectJobtypeList.get(i).click();
            break;
        }
    }

    public void clickNextStepButton() {
        CustomListeners.test.log(Status.PASS, "Click On Next Button: " + nextStepButton);
        clickOnElement(nextStepButton);
    }
}

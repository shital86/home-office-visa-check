package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultPage extends Utility {
    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='result-info']//div[2]/h2")
    WebElement resultMessage;

    public String getResultMessage() {
        CustomListeners.test.log(Status.PASS, "Get Text Result: " + resultMessage);
        return getTextFromElement(resultMessage);
    }

    public void confirmResultMessage(String expectedMessage) {
        CustomListeners.test.log(Status.PASS, "Verifying the result: " + expectedMessage);
        Assert.assertTrue(expectedMessage != getResultMessage(), "Test Failed");
    }

}

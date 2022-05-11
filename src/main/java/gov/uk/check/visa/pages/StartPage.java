package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Utility{
    public StartPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[contains(text(),'Accept additional cookies')]")
    WebElement acceptAdditionalCookies;
    @FindBy(xpath = "//body/div[@id='wrapper']/div[1]/main[1]/div[2]/div[1]/article[1]/section[1]/a[1]")
    WebElement startNow;
    public void clickStartNow(){
        CustomListeners.test.log(Status.PASS, "Click On Start Now Button: " + startNow);

        clickOnElement(startNow);
    }
}
package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {
    StartPage startPage;
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    WorkTypePage workTypePage;


    @BeforeMethod(alwaysRun = true)
    public void init() {
        startPage = new StartPage();
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        selectNationalityPage = new SelectNationalityPage();
        workTypePage = new WorkTypePage();
    }

    @Test(groups = {"sanity","regression"})
    public void anAustralianCominToUKForTourism() throws InterruptedException {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("australia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("tourism");
        reasonForTravelPage.clickNextStepButton();
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("chile");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("work");
        reasonForTravelPage.clickNextStepButton();
        Thread.sleep(1000);
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType("health");
        workTypePage.clickNextStepButton();
        resultPage.confirmResultMessage("You need a visa to work in health and care");

    }

    @Test(groups = {"sanity","smoke","regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
        startPage.clickStartNow();
        selectNationalityPage.selectNationality("colombia");
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit("family");
        reasonForTravelPage.clickNextStepButton();
        familyImmigrationStatusPage.selectImmigrationStatus("yes");
        familyImmigrationStatusPage.clickNextStepButton();
        resultPage.confirmResultMessage("You’ll need a visa to join your family or partner in the UK");
    }
}

package StepDefinition;

import POM.DialogContent;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class _02_Contact_Us {

    DialogContent dialogContent = new DialogContent();

    @And("^Navigate to Contact_us$")
    public void navigateToContact_us() {

        dialogContent.findElementAndClickFunction("ContactButton");


    }

    @When("^Fill out the message box \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
    public void fillOutTheMessageBoxAnd(String subject, String id_order, String product) {

        dialogContent.findElementAndClickFunction("subjectHeadingButton");
        dialogContent.clickOnElementInTheDropdown("SubjectHeading", subject);
        dialogContent.clickOnElementInTheDropdown("IdOrder", id_order);
        dialogContent.clickOnElementInTheDropdown("Product", product);
        dialogContent.findElementAndSendKeysFunction("TextMessage", "Cucumber is Best!!!");
        dialogContent.findElementAndClickFunction("SubmittButton");


    }


    @Then("^Success message should be displayed$")
    public void successMessageShouldBeDisplayed() {

        dialogContent.findElementAndVerifyElementContainText("SuccessfullyMessage", "successfully");

    }


}

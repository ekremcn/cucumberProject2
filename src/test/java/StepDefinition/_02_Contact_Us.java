package StepDefinition;

import POM.ContactUsPOM;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class _02_Contact_Us {

    ContactUsPOM contactUsPOM = new ContactUsPOM();

    @And("^Navigate to Contact_us$")
    public void navigateToContact_us() {

        contactUsPOM.findElementAndClickFunction("ContactButton");


    }

    @When("^Fill out the message box \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
    public void fillOutTheMessageBoxAnd(String subject, String id_order, String product) {

        contactUsPOM.findElementAndClickFunction("subjectHeadingButton");
        contactUsPOM.clickOnElementInTheDropdown("SubjectHeading", subject);
        contactUsPOM.clickOnElementInTheDropdown("IdOrder", id_order);
        contactUsPOM.clickOnElementInTheDropdown("Product", product);
        contactUsPOM.findElementAndSendKeysFunction("TextMessage", "Cucumber is Best!!!");
        contactUsPOM.findElementAndClickFunction("SubmittButton");


    }


    @Then("^Success message should be displayed$")
    public void successMessageShouldBeDisplayed() {

        contactUsPOM.findElementAndVerifyElementContainText("SuccessfullyMessage", "successfully");

    }


}

package StepDefinition;

import POM.DialogContent;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class _03_Specials {

    DialogContent dialogContent=new DialogContent();

    @And("^Navigate to Specials$")
    public void navigateToSpecials() {

    dialogContent.findElementAndClickFunction("SpecialsButton");
    }

    @Then("^I should see the discount on the price$")
    public void iShouldSeeTheDiscountOnThePrice() {
        dialogContent.twoListIstEqual();
    }


}

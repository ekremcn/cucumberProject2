package StepDefinition;

import POM.ContactUsPOM;
import POM.SpecialsPOM;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class _03_Specials {

    SpecialsPOM specials =new SpecialsPOM();

    @And("^Navigate to Specials$")
    public void navigateToSpecials() {

        specials.findElementAndClickFunction("SpecialsButton");
    }

    @Then("^I should see the discount on the price$")
    public void iShouldSeeTheDiscountOnThePrice() {

        specials.twoListIstEqual();
    }


}

package StepDefinition;

import POM.SocialMediaPOM;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;


public class _05_SocialMedia {


    SocialMediaPOM socialMediaPOM = new SocialMediaPOM();


    @When("^User click the SocialMedia icons CurrentUrl should be displayed$")
    public void userClickTheSocialMediaIconsCurrentUrlShouldBeDisplayed(DataTable table) {

        socialMediaPOM.successfullyNavigateToFollowingPagesAndVerify(table);

    }


}

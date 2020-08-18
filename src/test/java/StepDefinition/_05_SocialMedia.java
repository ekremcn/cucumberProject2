package StepDefinition;

import POM.SocialMediaPOM;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class _05_SocialMedia {


    SocialMediaPOM socialMediaPOM = new SocialMediaPOM();


    @When("^User click the SocialMedia icons CurrentUrl should be displayed$")
    public void userClickTheSocialMediaIconsCurrentUrlShouldBeDisplayed(DataTable table) {

        socialMediaPOM.successfullyNavigateToFollowingPagesAndVerify(table);

    }


}

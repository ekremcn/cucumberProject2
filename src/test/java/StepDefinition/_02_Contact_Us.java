package StepDefinition;

import POM.DialogContent;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class _02_Contact_Us {

    DialogContent dialogContent=new DialogContent();

    @And("^Navigate to Contact_us$")
    public void navigateToContact_us() {

    dialogContent.findElementAndClickFunction("ContactButton");


    }

    @When("^Fill out the message box \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
    public void fillOutTheMessageBoxAnd(String subject, String id_order, String product)  {

//        Select select1=new Select(driver.findElement(By.id("id_contact")));
//        select1.selectByVisibleText(subject);

        dialogContent.clickOnElementInTheDropdown("SubjectHeading",subject);

//        WebElement id_order = driver.findElement(By.name("id_order"));
//        Select select2=new Select(id_order);
        //     select2.selectByValue(arg1);

        dialogContent.clickOnElementInTheDropdown("IdOrder", id_order);


//        WebElement product = driver.findElement(By.cssSelector("select[style='display: inline-block;']"));
//        Select select3=new Select(product);
//        select3.selectByIndex(1);

        dialogContent.clickOnElementInTheDropdown("Product",product);

        dialogContent.findElementAndSendKeysFunction("TextMessage", "Cucumber is Best!!!");

//        contact.waitAndSendKeys(By.id("message"),"sfs");
       // contact.waitAndClick(By.id("submitMessage"));
        dialogContent.findElementAndClickFunction("SubmittButton");



    }

//
//    @Then("^\"([^\"]*)\" has been successfully \"([^\"]*)\" to our team\\.$")
//    public void hasBeenSuccessfullyToOurTeam(String entityName, String outcome) {
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
//
//        String actual = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
//        Assert.assertEquals(actual, entityName + " has been successfully " + outcome+" to our team.");
//        contact.waitAndClick(By.cssSelector("a[title='Log me out']"));
//
//    }

    @Then("^Success message should be displayed$")
    public void successMessageShouldBeDisplayed() {

        dialogContent.findElementAndVerifyElementContainText("SuccessfullyMessage", "successfully sent to our team");
        dialogContent.findElementAndClickFunction("LogOutButton");
    }
}

package StepDefinition;

import POM.DialogContent;
import Utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class _04_OrderHistory {

    public WebDriver driver = Driver.getDriver();
    DialogContent dialogContent = new DialogContent();
    String modelName;


    @And("^Navigate to Dresses page$")
    public void navigateToDressesPage() {

        dialogContent.findElementAndClickFunction("DressesButton");

    }

    @Then("^Choose a random item and add it to the cart$")
    public void chooseARandomItemAndAddItToTheCart() {

        dialogContent.randomChooseAndClick();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        modelName =driver.findElement(By.cssSelector(".editable")).getText();

        dialogContent.findElementAndClickFunction("addToCart");
        dialogContent.findElementAndClickFunction("proceedButton");
    }

    @And("^Verify the total price of the product$")
    public void verifyTheTotalPriceOfTheProduct() {
        dialogContent.isTotalSame();
    }

    @And("^Proceed to the checkout page$")
    public void proceedToTheCheckoutPage() {
        dialogContent.findElementAndClickFunction("proceedButton2");
        dialogContent.findElementAndClickFunction("proceedButton3");
        dialogContent.findElementAndClickFunction("agreeButton");
        dialogContent.findElementAndClickFunction("proceedButton4");
    }

    @When("^I do payment and confirm it$")
    public void iDoPaymentAdnConfirmIt() {
        dialogContent.findElementAndClickFunction("PayBankWire");
        dialogContent.findElementAndClickFunction("confirmOrder");
    }

    @Then("^Order confirmation message should be appeared$")
    public void orderConfirmationMessageShouldBeAppeared() {
        dialogContent.findElementAndVerifyElementContainText("orderConfirm", "Your order on My Store is complete");
    }

    @Given("^Navigate to the My Order page$")
    public void navigateToTheMyOrderPage() {
        dialogContent.findElementAndClickFunction("MyOrders");
    }

    @Then("^The last order name in the table should be the same as the name of the ordered item$")
    public void theLastOrderNameInTheTableShouldBeTheSameAsTheNameOfTheOrderedItem() {
        dialogContent.findElementAndClickFunction("firstOrder");
        dialogContent.findElementAndClickFunction("details");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1500);");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement modelInOrderHistory=driver.findElement((By.xpath("(//table[@class='table table-bordered']/tbody/tr/td)[1]")));
        String element = modelInOrderHistory.getText();
        System.out.println(element);
        System.out.println(modelName);
        Assert.assertEquals(modelName,element);

    }


}
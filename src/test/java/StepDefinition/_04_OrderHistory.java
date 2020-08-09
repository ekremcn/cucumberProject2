package StepDefinition;

import POM.ContactUsPOM;
import POM.OrderHistoryPOM;
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
    OrderHistoryPOM order = new OrderHistoryPOM();
    String modelName;


    @And("^Navigate to Dresses page$")
    public void navigateToDressesPage() {

        order.findElementAndClickFunction("DressesButton");

    }

    @Then("^Choose a random item and add it to the cart$")
    public void chooseARandomItemAndAddItToTheCart() {

        order.randomChooseAndClick();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        modelName =driver.findElement(By.cssSelector(".editable")).getText();

        order.findElementAndClickFunction("addToCart");
        order.findElementAndClickFunction("proceedButton");
    }

    @And("^Verify the total price of the product$")
    public void verifyTheTotalPriceOfTheProduct() {
        order.isTotalSame();
    }

    @And("^Proceed to the checkout page$")
    public void proceedToTheCheckoutPage() {
        order.findElementAndClickFunction("proceedButton2");
        order.findElementAndClickFunction("proceedButton3");
        order.findElementAndClickFunction("agreeButton");
        order.findElementAndClickFunction("proceedButton4");
    }

    @When("^I do payment and confirm it$")
    public void iDoPaymentAdnConfirmIt() {
        order.findElementAndClickFunction("PayBankWire");
        order.findElementAndClickFunction("confirmOrder");
    }

    @Then("^Order confirmation message should be appeared$")
    public void orderConfirmationMessageShouldBeAppeared() {
        order.findElementAndVerifyElementContainText("orderConfirm", "Your order on My Store is complete");
    }

    @Given("^Navigate to the My Order page$")
    public void navigateToTheMyOrderPage() {

        order.findElementAndClickFunction("MyOrders");
    }

    @Then("^The last order name in the table should be the same as the name of the ordered item$")
    public void theLastOrderNameInTheTableShouldBeTheSameAsTheNameOfTheOrderedItem() {
        order.findElementAndClickFunction("firstOrder");
        order.findElementAndClickFunction("details");


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
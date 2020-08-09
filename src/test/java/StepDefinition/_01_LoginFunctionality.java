package StepDefinition;

import POM.ContactUsPOM;
import POM._01_ParentClass;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class _01_LoginFunctionality {

    _01_ParentClass parentClass = new _01_ParentClass();
    ContactUsPOM contactUsPOM = new ContactUsPOM();
    WebDriver driver;

    @Given("^Navigate to site$")
    public void navigate_to_basqar() {
        driver = Driver.getDriver();

        driver.get("http://automationpractice.com/index.php");
        //  driver.manage().window().maximize();
    }

    @When("^Enter the username and password and click on login button$")
    public void enter_the_username_and_password_and_click_on_login_button() {

        contactUsPOM.findElementAndClickFunction("loginButton");
        contactUsPOM.findElementAndSendKeysFunction("emailInput", "ekrem20092013@gmail.com");
        contactUsPOM.findElementAndSendKeysFunction("password", "3229e");
        contactUsPOM.findElementAndClickFunction("signIn");
    }

    @Then("^User should login successfully$")
    public void user_should_login_successfully() {
        WebElement verifyLogin = driver.findElement(By.linkText("Contact us"));
        parentClass.ElementContainsText(verifyLogin, "Contact");
    }


}

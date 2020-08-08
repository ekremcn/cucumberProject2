package StepDefinition;

import POM._01_ParentClass;
import Utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class _01_LoginFunctionality {
    _01_ParentClass parentClass = new _01_ParentClass();
    WebDriver driver;

    @Given("^Navigate to site$")
    public void navigate_to_basqar() {
        driver = Driver.getDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @When("^Enter the username and password and click on login button$")
    public void enter_the_username_and_password_and_click_on_login_button() {

        driver.findElement(By.className("login")).click();

        parentClass.waitUntilVisible(driver.findElement(By.id("email")));
        WebElement emailAdresse = driver.findElement(By.id("email"));
        emailAdresse.sendKeys("ekrem20092013@gmail.com");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("3229e");

        WebElement signIn = driver.findElement(By.cssSelector("span>i[class='icon-lock left']"));
        signIn.click();

    }

    @Then("^User should login successfully$")
    public void user_should_login_successfully() {
        WebElement verifyLogin = driver.findElement(By.linkText("Contact us"));
       parentClass.ElementContainsText(verifyLogin,"Contact");
    }


}

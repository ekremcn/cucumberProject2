package POM;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class _01_ParentClass {
    WebDriver driver;
    WebDriverWait wait;

    public _01_ParentClass() {

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
    }
    //    Click on element method
    public void clickFunction(WebElement element){

        waitUntilClickable(element);
        element.click();

    }

    //    Send keys function
    public void sendKeysFunction(WebElement element , String value){

        waitUntilVisible(element);
        element.clear();
        element.sendKeys(value);

    }

    //    Waiting until element become visible
    public void waitUntilVisible(WebElement elementToWait){

        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }


    //    WaitForClickable
    public void waitUntilClickable(WebElement elmentToWait){

        wait.until(ExpectedConditions.elementToBeClickable(elmentToWait));
    }

    //  Verify element is contains specific text
    public void ElementContainsText(WebElement element , String myText){

        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(myText));
    }


    public double StringToDouble(String str){
        return Double.parseDouble(str.replace("$",""));
    }
}
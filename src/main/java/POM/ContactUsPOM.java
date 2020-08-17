package POM;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.List;
import java.util.Random;

public class ContactUsPOM extends _01_ParentClass {

    public ContactUsPOM() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    //  LOGIN ELEMENTS
    @FindBy(css = ".login")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(css = "span>i[class='icon-lock left']")
    private WebElement signIn;


    //  CONTACT_US ELEMENTS
    @FindBy(css = "a[title='Contact Us']")
    private WebElement ContactButton;

    @FindBy(id = "uniform-id_contact")
    private WebElement subjectHeadingButton;

    @FindBy(id = "submitMessage")
    private WebElement SubmittButton;

    @FindBy(css = "a[title='Log me out']")
    private WebElement LogOutButton;

    @FindBy(css = "textarea[id='message']")
    private WebElement TextMessage;

    @FindBy(css = ".alert.alert-success")
    private WebElement SuccessfullyMessage;

    @FindBy(css = "select[id='id_contact']>option")
    private List<WebElement> SubjectHeading;

    @FindBy(name = "id_order")
    private List<WebElement> IdOrder;

    @FindBy(css = "select[style='display: inline-block;']")
    private List<WebElement> Product;


    WebElement myElement;

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {

            case "loginButton":
                myElement = loginButton;
                break;
            case "signIn":
                myElement = signIn;
                break;
            case "ContactButton":
                myElement = ContactButton;
                break;
            case "SubmittButton":
                myElement = SubmittButton;
                break;
            case "LogOutButton":
                myElement = LogOutButton;
                break;
            case "subjectHeadingButton":
                myElement = subjectHeadingButton;
                break;

        }

        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String ElementName, String value) {

        switch (ElementName) {
            case "TextMessage":
                myElement = TextMessage;
                break;
            case "emailInput":
                myElement = emailInput;
                break;
            case "password":
                myElement = password;
                break;

        }
        sendKeysFunction(myElement, value);
    }


    public void findElementAndVerifyElementContainText(String elementName, String WhichText) {

        switch (elementName) {

            case "SuccessfullyMessage":
                myElement = SuccessfullyMessage;
                break;

        }
        ElementContainsText(myElement, WhichText);
    }


    List<WebElement> myDropdownElement;

    public void clickOnElementInTheDropdown(String elementName, String whichOption) {

        switch (elementName) {

            case "SubjectHeading":
                myDropdownElement = SubjectHeading;
                break;
            case "IdOrder":
                myDropdownElement = IdOrder;
                break;
            case "Product":
                myDropdownElement = Product;
                break;

        }

        for (int i = 0; i < myDropdownElement.size(); i++) {
            if (myDropdownElement.get(i).getText().contains(whichOption)) {
                myDropdownElement.get(i).click();
                break;
            }
        }
    }

}


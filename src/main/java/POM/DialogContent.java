package POM;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends _01_ParentClass {

    public DialogContent() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "a[title='Contact Us']")
    private WebElement ContactButton;

    @FindBy(id = "submitMessage")
    private WebElement SubmittButton;

    @FindBy(css = "a[title='Log me out']")
    private WebElement LogOutButton;

    @FindBy(css = "textarea[id='message']")
    private WebElement TextMessage;

    @FindBy(css = ".alert.alert-success")
    private WebElement SuccessfullyMessage;

    @FindBy(id = "id_contact")
    private List<WebElement> SubjectHeading;

    @FindBy(name = "id_order")
    private List<WebElement> IdOrder;

    @FindBy(css = "select[style='display: inline-block;']")
    private List<WebElement> Product;



    WebElement myElement;

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {

            case "ContactButton":
                myElement = ContactButton;
                break;
            case "SubmittButton":
                myElement = SubmittButton;
                break;
            case "LogOutButton":
                myElement = LogOutButton;
                break;

        }

        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String ElementName, String value) {

        switch (ElementName) {
            case "TextMessage":
                myElement = TextMessage;
                break;
        }
        sendKeysFunction(myElement, value);
    }


    public void findElementAndVerifyElementContainText(String elementName , String WhichText){

        switch (elementName){

            case "SuccessfullyMessage":
                myElement=SuccessfullyMessage;
                break;
        }
        ElementContainsText(myElement , WhichText);
    }


    List<WebElement> myDropdownElement;

    public void clickOnElementInTheDropdown(String elementName, String whichOption){

        switch (elementName){

            case "SubjectHeading":
                myDropdownElement=SubjectHeading;
                break;
            case "IdOrder":
                myDropdownElement=IdOrder;
                break;
            case "Product":
                myDropdownElement=Product;
                break;

        }


        for(int i = 0 ; i<myDropdownElement.size() ; i++){

            if(myDropdownElement.get(i).getText().contains(whichOption)){

                myDropdownElement.get(i).click();
                break;
            }

        }

    }

}


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

    @FindBy(xpath = "//ms-add-button//button")
    private WebElement AddButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement NameInput;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement SuccessfullyMessage;

    @FindBy(xpath = "//span[@class='mat-option-text']")
    private List<WebElement> userTypeAllOptions;



    WebElement myElement;

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {

            case "AddButton":
                myElement = AddButton;
                break;

        }

        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String ElementName, String value) {

//        Find the element in this class and send the element to sendKeysFunction
        switch (ElementName) {
            case "NameInput":
                myElement = NameInput;
                break;


        }
//            Create a method in parentClass which is going to wait first and sendKeys
        sendKeysFunction(myElement, value);
    }

    public void findElementAndVerifyElementContainText(String elementName , String WhichText){

        switch (elementName){

            case "SuccessfullyMessage":
                myElement=SuccessfullyMessage;
                break;

        }

//            Creating one method in parent class which is get the element and it is containing the WhichText(parameter)

        ElementContainsText(myElement , WhichText);

    }

    public void clickOnElementInTheDropdown(String whichOption){

        for(int i = 0 ; i<userTypeAllOptions.size() ; i++){

            if(userTypeAllOptions.get(i).getText().contains(whichOption)){

                userTypeAllOptions.get(i).click();
                break;
            }

        }

    }

}


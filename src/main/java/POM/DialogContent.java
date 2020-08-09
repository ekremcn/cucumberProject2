package POM;

import Utilities.Driver;
import cucumber.api.java.ca.I;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.util.List;
import java.util.Random;

public class DialogContent extends _01_ParentClass {

    public DialogContent() {

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


    //SPECIALS ELEMENTS
    @FindBy(css = "a[title='Specials']")
    private WebElement SpecialsButton;

    @FindBy(xpath = "//div[@class='right-block']//span[@class='price-percent-reduction']")
    private List<WebElement> Discounts;

    @FindBy(css = "h5[itemprop='name']")
    private List<WebElement> ItemList;


    //ORDER HISTORY

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    private WebElement DressesButton;

    @FindBy(css = ".product_img_link")
    private List<WebElement> dressList;

    @FindBy(css = "p[id='add_to_cart']>button")
    private WebElement addToCart;

    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedButton;


    @FindBy(id = "total_product")
    private WebElement TotalProduct;

    @FindBy(id = "total_shipping")
    private WebElement TotalShipping;

    @FindBy(id = "total_tax")
    private WebElement TotalTax;

    @FindBy(id = "total_price")
    private WebElement TotalPrice;

    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    private WebElement proceedButton2;

    @FindBy(css = "button[name='processAddress']")
    private WebElement proceedButton3;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement proceedButton4;

    @FindBy(id = "uniform-cgv")
    private WebElement agreeButton;

    @FindBy(css = ".bankwire")
    private WebElement PayBankWire;

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrder;

    @FindBy(css = ".cheque-indent")
    private WebElement orderConfirm;

    @FindBy(css = "a[title='My orders']")
    private WebElement MyOrders;

    @FindBy(css = "tr[class='first_item ']")
    private WebElement firstOrder;

    @FindBy(xpath = "(//span[contains(text(),'Details')])[2]")
    private WebElement details;



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
            case "SpecialsButton":
                myElement = SpecialsButton;
                break;
            case "DressesButton":
                myElement = DressesButton;
                break;
            case "addToCart":
                myElement = addToCart;
                break;
            case "proceedButton":
                myElement = proceedButton;
                break;
            case "proceedButton2":
                myElement = proceedButton2;
                break;
            case "proceedButton3":
                myElement = proceedButton3;
                break;
            case "agreeButton":
                myElement = agreeButton;
                break;
            case "proceedButton4":
                myElement = proceedButton4;
                break;
            case "PayBankWire":
                myElement = PayBankWire;
                break;
            case "confirmOrder":
                myElement = confirmOrder;
                break;
            case "MyOrders":
                myElement = MyOrders;
                break;
            case "firstOrder":
                myElement = firstOrder;
                break;
            case "details":
                myElement = details;
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
            case "orderConfirm":
                myElement = orderConfirm;
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
            case "Discounts":
                myDropdownElement = Discounts;
                break;
        }

        for (int i = 0; i < myDropdownElement.size(); i++) {
            if (myDropdownElement.get(i).getText().contains(whichOption)) {
                myDropdownElement.get(i).click();
                break;
            }
        }
    }

    public void twoListIstEqual() {

        Assert.assertEquals(Discounts.size(), ItemList.size());

    }

    public void randomChooseAndClick() {

        int num = new Random().nextInt(dressList.size());
        clickFunction(dressList.get(num));
    }


    public void isTotalSame() {

        double actual = StringToDouble(TotalPrice.getText());
        double expected = StringToDouble(TotalProduct.getText()) + StringToDouble(TotalShipping.getText()) + StringToDouble(TotalTax.getText());
        Assert.assertEquals(actual, expected);
    }

}


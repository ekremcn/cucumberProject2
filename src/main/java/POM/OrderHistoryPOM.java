package POM;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class OrderHistoryPOM extends _01_ParentClass {

    public OrderHistoryPOM() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

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

    public void findElementAndVerifyElementContainText(String elementName, String WhichText) {

        switch (elementName) {

            case "orderConfirm":
                myElement = orderConfirm;
                break;

        }
        ElementContainsText(myElement, WhichText);
    }

    List<WebElement> myDropdownElement;

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


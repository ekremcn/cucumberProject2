package POM;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class SpecialsPOM extends _01_ParentClass {

    public SpecialsPOM() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    //SPECIALS ELEMENTS
    @FindBy(css = "a[title='Specials']")
    private WebElement SpecialsButton;

    @FindBy(xpath = "//div[@class='right-block']//span[@class='price-percent-reduction']")
    private List<WebElement> Discounts;

    @FindBy(css = "h5[itemprop='name']")
    private List<WebElement> ItemList;



    WebElement myElement;

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {

            case "SpecialsButton":
                myElement = SpecialsButton;
                break;
        }

        clickFunction(myElement);
    }


      public void twoListIstEqual() {

        Assert.assertEquals(Discounts.size(), ItemList.size());

    }



}


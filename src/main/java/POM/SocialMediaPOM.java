package POM;

import Utilities.Driver;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class SocialMediaPOM extends _01_ParentClass{

    public SocialMediaPOM() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "section>ul>li[class='facebook']")
    private WebElement facebookIcon;

    @FindBy(css = "section>ul>li[class='twitter']")
    private WebElement twitterIcon;

    @FindBy(css = "section>ul>li[class='youtube']")
    private WebElement youtubeIcon;

    @FindBy(css = "section>ul>li[class='google-plus']")
    private WebElement googlePlusIcon;

    WebElement myElement;

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {

            case "facebookIcon":
                myElement = facebookIcon;
                break;
            case "twitterIcon":
                myElement = twitterIcon;
                break;
            case "youtubeIcon":
                myElement = youtubeIcon;
                break;
            case "googlePlusIcon":
                myElement = googlePlusIcon;
                break;

        }

        clickFunction(myElement);
    }

    public void successfullyNavigateToFollowingPagesAndVerify(DataTable elements)  {

        List<List<String>> AllSocialMediaIcons= elements.asLists(String.class);

        for (int i = 0; i < AllSocialMediaIcons.size(); i++) {

            String mainWindow=driver.getWindowHandle();

            findElementAndClickFunction(AllSocialMediaIcons.get(i).get(0));

            Set<String> allWindows = driver.getWindowHandles();

            for (String allWindow : allWindows) {
                if (!allWindow.equals(mainWindow)){
                    driver.switchTo().window(allWindow);
                }
            }

            Assert.assertTrue(driver.getCurrentUrl().contains(AllSocialMediaIcons.get(i).get(1)));
            driver.switchTo().window(mainWindow);
        }

    }

}

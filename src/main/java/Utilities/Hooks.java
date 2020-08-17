package Utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    @Before
    public void before(){
//        Add the navigate to website enter username and password

    }


    @After
    public void after(Scenario scenario){

        System.out.println(scenario.getStatus() + " status of the scenario"); // scenario is passed or failed.
        System.out.println(scenario.getId() + " id of the scenario");
        System.out.println(scenario.getName() + " name of the scenario");

        if(scenario.getStatus().equalsIgnoreCase("failed")) {

            TakesScreenshot Screenshot = ((TakesScreenshot) Driver.getDriver()); // which driver to get a screen shot

            File srcFile = Screenshot.getScreenshotAs(OutputType.FILE);

            String featureFileName = scenario.getName();

            Date now = new Date();

            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH mm ss");

            String dateInString = formater.format(now);

            dateInString = dateInString.replace(":", " ");

            File destinationFile = new File("target/FailedScreenShots/" + featureFileName + dateInString + ".png");

            try {
                FileUtils.copyFile(srcFile, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Driver.QuitDriver();

        System.out.println("This is the after class");
    }
}
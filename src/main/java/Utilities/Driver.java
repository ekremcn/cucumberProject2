package Utilities;

import org.openqa.selenium.WebDriver;


public class Driver {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static ThreadLocal<String> browserName = new ThreadLocal<>();

    public static WebDriver getDriver(){

        if(threadDriver.get()==null){
            setWebDriver(DriverFactory.createInstance(browserName.get()));
        }
        return threadDriver.get();
    }

    public static void setWebDriver(WebDriver driver){

        threadDriver.set(driver);
    }


    public static void QuitDriver(){

        if(threadDriver.get()!=null){

            threadDriver.get().quit();
            WebDriver driver= threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }
}


package project.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import project.PageObjects.LoginPage;
import org.junit.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage pageTest;

    protected LoginPage loginPage;

    private void setEnvironment(){
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);
        driver = new FirefoxDriver(options);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Before
    public void prepareBase(){
        setEnvironment();
        loginPage = new LoginPage(driver);
    }

    @After
    public void cleanUpBase(){
        driver.close();
    }
}

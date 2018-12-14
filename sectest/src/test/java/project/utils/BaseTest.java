package project.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import project.PageObjects.LoginPage;
import org.junit.*;

public class BaseTest {
    protected String username;
    protected String password;

    protected WebDriver driver;
    protected LoginPage pageTest;

    protected utils Util= new utils();
    protected LoginPage loginPage;

    protected void setEnvironment(){
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver = new FirefoxDriver();
    }

    @Before
    public void prepareBase(){
        setEnvironment();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void BaseTest(){
    }

    @After
    public void cleanUpBase(){
        driver.close();
    }
}

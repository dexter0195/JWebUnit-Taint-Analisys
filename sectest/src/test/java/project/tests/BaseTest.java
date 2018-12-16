package project.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import project.utils.myUtils;

import static org.junit.Assert.fail;

public class BaseTest {

    protected WebDriver driver;
    protected static String baseUrl = "http://192.168.56.103/schoolmate/index.php";
    private StringBuffer verificationErrors = new StringBuffer();

    protected static myUtils utils;

    @Before
    public void setUp() throws Exception {
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);

        driver = new FirefoxDriver(options);

        utils = new myUtils(driver);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

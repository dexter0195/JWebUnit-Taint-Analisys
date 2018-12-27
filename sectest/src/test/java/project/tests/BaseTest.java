package project.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import project.utils.myUtils;

import static org.junit.Assert.fail;

public class BaseTest {

    protected WebDriver driver;
    private static String baseUrl = "http://192.168.56.103/schoolmate/index.php";
//    private static String baseUrl = "http://192.168.56.103/schoolmate-patched/index.php";
    private StringBuffer verificationErrors = new StringBuffer();

    protected static myUtils utils;


    protected void goToLoginPage(){
        driver.get(baseUrl);
        utils.SimpleSleep(1);
    }

    protected boolean isLoginPage(){
        return driver.findElements(
                By.xpath("//form[@name='login']//input[@type='submit'][@value='Login']")).size() > 0;
    }

    protected boolean isLoggedIn(){
        return driver.findElements(
                By.xpath("//a[contains(text(),'Log Out')]")).size() > 0;
    }

    public void login(String user, String pass){
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Before
    public void setUp() {
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);

        driver = new FirefoxDriver(options);

        utils = new myUtils(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}

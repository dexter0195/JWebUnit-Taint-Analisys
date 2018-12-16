package project.tests.Test186;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import project.tests.BaseTest;

public class Test186FromAdminMain7 extends BaseTest {


    @Test
    public void test186FromAdminMain7() throws Exception {
        driver.get(baseUrl);

        utils.login("schoolmate","schoolmate" );

        WebElement page2 = driver.findElement(
                By.xpath("//form[@name='admin']//input[@name='page2']"));

        utils.inject(page2, "'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"");

        utils.submitForm("admin");
        utils.SimpleSleep(1);

        assertFalse(utils.isLinkPresentWithText("Malicious Link"));

    }


}

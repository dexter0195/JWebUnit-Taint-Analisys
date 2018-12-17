package project.tests.TeachersPage.Roles.Admin.Test186;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import project.tests.BaseTest;
import project.tests.TeachersPage.Roles.Admin.TeacherAdminBaseTest;

public class Test186FromAdminMain7 extends TeacherAdminBaseTest {

    @Test
    public void test186FromAdminMain7() {

        //navigation
        goToLoginPage();
        assertTrue(isLoginPage());

        login(username, password);
        assertTrue(isLoggedIn());

        clickTeacherButton();
        assertTrue(isTeacherPage());

        //ATTACK

        WebElement page2 = driver.findElement(
                By.xpath("//form[@name='admin']//input[@name='page2']"));

        utils.inject(page2, "'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"");

        utils.submitForm("admin");
        utils.SimpleSleep(1);

        assertFalse(utils.isLinkPresentWithText("Malicious Link"));

    }


}

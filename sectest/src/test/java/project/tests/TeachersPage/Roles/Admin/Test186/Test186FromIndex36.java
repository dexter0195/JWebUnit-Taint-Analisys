package project.tests.TeachersPage.Roles.Admin.Test186;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.tests.BaseTest;
import project.tests.TeachersPage.Roles.Admin.TeacherAdminBaseTest;

import static org.junit.Assert.*;

public class Test186FromIndex36 extends TeacherAdminBaseTest {


    @Test
    public void test186FromAdminMain7() throws Exception {

        //navigation
        goToLoginPage();
        assertTrue(isLoginPage());
        login(username, password);
        assertTrue(isLoggedIn());

        //ATTACK
        WebElement page = driver.findElement(
                By.xpath("//form[@name='admin']//input[@name='page']"));

        String currentPageValue = page.getAttribute("value");

        utils.inject(page, currentPageValue+"'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"");

        utils.submitForm("admin");
        utils.SimpleSleep(1);

        assertFalse(utils.isLinkPresentWithText("Malicious Link"));

    }


}

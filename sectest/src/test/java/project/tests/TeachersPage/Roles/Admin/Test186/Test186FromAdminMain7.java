package project.tests.TeachersPage.Roles.Admin.Test186;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.TeachersPage.Roles.Admin.TeacherAdminBaseTest;

public class Test186FromAdminMain7 extends TeacherAdminBaseTest {


    @Test
    public void test() {

        String taintedVar = "page2";
        String formName = "admin";

        //navigation
        goToLoginPage();
        assertTrue(isLoginPage());
        login(username, password);
        assertTrue(isLoggedIn());
        clickTeacherButton();
        assertTrue(isTeacherPage());

        //ATTACK

        utils.inject(taintedVar,formName);

        assertFalse(utils.isMaliciousLinkPresentInForm(formName));

    }


}

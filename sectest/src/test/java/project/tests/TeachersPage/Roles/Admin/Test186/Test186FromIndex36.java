package project.tests.TeachersPage.Roles.Admin.Test186;

import org.junit.Test;
import project.tests.TeachersPage.Roles.Admin.TeacherAdminBaseTest;

import static org.junit.Assert.*;

public class Test186FromIndex36 extends TeacherAdminBaseTest {


    @Test
    public void test() {

        String taintedVar = "page";
        String formName = "admin";

        //navigation
        goToLoginPage();
        assertTrue(isLoginPage());
        login(username, password);
        assertTrue(isLoggedIn());

        //ATTACK
        utils.inject(taintedVar, formName);

        assertFalse(utils.isMaliciousLinkPresentInForm(formName));

    }


}

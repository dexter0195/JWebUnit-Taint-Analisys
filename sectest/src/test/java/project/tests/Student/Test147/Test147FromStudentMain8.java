
package project.tests.Student.Test147;

import org.junit.*;
import project.tests.Student.StudentBaseTest;

import static org.junit.Assert.*;

public class Test147FromStudentMain8 extends StudentBaseTest {


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "announcements";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","4");
        utils.addFieldToMyFormWithValue("page2","4");
        utils.addFieldToMyFormWithValue("onpage","1");
        utils.addFieldToMyFormWithValue("selectclass","7");

        //ATTACK
        utils.injectVarMyForm(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(viewAnnouncementsTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
    }
}
        
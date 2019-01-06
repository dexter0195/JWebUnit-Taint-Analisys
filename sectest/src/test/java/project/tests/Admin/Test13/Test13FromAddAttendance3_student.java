
package project.tests.Admin.Test13;

import org.junit.Test;
import project.tests.Admin.AdminBaseTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test13FromAddAttendance3_student extends AdminBaseTest {


    @Test
    public void test() {

        String taintedVar = "semester";
        String targetForm = "addattendance";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","31");
        utils.addFieldToMyFormWithValue("student","3");
        utils.addFieldToMyFormWithValue("semester","2");

        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(addAttendanceTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        
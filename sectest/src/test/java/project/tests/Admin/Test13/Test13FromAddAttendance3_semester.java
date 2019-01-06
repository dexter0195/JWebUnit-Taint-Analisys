
package project.tests.Admin.Test13;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test13FromAddAttendance3_semester extends AdminBaseTest {


    @Test
    public void test() {

        String taintedVar = "student";
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
            
        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(addAttendanceTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        
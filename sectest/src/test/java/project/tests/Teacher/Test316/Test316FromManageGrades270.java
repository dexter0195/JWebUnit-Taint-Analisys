
package project.tests.Teacher.Test316;

import org.junit.*;
import static org.junit.Assert.*;

import project.tests.Teacher.TeacherBaseTest;
        
public class Test316FromManageGrades270 extends TeacherBaseTest {

    @Test
    public void test() {

        String taintedVar = "selectclass";
        String targetForm = "grades";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","3");
        utils.addFieldToMyFormWithValue("selectclass","8");

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar, "\' -- ><a href=\'www.unitn.it\'>Malicious Link</a> <br\'");

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(gradesTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));


    }
}
        
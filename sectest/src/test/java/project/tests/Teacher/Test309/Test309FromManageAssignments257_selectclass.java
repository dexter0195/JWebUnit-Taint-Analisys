
package project.tests.Teacher.Test309;

import org.junit.Test;
import project.tests.Teacher.TeacherBaseTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test309FromManageAssignments257_selectclass extends TeacherBaseTest {

    @Test
    public void test() {

        String taintedVar = "selectclass";
        String targetForm = "assignments";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","2");
        utils.addFieldToMyFormWithValue("selectclass","7");
        utils.addFieldToMyFormWithValue("onpage","1");

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar, "\' -- ><a href=\'www.unitn.it\'>Malicious Link</a> <br\'");

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageAssignmentTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

    }
}
        
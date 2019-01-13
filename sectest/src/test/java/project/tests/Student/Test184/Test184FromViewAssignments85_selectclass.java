
package project.tests.Student.Test184;

import org.junit.*;
import static org.junit.Assert.*;

import project.tests.Student.StudentBaseTest;
        
public class Test184FromViewAssignments85_selectclass extends StudentBaseTest {


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
        utils.addFieldToMyFormWithValue("page","4");
        utils.addFieldToMyFormWithValue("page2","2");
        utils.addFieldToMyFormWithValue("selectclass","7");

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar, "\' -- ><a href=\'www.unitn.it\'>Malicious Link</a> <br\'");

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(ViewAssignmentTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

        // this fails for inconsistency in subsequent queries

    }
}
        
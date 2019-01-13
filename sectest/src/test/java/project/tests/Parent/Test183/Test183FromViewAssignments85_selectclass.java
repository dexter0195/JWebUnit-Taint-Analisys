
package project.tests.Parent.Test183;

import org.junit.*;
import static org.junit.Assert.*;

import project.tests.Parent.ParentBaseTest;

public class Test183FromViewAssignments85_selectclass extends ParentBaseTest {


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
        utils.addFieldToMyFormWithValue("page","5");
        utils.addFieldToMyFormWithValue("page2","2");
        utils.addFieldToMyFormWithValue("selectclass","7");
        utils.addFieldToMyFormWithValue("student","3");

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar, "\' -- ><a href=\'www.unitn.it\'>Malicious Link</a> <br\'");

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(ViewAssignmentTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

    }
}
        
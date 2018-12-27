
package project.tests.Parent.Test200;

import org.junit.*;
import project.tests.Parent.ParentBaseTest;

import static org.junit.Assert.*;

public class Test200FromViewGrades102 extends ParentBaseTest {


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
        utils.addFieldToMyFormWithValue("page","5");
        utils.addFieldToMyFormWithValue("page2","3");
        utils.addFieldToMyFormWithValue("student","3");
        utils.addFieldToMyFormWithValue("selectclass","7");

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(ViewGradesTitle));
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        

package project.tests.Student.Test184;

import org.junit.Test;
import project.tests.Student.StudentBaseTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test184FromViewAssignments85_onpage extends StudentBaseTest {


    @Test
    public void test() {

        String taintedVar = "onpage";
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
        utils.addFieldToMyFormWithValue("onpage","7");

        //ATTACK
        utils.injectVarMyForm(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(ViewAssignmentTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));


    }
}
        
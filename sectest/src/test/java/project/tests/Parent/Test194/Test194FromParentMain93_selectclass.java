
package project.tests.Parent.Test194;

import org.junit.Test;
import project.tests.Parent.ParentBaseTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test194FromParentMain93_selectclass extends ParentBaseTest {


    @Test
    public void test() {

        String taintedVar = "student";
        String targetForm = "student";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());

        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","5");
        utils.addFieldToMyFormWithValue("page2","0");
        utils.addFieldToMyFormWithValue("student","3");
        utils.addFieldToMyFormWithValue("selectclass","7");
        
        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

    }
}
        
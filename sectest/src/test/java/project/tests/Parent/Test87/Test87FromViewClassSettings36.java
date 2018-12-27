
package project.tests.Parent.Test87;

import org.junit.*;
import static org.junit.Assert.*;

import project.tests.Parent.ParentBaseTest;

public class Test87FromViewClassSettings36 extends ParentBaseTest {


    @Test
    public void test() {

        String taintedVar = "selectclass";
        String targetForm = "classes";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","5");
        utils.addFieldToMyFormWithValue("page2","1");
        utils.addFieldToMyFormWithValue("selectclass","7");
            
        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(classSettingsTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        
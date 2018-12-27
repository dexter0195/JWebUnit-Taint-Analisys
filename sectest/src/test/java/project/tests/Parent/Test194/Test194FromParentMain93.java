
package project.tests.Parent.Test194;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Parent.ParentBaseTest;
        
public class Test194FromParentMain93 extends ParentBaseTest { 


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

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        
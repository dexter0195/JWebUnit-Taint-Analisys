
package project.tests.Admin.Test44;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test44Fromindex36 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page";
        String targetForm = "editterm";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","12");
        utils.addFieldToMyFormWithValue("delete[]","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(editTermTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        
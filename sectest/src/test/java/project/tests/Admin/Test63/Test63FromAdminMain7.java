
package project.tests.Admin.Test63;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test63FromAdminMain7 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "addteacher";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","16");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Add New Teacher
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

        // TODO: segnalibro
    }
}
        
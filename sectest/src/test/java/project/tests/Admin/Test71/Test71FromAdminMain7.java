
package project.tests.Admin.Test71;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test71FromAdminMain7 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "addsemester";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","7");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(addSemesterTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        

package project.tests.Admin.Test161;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test161FromAdminMain7 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "editparent";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","24");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("studentid","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Edit Parent
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: delete

// TODO: check added field: studentid

    }
}
        

package project.tests.Admin.Test260;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test260FromAdminMain7 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "terms";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","6");
        //utils.addFieldToMyFormWithValue("enddate","1");
        //utils.addFieldToMyFormWithValue("startdate","1");
        //utils.addFieldToMyFormWithValue("termid","1");
        //utils.addFieldToMyFormWithValue("deleteterm","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("onpage","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Terms
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: enddate

// TODO: check added field: startdate

// TODO: check added field: termid

// TODO: check added field: deleteterm

// TODO: check added field: delete

// TODO: check added field: onpage

    }
}
        

package project.tests.Admin.Test320;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test320FromAdminMain7 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "classes";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","0");
        //utils.addFieldToMyFormWithValue("periodnum","1");
        //utils.addFieldToMyFormWithValue("fullyear","1");
        //utils.addFieldToMyFormWithValue("Days","1");
        //utils.addFieldToMyFormWithValue("semester","1");
        //utils.addFieldToMyFormWithValue("substitute","1");
        //utils.addFieldToMyFormWithValue("semester2","1");
        //utils.addFieldToMyFormWithValue("courseid","1");
        //utils.addFieldToMyFormWithValue("deleteclass","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("onpage","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Classes
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: periodnum

// TODO: check added field: fullyear

// TODO: check added field: Days

// TODO: check added field: semester

// TODO: check added field: substitute

// TODO: check added field: semester2

// TODO: check added field: courseid

// TODO: check added field: deleteclass

// TODO: check added field: delete

// TODO: check added field: onpage

    }
}
        
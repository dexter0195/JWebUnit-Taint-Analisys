
package project.tests.Admin.Test257;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test257FromAdminMain7 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "announcements";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","4");
        //utils.addFieldToMyFormWithValue("message","1");
        //utils.addFieldToMyFormWithValue("date","1");
        //utils.addFieldToMyFormWithValue("announcementid","1");
        //utils.addFieldToMyFormWithValue("deleteannouncement","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("onpage","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Announcements
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: message

// TODO: check added field: date

// TODO: check added field: announcementid

// TODO: check added field: deleteannouncement

// TODO: check added field: delete

// TODO: check added field: onpage

    }
}
        
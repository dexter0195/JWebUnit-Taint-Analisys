
package project.tests.Parent.Test146;

import org.junit.*;
import project.tests.Parent.ParentBaseTest;

import static org.junit.Assert.*;

public class Test146Fromindex36 extends ParentBaseTest {


    @Test
    public void test() {

        String taintedVar = "page";
        String targetForm = "announcements";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","5");
        utils.addFieldToMyFormWithValue("page2","4");
        utils.addFieldToMyFormWithValue("onpage","1");

        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(viewAnnouncementsTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }
}
        
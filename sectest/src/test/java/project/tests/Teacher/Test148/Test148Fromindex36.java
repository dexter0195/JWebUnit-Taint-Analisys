
package project.tests.Teacher.Test148;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test148Fromindex36 extends TeacherBaseTest { 


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
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","9");
        //utils.addFieldToMyFormWithValue("onpage","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: View Announcements
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: onpage

    }
}
        
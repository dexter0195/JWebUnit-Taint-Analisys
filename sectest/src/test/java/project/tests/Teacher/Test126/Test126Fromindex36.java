
package project.tests.Teacher.Test126;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test126Fromindex36 extends TeacherBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page";
        String targetForm = "classes";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","0");
        //utils.addFieldToMyFormWithValue("semester","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: $teacherid[1] $teacherid[2]'s Classes
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: semester

    }
}
        
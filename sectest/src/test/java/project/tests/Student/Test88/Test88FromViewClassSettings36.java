
package project.tests.Student.Test88;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Student.StudentBaseTest;
        
public class Test88FromViewClassSettings36 extends StudentBaseTest { 


    @Test
    public void test() {

        String taintedVar = "selectclass";
        String targetForm = "classes";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","4");
        utils.addFieldToMyFormWithValue("page2","1");
        //utils.addFieldToMyFormWithValue("update","1");
        utils.addFieldToMyFormWithValue("selectclass","7");
            
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Class Settings
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: update

// TODO: check added field: selectclass

    }
}
        
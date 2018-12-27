
package project.tests.Student.Test165;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Student.StudentBaseTest;
        
public class Test165Fromindex36 extends StudentBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page";
        String targetForm = "student";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","4");
        utils.addFieldToMyFormWithValue("page2","0");
        utils.addFieldToMyFormWithValue("selectclass","7");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(classMainTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

    }
}
        
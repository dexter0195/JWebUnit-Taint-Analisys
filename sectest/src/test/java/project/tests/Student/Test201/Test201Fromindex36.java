
package project.tests.Student.Test201;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Student.StudentBaseTest;
        
public class Test201Fromindex36 extends StudentBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page";
        String targetForm = "grades";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","4");
        utils.addFieldToMyFormWithValue("page2","3");
        utils.addFieldToMyFormWithValue("student","3");
        utils.addFieldToMyFormWithValue("selectclass","7");

        //ATTACK
        utils.injectVarMyForm(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(ViewGradesTitle));
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

    }
}
        
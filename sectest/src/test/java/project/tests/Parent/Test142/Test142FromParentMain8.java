
package project.tests.Parent.Test142;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Parent.ParentBaseTest;
        
public class Test142FromParentMain8 extends ParentBaseTest { 


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
        utils.addFieldToMyFormWithValue("page","5");
        utils.addFieldToMyFormWithValue("page2","5");
        utils.addFieldToMyFormWithValue("student","3");
        //utils.addFieldToMyFormWithValue("semester","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(classesTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInPath("//td[@class='w']//td"));

    }
}
        
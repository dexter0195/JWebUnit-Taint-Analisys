
package project.tests.Admin.Test111;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test111FromEditTeacher2 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "delete[]";
        String targetForm = "editteacher";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","17");
        utils.addFieldToMyFormWithValue("delete[]","3");
            
        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(editTeacherTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));


    }
}
        
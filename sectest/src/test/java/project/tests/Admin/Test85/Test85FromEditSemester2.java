
package project.tests.Admin.Test85;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test85FromEditSemester2 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "delete[]";
        String targetForm = "editsemester";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());

        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","13");
        utils.addFieldToMyFormWithValue("delete[]","1");

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(editSemesterTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));



    }
}
        
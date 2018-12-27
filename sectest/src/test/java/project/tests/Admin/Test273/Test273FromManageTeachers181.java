
package project.tests.Admin.Test273;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test273FromManageTeachers181 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "onpage";
        String targetForm = "";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","3");
        //utils.addFieldToMyFormWithValue("addteacher","1");
        //utils.addFieldToMyFormWithValue("lname","1");
        //utils.addFieldToMyFormWithValue("username","1");
        //utils.addFieldToMyFormWithValue("teacherid","1");
        //utils.addFieldToMyFormWithValue("deleteteacher","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        utils.addFieldToMyFormWithValue("onpage","1");
                
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Teachers
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: addteacher

// TODO: check added field: lname

// TODO: check added field: username

// TODO: check added field: teacherid

// TODO: check added field: deleteteacher

// TODO: check added field: delete

// TODO: check added field: onpage
// TODO: check field missing:targetForm
        
    }
}
        
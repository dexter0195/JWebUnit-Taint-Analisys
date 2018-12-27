
package project.tests.Admin.Test283;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test283FromAdminMain7 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","10");
        //utils.addFieldToMyFormWithValue("type","1");
        //utils.addFieldToMyFormWithValue("username","1");
        //utils.addFieldToMyFormWithValue("password","1");
        //utils.addFieldToMyFormWithValue("userid","1");
        //utils.addFieldToMyFormWithValue("deleteuser","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("onpage","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Users
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: type

// TODO: check added field: username

// TODO: check added field: password

// TODO: check added field: userid

// TODO: check added field: deleteuser

// TODO: check added field: delete

// TODO: check added field: onpage
// TODO: check field missing:targetForm
        
    }
}
        

package project.tests.Admin.Test288;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test288Fromindex36 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page";
        String targetForm = "";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","22");
        //utils.addFieldToMyFormWithValue("addparent","1");
        //utils.addFieldToMyFormWithValue("student","1");
        //utils.addFieldToMyFormWithValue("username","1");
        //utils.addFieldToMyFormWithValue("lname","1");
        //utils.addFieldToMyFormWithValue("parentid","1");
        //utils.addFieldToMyFormWithValue("deleteparent","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("onpage","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Parents
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: addparent

// TODO: check added field: student

// TODO: check added field: username

// TODO: check added field: lname

// TODO: check added field: parentid

// TODO: check added field: deleteparent

// TODO: check added field: delete

// TODO: check added field: onpage
// TODO: check field missing:targetForm
        
    }
}
        
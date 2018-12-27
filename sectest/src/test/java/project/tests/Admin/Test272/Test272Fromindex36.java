
package project.tests.Admin.Test272;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test272Fromindex36 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page";
        String targetForm = "registration";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","30");
        //utils.addFieldToMyFormWithValue("addattendance","1");
        //utils.addFieldToMyFormWithValue("semester","1");
        //utils.addFieldToMyFormWithValue("type","1");
        //utils.addFieldToMyFormWithValue("deletereg","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("student","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Attendance
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: addattendance

// TODO: check added field: semester

// TODO: check added field: type

// TODO: check added field: deletereg

// TODO: check added field: delete

// TODO: check added field: student

    }
}
        
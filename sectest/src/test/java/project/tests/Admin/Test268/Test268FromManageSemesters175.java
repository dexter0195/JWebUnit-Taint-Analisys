
package project.tests.Admin.Test268;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Admin.AdminBaseTest;
        
public class Test268FromManageSemesters175 extends AdminBaseTest { 


    @Test
    public void test() {

        String taintedVar = "onpage";
        String targetForm = "semesters";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","5");
        //utils.addFieldToMyFormWithValue("enddate","1");
        //utils.addFieldToMyFormWithValue("startdate","1");
        //utils.addFieldToMyFormWithValue("middate","1");
        //utils.addFieldToMyFormWithValue("half","1");
        //utils.addFieldToMyFormWithValue("semesterid","1");
        //utils.addFieldToMyFormWithValue("deletesemester","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        utils.addFieldToMyFormWithValue("onpage","1");
                
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Semesters
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: enddate

// TODO: check added field: startdate

// TODO: check added field: middate

// TODO: check added field: half

// TODO: check added field: semesterid

// TODO: check added field: deletesemester

// TODO: check added field: delete

// TODO: check added field: onpage

    }
}
        
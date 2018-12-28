
package project.tests.Teacher.Test181;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test181FromViewStudents83 extends TeacherBaseTest { 


    @Test
    public void test() {

        String taintedVar = "selectclass";
        String targetForm = "classes";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","8");
        utils.addFieldToMyFormWithValue("selectclass","7");
            
        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(studentsTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

    }
}
        
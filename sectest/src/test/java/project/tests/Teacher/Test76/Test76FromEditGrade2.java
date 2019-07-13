
package project.tests.Teacher.Test76;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test76FromEditGrade2 extends TeacherBaseTest { 


    @Test
    public void test() {

        String taintedVar = "delete[]";
        String targetForm = "editgrade";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","7");
        utils.addFieldToMyFormWithValue("delete[]","4");
        utils.addFieldToMyFormWithValue("assignment","2");
        utils.addFieldToMyFormWithValue("selectclass","8");

        //ATTACK
        utils.injectVarMyFormForSQL(taintedVar, "'; -- ><a href=\'www.unitn.it\'>Malicious Link</a> <br'");

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(editGradeTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

    }
}
        
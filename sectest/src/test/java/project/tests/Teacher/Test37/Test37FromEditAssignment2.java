
package project.tests.Teacher.Test37;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test37FromEditAssignment2 extends TeacherBaseTest { 


    @Test
    public void test() {

        String taintedVar = "delete";
        String targetForm = "editassignment";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","5");
        utils.addFieldToMyFormWithValue("delete","1");
        utils.addFieldToMyFormWithValue("selectclass","8");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(editAssignmentTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

        //TODO: spiegare che e` un falso positivo: questa e` una falsa vulneravilita` perche viene usato un solo carattere della variabile delete

    }
}
        
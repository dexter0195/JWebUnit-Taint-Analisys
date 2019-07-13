
package project.tests.Student.Test138;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Student.StudentBaseTest;
        
public class Test138FromStudentMain8 extends StudentBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "classes";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","4");
        utils.addFieldToMyFormWithValue("page2","0");
        //utils.addFieldToMyFormWithValue("semester","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(classMainTitle));

        //found possible title for page: $studentid[1] $studentid[2]'s Classes


        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInPath("//td[@class='w']//td"));

        //non e` possibile controllare la presenza del link nel form, ovvero perche` l'html del sito
        // e` malformato

    }
}
        
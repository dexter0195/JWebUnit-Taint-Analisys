
package project.tests.Teacher.Test316;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test316FromManageGrades270 extends TeacherBaseTest { 


    @Test
    public void test() {

        String taintedVar = "selectclass";
        String targetForm = "grades";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","3");
        //utils.addFieldToMyFormWithValue("editgrade","1");
        //utils.addFieldToMyFormWithValue("gradeid","1");
        utils.addFieldToMyFormWithValue("selectclass","7");
            //utils.addFieldToMyFormWithValue("late","1");
        //utils.addFieldToMyFormWithValue("gradedate","1");
        //utils.addFieldToMyFormWithValue("wasdate","1");
        //utils.addFieldToMyFormWithValue("student","1");
        //utils.addFieldToMyFormWithValue("deletegrade","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("assignment","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Grades
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: editgrade

// TODO: check added field: gradeid

// TODO: check added field: selectclass

// TODO: check added field: late

// TODO: check added field: gradedate

// TODO: check added field: wasdate

// TODO: check added field: student

// TODO: check added field: deletegrade

// TODO: check added field: delete

// TODO: check added field: assignment

    }
}
        

package project.tests.Teacher.Test309;

import org.junit.*;
import static org.junit.Assert.*;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test309FromTeacherMain8 extends TeacherBaseTest { 


    @Test
    public void test() {

        String taintedVar = "page2";
        String targetForm = "assignments";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());
        
        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","2");
        utils.addFieldToMyFormWithValue("page2","2");
        //utils.addFieldToMyFormWithValue("selectclass","1");
        //utils.addFieldToMyFormWithValue("addassignment","1");
        //utils.addFieldToMyFormWithValue("duedate","1");
        //utils.addFieldToMyFormWithValue("assigneddate","1");
        //utils.addFieldToMyFormWithValue("task","1");
        //utils.addFieldToMyFormWithValue("editassignment","1");
        //utils.addFieldToMyFormWithValue("assignmentid","1");
        //utils.addFieldToMyFormWithValue("wasdate","1");
        //utils.addFieldToMyFormWithValue("deleteassignment","1");
        //utils.addFieldToMyFormWithValue("delete","1");
        //utils.addFieldToMyFormWithValue("onpage","1");
        
        //ATTACK
        utils.injectVarMyForm(taintedVar);
        
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(MainTitle));
        
        //found possible title for page: Manage Assignments
        
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
// TODO: check added field: selectclass

// TODO: check added field: addassignment

// TODO: check added field: duedate

// TODO: check added field: assigneddate

// TODO: check added field: task

// TODO: check added field: editassignment

// TODO: check added field: assignmentid

// TODO: check added field: wasdate

// TODO: check added field: deleteassignment

// TODO: check added field: delete

// TODO: check added field: onpage

    }
}
        

package project.tests.Teacher.Test316;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import project.tests.Teacher.TeacherBaseTest;
        
public class Test316FromManageGrades270 extends TeacherBaseTest {

    public void injectVarMyFormForSQL(String variable) {

        String formName = "myform";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement target = utils.getVarElement(formName, variable);
        String currentPageValue = target.getAttribute("value");
        String injection = currentPageValue+"'; -- ><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"";
        String script = "arguments[0].setAttribute(\"value\",\""+injection+")";
        js.executeScript(script, target);

        utils.submitForm(formName);
        utils.SimpleSleep(1);
    }

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
        utils.addFieldToMyFormWithValue("selectclass","8");

        //ATTACK
        injectVarMyFormForSQL(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(gradesTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));


    }
}
        
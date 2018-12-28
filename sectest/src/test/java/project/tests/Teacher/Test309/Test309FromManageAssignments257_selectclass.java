
package project.tests.Teacher.Test309;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import project.tests.Teacher.TeacherBaseTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test309FromManageAssignments257_selectclass extends TeacherBaseTest {

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
        utils.addFieldToMyFormWithValue("selectclass","7");
        utils.addFieldToMyFormWithValue("onpage","1");

        //ATTACK
        injectVarMyFormForSQL(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageAssignmentTitle));

        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));

        //TODO : spiegare che = pagina rotta per incongruenza nelle query sql, una con il single quote e una senza

    }
}
        
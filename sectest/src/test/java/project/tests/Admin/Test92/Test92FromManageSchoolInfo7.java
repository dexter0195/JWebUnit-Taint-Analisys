
package project.tests.Admin.Test92;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import project.tests.Admin.AdminBaseTest;

import static org.junit.Assert.*;

public class Test92FromManageSchoolInfo7 extends AdminBaseTest {

    private String oldValue = "";
    private WebElement inputField;

    public void injectVarMyForm(String variable){

        String formName = "myform";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement target = utils.getVarElement(formName, variable);
        String currentPageValue = target.getAttribute("value");
        String injection = StringEscapeUtils.escapeJavaScript(currentPageValue) +
                "\\\\\'><a href=\\\"www.unitn.it\\\">Malicious Link</a> <br\\\\\'";
        String script = "arguments[0].setAttribute(\"value\",\""+injection+"\")";
        js.executeScript(script, target);

        utils.submitForm(formName);
        utils.SimpleSleep(1);

    }

    private void restoreField(String path, String oldValue){

        WebElement inputField = driver.findElement(By.xpath(path));
        inputField.clear();
        inputField.sendKeys(oldValue);
        driver.findElement(By.xpath("//input[contains(@value,'Update')]")).click();

        //for unknown reason the first time it doesn't work
        inputField = driver.findElement(By.xpath(path));
        inputField.clear();
        inputField.sendKeys(oldValue);
        driver.findElement(By.xpath("//input[contains(@value,'Update')]")).click();
    }


    @Test
    public void test() {

        String attackString = "\\\'><a href=\\\"www.unitn.it\\\"> Malicious Link </a> <br \\\'";

        String taintedVar = "schooladdress";
        String targetForm = "info";

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());

        //navigate
        driver.findElement(By.xpath("//a[@class='menu'][contains(text(),'School')]")).click();
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageSchoolTitle));

        //build the custom form
        utils.createMyFormForManageSchoolInfo();

        //save the current value
        inputField = driver.findElement(By.xpath("//input[@name='"+taintedVar+"']"));
        oldValue = inputField.getAttribute("value");

        //attack

        injectVarMyForm(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageSchoolTitle));
        
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInForm(targetForm));
        
    }

    @After
    public void cleanup(){

        String taintedVar = "schooladdress";
        String targetForm = "info";

        String path = "/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]";

        //restore the value
        restoreField(path, oldValue);

        inputField = driver.findElement(By.xpath(path));
        assertEquals(oldValue, inputField.getAttribute("value"));


    }
}
        
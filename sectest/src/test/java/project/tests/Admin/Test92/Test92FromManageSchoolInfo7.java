
package project.tests.Admin.Test92;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","1");
        utils.addFieldToMyFormWithValue("schoolname",
                driver.findElement(By.xpath("//input[@name='schoolname']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("schooladdress",
                driver.findElement(By.xpath("//input[@name='schooladdress']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("schoolphone",
                driver.findElement(By.xpath("//input[@name='schoolphone']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("numsemesters",
                driver.findElement(By.xpath("//input[@name='numsemesters']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("numperiods",
                driver.findElement(By.xpath("//input[@name='numperiods']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("apoint",
                driver.findElement(By.xpath("//input[@name='apoint']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("bpoint",
                driver.findElement(By.xpath("//input[@name='bpoint']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("cpoint",
                driver.findElement(By.xpath("//input[@name='cpoint']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("dpoint",
                driver.findElement(By.xpath("//input[@name='dpoint']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("fpoint",
                driver.findElement(By.xpath("//input[@name='fpoint']")).getAttribute("value"));
        utils.addFieldToMyFormWithValue("sitetext",
                driver.findElement(By.xpath("//textarea[@name='sitetext']")).getAttribute("value"), "textarea");
        utils.addFieldToMyFormWithValue("sitemessage",
                driver.findElement(By.xpath("//textarea[@name='sitemessage']")).getAttribute("value"), "textarea");
        utils.addFieldToMyFormWithValue("infoupdate","1");

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

        //restore the value
        inputField = driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]"));
        inputField.clear();
        inputField.sendKeys(oldValue);
        driver.findElement(By.xpath("//input[contains(@value,'Update')]")).click();

        //for unknown reason the first time it doesn't work
        inputField = driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]"));
        inputField.clear();
        inputField.sendKeys(oldValue);
        driver.findElement(By.xpath("//input[contains(@value,'Update')]")).click();

        inputField = driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]"));
        assertEquals(oldValue, inputField.getAttribute("value"));


    }
}
        
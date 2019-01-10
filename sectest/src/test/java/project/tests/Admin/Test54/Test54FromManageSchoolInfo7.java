
package project.tests.Admin.Test54;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.tests.Admin.AdminBaseTest;

import static org.junit.Assert.*;

public class Test54FromManageSchoolInfo7 extends AdminBaseTest {

    private String oldValue = "";
    private String taintedVar = "sitetext";
    private WebElement inputField;

    public void injectVarMyForm(String variable){

        String formName = "myform";

        WebElement target = driver.findElement(By.xpath("//form[@id='myform']//textarea[@name='"+variable+"']"));
        String injection = "\\'><a href=\\\"www.unitn.it\\\">Malicious Link</a> <br\\'";
        target.clear();
        target.sendKeys(injection);

        utils.submitForm(formName);
        utils.SimpleSleep(1);

    }

    private void restoreField(String variable, String oldValue){

        String formName = "myform";

        WebElement target = driver.findElement(By.xpath("//form[@id='myform']//textarea[@name='"+variable+"']"));
        target.clear();
        target.sendKeys(oldValue);

        utils.submitForm(formName);
        utils.SimpleSleep(1);
    }


    @Test
    public void test() {


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
        inputField = driver.findElement(By.xpath("//textarea[@name='sitetext']"));
        oldValue = inputField.getText();

        //attack

        injectVarMyForm(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageSchoolTitle));

        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        assertFalse("ERROR: Malicious link found",utils.isMaliciousLinkPresentInPath("//body"));
        
    }

    @After
    public void cleanup(){

        String path = "/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]";

        //restore the value
        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());

        //navigate
        driver.findElement(By.xpath("//a[@class='menu'][contains(text(),'School')]")).click();
        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageSchoolTitle));

        utils.createMyFormForManageSchoolInfo();
        restoreField(taintedVar, oldValue);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageSchoolTitle));

    }
}
        
package project.tests.Admin.Test234;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import project.tests.Admin.AdminBaseTest;

import static org.junit.Assert.*;

public class Test234FromManageTerms8 extends AdminBaseTest {

    private String oldValue;

    public void injectVarMyForm(String variable){

        String formName = "myform";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement target = utils.getVarElement(formName, variable);
        String injection = "<base href=//0>";
        String script = "arguments[0].setAttribute(\"value\",\""+injection+"\")";
        js.executeScript(script, target);

        utils.submitForm(formName);
        utils.SimpleSleep(1);

    }

    @Test
    public void test() {

        String taintedVar = "title";

        //part one: login as admin and create the course with tainted value

        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());

        driver.findElement(By.xpath("//a[contains(text(),'Terms')]")).click();
        oldValue = driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();

        //create the custom form with navigation to edit the term title
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","6");
        utils.addFieldToMyFormWithValue("title","");
        utils.addFieldToMyFormWithValue("editterm","1");
        utils.addFieldToMyFormWithValue("startdate","09/01/2018");
        utils.addFieldToMyFormWithValue("enddate","12/22/2018");
        utils.addFieldToMyFormWithValue("termid","3");

        injectVarMyForm(taintedVar);

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageTermsTitle));

        // part two navigate to the target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","5");
        utils.submitForm("myform");

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(manageSemestersTitle));

        assertFalse("ERROR: Malicious base address found",driver.findElements(By.xpath("//base[@href='//0']")).size() > 0);

    }

    @After
    public void cleanup(){


        //restore the previous title
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","6");
        utils.addFieldToMyFormWithValue("title",oldValue);
        utils.addFieldToMyFormWithValue("editterm","1");
        utils.addFieldToMyFormWithValue("startdate","09/01/2018");
        utils.addFieldToMyFormWithValue("enddate","12/22/2018");
        utils.addFieldToMyFormWithValue("termid","3");

        utils.submitForm("myform");

    }

}

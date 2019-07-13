package project.tests.Student.Test31;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import project.tests.Student.StudentBaseTest;

import static org.junit.Assert.*;

public class Test31FromViewAssignments7 extends StudentBaseTest {

    private String oldValue;

    public void injectVarMyForm(String variable){

        String formName = "myform";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement target = utils.getVarElement(formName, variable);
        String currentPageValue = target.getAttribute("value");
        String injection = "<img src=\\\"t.o\\\">";
        String script = "arguments[0].setAttribute(\"value\",\""+injection+"\")";
        js.executeScript(script, target);

        utils.submitForm(formName);
        utils.SimpleSleep(1);

    }

    @Test
    public void test() {

        String taintedVar = "title";
        String targetForm = "classes";

        //part one: login as admin and create the course with tainted value

        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login("schoolmate","schoolmate");
        assertTrue("ERROR: cannot login", isLoggedIn());

        oldValue = driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();

        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","0");
        utils.addFieldToMyFormWithValue("title","");
        utils.addFieldToMyFormWithValue("teacher","3");
        utils.addFieldToMyFormWithValue("semester","2");
        utils.addFieldToMyFormWithValue("sectionnum","1");
        utils.addFieldToMyFormWithValue("roomnum","1");
        utils.addFieldToMyFormWithValue("periodnum","1");
        utils.addFieldToMyFormWithValue("editclass","1");
        utils.addFieldToMyFormWithValue("courseid","7");

        injectVarMyForm(taintedVar);

        //part two login as parent and see if the image is present

        //login
        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login(getUsername(),getPassword());
        assertTrue("ERROR: cannot login", isLoggedIn());

        assertTrue("ERROR: Title doesn't match",utils.isTitleEqualsTo(classMainTitle));

        assertFalse("ERROR: Malicious image found",driver.findElements(By.xpath("//img[@src='t.o']")).size() > 0);

    }

    @After
    public void cleanup(){

        String currValue;

        goToLoginPage();
        assertTrue("ERROR: cannot go to log in page", isLoginPage());
        login("schoolmate","schoolmate");
        assertTrue("ERROR: cannot login", isLoggedIn());

        //create the custom form with navigation to target page
        utils.createMyForm();
        utils.addFieldToMyFormWithValue("page","1");
        utils.addFieldToMyFormWithValue("page2","0");
        utils.addFieldToMyFormWithValue("title",oldValue);
        utils.addFieldToMyFormWithValue("teacher","3");
        utils.addFieldToMyFormWithValue("semester","2");
        utils.addFieldToMyFormWithValue("sectionnum","1");
        utils.addFieldToMyFormWithValue("roomnum","1");
        utils.addFieldToMyFormWithValue("periodnum","1");
        utils.addFieldToMyFormWithValue("editclass","1");
        utils.addFieldToMyFormWithValue("courseid","7");

        utils.submitForm("myform");

        currValue = driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
        assertEquals(oldValue, currValue);
    }

}

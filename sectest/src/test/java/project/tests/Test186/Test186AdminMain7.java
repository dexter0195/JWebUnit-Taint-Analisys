package project.tests.Test186;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import project.PageObjects.AdminMainPage;
import project.tests.*;


public class Test186AdminMain7 extends BaseTest{

    @Before
    public void prepare(){
    }

    @Test
    public void test(){

        AdminMainPage adminMainPage = new AdminMainPage(driver);

        String title;

        //login as schoolmate
        loginPage.login("schoolmate", "schoolmate");

        title = loginPage.getPageTitle();
        assertEquals("SchoolMate - School Name", title);

        //tamper with page2
        adminMainPage.setPage2Field("'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"");

        //check we are on the right page again
        title = loginPage.getPageTitle();
        assertEquals("SchoolMate - School Name", title);

        //submit the form with the injection
        adminMainPage.submitForm("admin");

        assertFalse(adminMainPage.isLinkPresentWithText("Malicious Link"));

        adminMainPage.logout();
    }
}

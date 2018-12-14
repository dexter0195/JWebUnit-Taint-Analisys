package project.tests;

//package automationFramework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.PageObjects.AdminMainPage;
import project.utils.BaseTest;

import static org.junit.Assert.*;


public class TestAdminMain extends BaseTest {

    AdminMainPage adminMainPage;

    @Before
    public void prepare(){
        //login as schoolmate
        loginPage.login("schoolmate", "schoolmate");
        adminMainPage = new AdminMainPage(driver);
    }

    @Test
    public void Test186FromAdminMain7(){


        String title = loginPage.getPageTitle();
        assertEquals("SchoolMate - School Name", title);

        //tamper with page2
        adminMainPage.setPage2Field("'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"");

        //submit the form
        adminMainPage.submitAdminForm();

        assertEquals(false, adminMainPage.isMaliciousLinkPresent());

    }

    @After
    public void cleanUp(){
        adminMainPage.logout();
    }
}

package project.tests;

//package automationFramework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.PageObjects.AdminMainPage;
import project.PageObjects.ManageTeacherPage;
import project.utils.BaseTest;

import static org.junit.Assert.*;


public class TestAdminMain extends BaseTest {


    @Before
    public void prepare(){
    }

    @Test
    public void Test186FromAdminMain7(){

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
        adminMainPage.submitAdminForm();

        assertFalse(adminMainPage.isMaliciousLinkPresent());

        adminMainPage.logout();
    }

    @Test
    public void Test111FromAdminMain7(){

        ManageTeacherPage manageTeacherPage = new ManageTeacherPage(driver);

        String title;

        //login as schoolmate
        loginPage.login("schoolmate", "schoolmate");

        title = loginPage.getPageTitle();
        assertEquals("SchoolMate - School Name", title);

        //click teachers

        manageTeacherPage.clickTeachersButton();
        assertEquals("Manage Teachers", manageTeacherPage.getPageHeading());

        //select one teacher

        int res = manageTeacherPage.selectFirstTeacher();
        assertEquals(0,res);

        //tamper with page2
        manageTeacherPage.setPage2Field("'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"");

        //check we are on the right page again
        title = loginPage.getPageTitle();
        assertEquals("SchoolMate - School Name", title);

        //submit the form with the injection
        manageTeacherPage.submitAdminForm();

        assertEquals(false, manageTeacherPage.isMaliciousLinkPresent());

        manageTeacherPage.logout();

    }

    @After
    public void cleanUp(){
    }
}

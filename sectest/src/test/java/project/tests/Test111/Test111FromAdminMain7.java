package project.tests.Test111;

//package automationFramework;
import org.junit.After;
import org.junit.Test;
import project.PageObjects.EditTeacherPage;
import project.PageObjects.ManageTeacherPage;
import project.tests.BaseTest;


import static org.junit.Assert.*;


public class Test111FromAdminMain7 extends BaseTest {

    @Test
    public void test(){

        String editTeacherPage2 = "17";

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
        assertEquals(0,manageTeacherPage.selectFirstTeacher());

        //tamper with page2
        manageTeacherPage.setPage2Field(editTeacherPage2+"'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"");

        //submit teacher form
        manageTeacherPage.submitForm("teachers");

        //check we are on the right page again
        assertEquals("Edit Teacher", manageTeacherPage.getPageHeading());

        assertFalse(manageTeacherPage.isLinkPresentWithText("Malicious Link"));

        manageTeacherPage.logout();

    }

    @After
    public void cleanUp(){
    }
}

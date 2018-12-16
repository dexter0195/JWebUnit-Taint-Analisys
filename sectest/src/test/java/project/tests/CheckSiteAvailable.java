package project.tests;

//package automationFramework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.PageObjects.AdminMainPage;

import static org.junit.Assert.assertEquals;


public class CheckSiteAvailable extends BaseTest {

    private AdminMainPage adminMainPage;

    @Before
    public void prepare(){

        //login as schoolmate
        loginPage.login("schoolmate", "schoolmate");
        adminMainPage = new AdminMainPage(driver);
    }

    @Test
    public void Test186FromIndex36(){

        String title = loginPage.getPageTitle();
        assertEquals("SchoolMate - School Name", title);

    }

    @After
    public void cleanUp(){
        adminMainPage.logout();
    }
}

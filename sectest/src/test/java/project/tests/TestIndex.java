package project.tests;

import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.PageObjects.LoginPage;
import project.utils.BaseTest;

public class TestIndex extends BaseTest{

    @Before
    public void prepare(){
        password = "schoolmate";
        username = "schoolmate";
        tester = new WebTester();
        pageTest = new LoginPage();
    }

    @Test
    public void Test186(){

        String PageSource;

        //edit variable page levering the php number conversion
        pageTest.login(tester, username, password);

        tester.setWorkingForm("admin");
        tester.setTextField("page", "1\'> <a href=\"http://unitn.it\">malicious link in page</a> <br \'");

        Util.addSubmitButton("//form[@name='admin']", tester);
        tester.submit();

        tester.assertMatch("Manage Classes");
        tester.assertLinkNotPresentWithText("malicious link in page");

    }


    @After
    public void cleanUp(){
        pageTest.logout(tester);
    }
}

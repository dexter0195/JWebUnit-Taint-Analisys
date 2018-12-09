package project;

import org.junit.*;
import net.sourceforge.jwebunit.junit.*;
import project.PageObjects.*;

import org.junit.Test;

public class TestSiteMessage54 {

        private String previousValue;
        private final String username = "schoolmate";
        private final String password = "schoolmate";

        private WebTester tester;
        private LoginPage pageTest;

        @Before
        public void prepare(){
                tester = new WebTester();
                pageTest = new LoginPage();
        }

        @Test
        public void test(){
                pageTest.login(tester, username, password);

                tester.clickLinkWithText("School");

                tester.assertMatch("Manage School Information");
                previousValue = tester.getElementByXPath("html//textarea[@name='sitetext']").getTextContent();

                tester.setTextField("sitetext", "original message <a href=http://www.unitn.it>malicious link</a>");
                tester.clickButtonWithText(" Update ");

                pageTest.logout(tester);

                tester.assertMatch("Today's Message");
                tester.assertLinkNotPresentWithText("malicious link");
        }

        @After
        public void cleanUp(){

                pageTest.login(tester, username, password);

                tester.clickLinkWithText("School");

                tester.assertMatch("Manage School Information");
                tester.setTextField("sitetext", previousValue);
                tester.clickButtonWithText(" Update ");

                pageTest.logout(tester);
        }
}
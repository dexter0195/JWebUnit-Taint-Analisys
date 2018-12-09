package project.PageObjects;

import org.junit.*;
import net.sourceforge.jwebunit.junit.*;

import org.junit.Test;

public class LoginPage {

    private String previousValue;

    public void login(WebTester tester,String username, String password){

                tester.setBaseUrl("http://192.168.56.103/schoolmate/");
                tester.beginAt("/index.php");
                tester.setTextField("username", username);
                tester.setTextField("password", password);
                tester.submit();
    }
    
    public void logout (WebTester tester){

                tester.clickLinkWithExactText("Log Out");
    }
}
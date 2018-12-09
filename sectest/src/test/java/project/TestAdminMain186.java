package project;
import org.junit.*;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.helpers.AttributesImpl;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.InputElementFactory;

import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;
import net.sourceforge.jwebunit.junit.WebTester;

import project.PageObjects.*;

public class TestAdminMain186 {
    private final String username = "schoolmate";
    private final String password = "schoolmate";

    private WebTester tester;
    private LoginPage pageTest;

    private void addSubmitButton(String xpath){
        IElement element = tester.getElementByXPath(xpath);
        DomElement form = ((HtmlUnitElementImpl) element).getHtmlElement();
        InputElementFactory factory = InputElementFactory.instance;
        AttributesImpl attributes = new AttributesImpl();
        attributes.addAttribute("", "", "type", "", "submit");
        HtmlElement submit = factory.createElement(form.getPage(), "input", attributes);
        form.appendChild(submit);
    }

    @Before
    public void prepare(){
        tester = new WebTester();
        pageTest = new LoginPage();
    }

    @Test
    public void testa(){
        pageTest.login(tester, username, password);

        tester.setWorkingForm("admin");
        tester.setTextField("page2", "'> <a href=\\\"http://unitn.it\\\">malicious link</a> <br '");

        addSubmitButton("//form[@name='admin']");
        tester.submit();

        tester.assertMatch("Manage Classes");
        tester.assertLinkNotPresentWithText("malicious link");

    }

    @After
    public void cleanUp(){

    }
}

package project.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.apache.commons.collections.functors.InstantiateFactory;
import org.xml.sax.helpers.AttributesImpl;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.InputElementFactory;

import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;

public class utils {
    public void addScript(String xpath, WebTester tester) {
        String injection = "<script> function malicious () { document.admin.page.value = \"'1> <a href=\"http://unitn.it\">malicious link in page</a> <br '\"; document.admin.submit(); } </script> <button type=\"button\" onclick=\"malicious ()\" > Click Me! </button>";
        IElement element = tester.getElementByXPath(xpath);
        //get the node
        DomElement node = ((HtmlUnitElementImpl) element).getHtmlElement();
        //create a new input
        InputElementFactory factory = InputElementFactory.instance;
        //define the attributes
        AttributesImpl attributes = new AttributesImpl();

    }
    public void addSubmitButton(String xpath, WebTester tester){
        IElement element = tester.getElementByXPath(xpath);
        DomElement form = ((HtmlUnitElementImpl) element).getHtmlElement();
        InputElementFactory factory = InputElementFactory.instance;
        AttributesImpl attributes = new AttributesImpl();
        attributes.addAttribute("", "", "type", "", "submit");
        HtmlElement submit = factory.createElement(form.getPage(), "input", attributes);
        form.appendChild(submit);
    }
    public void SimpleSleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

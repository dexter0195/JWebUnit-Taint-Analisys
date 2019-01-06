package project.utils;

import org.apache.commons.lang.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myUtils {

    private WebDriver driver;

    public myUtils (WebDriver driver){
        this.driver = driver;
    }

    public void submitForm(String name){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document."+name+".submit()");
        SimpleSleep(1);
    }

    public WebElement getVarElement(String formName, String taintedVar){
        return driver.findElement(By.xpath("//form[@name='"+formName+"']//input[@name='"+taintedVar+"']"));
    }

    public boolean isMaliciousLinkPresentInForm(String formName){
        String xpath = "//form[@name='"+formName+"']//a[contains(text(),'Malicious Link')]";
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public boolean isMaliciousLinkPresentInPath(String s) {
        return driver.findElements(By.xpath(s+"//a[contains(text(),'Malicious Link')]")).size() > 0;
    }

    public void injectVarMyForm(String variable){

        String formName = "myform";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement target = getVarElement(formName, variable);
        String currentPageValue = target.getAttribute("value");
        String injection = currentPageValue+"'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"";
        String script = "arguments[0].setAttribute(\"value\",\""+injection+")";
        js.executeScript(script, target);

        submitForm(formName);
        SimpleSleep(1);

    }

    public void injectVarMyFormForSQL(String variable) {

        String formName = "myform";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement target = getVarElement(formName, variable);
        String currentPageValue = target.getAttribute("value");
        String injection = currentPageValue+"; -- '><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"";
        String script = "arguments[0].setAttribute(\"value\",\""+injection+")";
        js.executeScript(script, target);

        submitForm(formName);
        SimpleSleep(1);
    }

    public void SimpleSleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createMyForm() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String javascript = "var f = document.createElement('form');"
                +"f.setAttribute('method','post'); "
                +"f.setAttribute('id','myform'); "
                + "f.setAttribute('name','myform');"
                +"document.getElementsByTagName('body')[0].appendChild(f); ";

        js.executeScript(javascript);

    }

    public void addFieldToMyFormWithValue(String var, String s, String type) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String javascript = "var f = document.getElementById('myform');"
                +"var i = document.createElement('textarea');"
                +"i.setAttribute('name','"+var+"');"
                +"i.innerText = '"+ StringEscapeUtils.escapeJavaScript(s) +"';"
                +"f.appendChild(i);";

        js.executeScript(javascript);
    }
    public void addFieldToMyFormWithValue(String var, String s) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String javascript = "var f = document.getElementById('myform');"
                +"var i = document.createElement('input');"
                +"i.setAttribute('type','hidden');"
                +"i.setAttribute('name','"+var+"');"
                +"i.setAttribute('value','"+s+"');"
                +"f.appendChild(i);";

        js.executeScript(javascript);
    }

    public boolean isTitleEqualsTo(String s) {
        String heading = driver.findElement(By.xpath("//h1")).getText();
        return heading.equals(s);
    }
}

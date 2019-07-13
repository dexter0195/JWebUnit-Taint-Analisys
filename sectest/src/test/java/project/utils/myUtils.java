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

    public void injectVarMyFormForSQL(String variable, String injectionString) {

        String formName = "myform";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement target = getVarElement(formName, variable);
        String currentPageValue = target.getAttribute("value");
        String injection = currentPageValue+injectionString;
        String script = "arguments[0].setAttribute(\"value\",\""+injection+"\")";
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

    public void addFieldToMyFormWithValue(String var, String s, String name) {
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

    public void createMyFormForManageSchoolInfo() {
        createMyForm();
        addFieldToMyFormWithValue("page","1");
        addFieldToMyFormWithValue("page2","1");
        addFieldToMyFormWithValue("schoolname",
          driver.findElement(By.xpath("//input[@name='schoolname']")).getAttribute("value"));
        addFieldToMyFormWithValue("schooladdress",
          driver.findElement(By.xpath("//input[@name='schooladdress']")).getAttribute("value"));
        addFieldToMyFormWithValue("schoolphone",
          driver.findElement(By.xpath("//input[@name='schoolphone']")).getAttribute("value"));
        addFieldToMyFormWithValue("numsemesters",
          driver.findElement(By.xpath("//input[@name='numsemesters']")).getAttribute("value"));
        addFieldToMyFormWithValue("numperiods",
          driver.findElement(By.xpath("//input[@name='numperiods']")).getAttribute("value"));
        addFieldToMyFormWithValue("apoint",
          driver.findElement(By.xpath("//input[@name='apoint']")).getAttribute("value"));
        addFieldToMyFormWithValue("bpoint",
          driver.findElement(By.xpath("//input[@name='bpoint']")).getAttribute("value"));
        addFieldToMyFormWithValue("cpoint",
          driver.findElement(By.xpath("//input[@name='cpoint']")).getAttribute("value"));
        addFieldToMyFormWithValue("dpoint",
          driver.findElement(By.xpath("//input[@name='dpoint']")).getAttribute("value"));
        addFieldToMyFormWithValue("fpoint",
          driver.findElement(By.xpath("//input[@name='fpoint']")).getAttribute("value"));
        addFieldToMyFormWithValue("sitetext",
          driver.findElement(By.xpath("//textarea[@name='sitetext']")).getAttribute("value"), "sitetext");
        addFieldToMyFormWithValue("sitemessage",
          driver.findElement(By.xpath("//textarea[@name='sitemessage']")).getAttribute("value"), "sitemessage");
        addFieldToMyFormWithValue("infoupdate","1");
    }
}

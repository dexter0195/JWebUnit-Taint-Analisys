package project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myUtils {

    private WebDriver driver;

    public myUtils (WebDriver driver){
        this.driver = driver;
    }

    private void submitForm(String name){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document."+name+".submit()");
        SimpleSleep(1);
    }

    private WebElement getVarElement(String formName, String taintedVar){
        return driver.findElement(By.xpath("//form[@name='"+formName+"']//input[@name='"+taintedVar+"']"));
    }

    public boolean isMaliciousLinkPresentInForm(String formName){
        String xpath = "//form[@name='"+formName+"']//a[contains(text(),'Malicious Link')]";
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public void inject(String variable, String formName){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement target = getVarElement(formName, variable);
        String currentPageValue = target.getAttribute("value");
        String injection = currentPageValue+"'><a href=\'www.unitn.it\'>Malicious Link</a> <br'\"";
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
}

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

    public void SimpleSleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inject(WebElement variable, String injection){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script = "arguments[0].setAttribute(\"value\",\""+injection+")";
        js.executeScript(script, variable);

    }

    public void submitForm(String name){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document."+name+".submit()");
        SimpleSleep(1);
    }

    public boolean isLinkPresentWithText(String text){
        return driver.findElements(By.linkText(text)).size() > 0;
    }
}

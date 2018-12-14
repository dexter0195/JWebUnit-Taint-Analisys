package project.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.JavascriptExecutor;

public class AdminMainPage extends LoggedInPage{


    @FindBy(xpath = "//form[@name='admin']//input[@name='page2']")
    private WebElement page2Field;

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public AdminMainPage(WebDriver driver){
        super(driver);
    }

    public boolean isMaliciousLinkPresent(){
        return driver.findElements(By.linkText("Malicious Link")).size() > 0;
    }

    public String getPage2Value(){
        return page2Field.getText();
    }

    public void submitAdminForm(){
        js.executeScript("window.admin.submit()");
    }

    public void setPage2Field(String s){
        String injection = "arguments[0].setAttribute(\"value\",\""+s+")";
        js.executeScript(injection, page2Field);

    }

}


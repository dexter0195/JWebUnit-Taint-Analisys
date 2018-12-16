package project.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditTeacherPage extends LoggedInPage {

    @FindBy(xpath = "//form[@name='editteacher']//input[@name='page2']")
    protected WebElement page2Field;

    public EditTeacherPage(WebDriver driver){
        super(driver);
    }

    @Override
    public WebElement getPage2Field() {
        return page2Field;
    }
}

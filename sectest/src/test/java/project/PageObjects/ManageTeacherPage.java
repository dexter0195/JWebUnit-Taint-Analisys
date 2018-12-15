package project.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManageTeacherPage extends LoggedInPage{


    @FindBy(xpath = "//form[@name='teachers']//input[@type='checkbox']")
    private List<WebElement> teacherCheckboxes;

    @FindBy(xpath = "//form[@name='teachers']//input[@name='page2']")
    protected WebElement page2Field;

    public ManageTeacherPage(WebDriver driver) {
        super(driver);
    }

    public int selectFirstTeacher(){
        if (teacherCheckboxes.size() == 0){
            return 1;
        }
        //otherwise just do the test on the first teacher
        teacherCheckboxes.get(1).click();
        return 0;
    }
}

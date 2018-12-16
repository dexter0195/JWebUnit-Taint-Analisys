package project.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManageTeacherPage extends LoggedInPage {


    @FindBy(xpath = "//form[@name='teachers']//input[@type='checkbox']")
    private List<WebElement> teacherCheckboxes;

    @FindBy(xpath = "//form[@name='teachers']//input[@name='page2']")
    protected WebElement page2Field;

    @FindBy(xpath = "/html[1]/body[1]/table[2]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/input[5]")
    private WebElement EditButton;

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

    private EditTeacherPage clickEdit(){
        EditButton.click();
        return new EditTeacherPage(driver);
    }

    public EditTeacherPage goToEditTeacher(){
        return clickEdit();
    }

    public WebElement getPage2Field(){
        return page2Field;
    }
}

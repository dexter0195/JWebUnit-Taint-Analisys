package project.tests.TeachersPage.Roles.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.tests.BaseTest;


public class TeacherAdminBaseTest extends BaseTest {

    protected static String username = "schoolmate";
    protected static String password = "schoolmate";

    protected void clickTeacherButton(){
        WebElement teacherButton;
        teacherButton = driver.findElement(By.xpath("//a[contains(text(),'Teachers')]"));
        teacherButton.click();
    }

    protected boolean isTeacherPage(){
        String heading = driver.findElement(By.xpath("//h1")).getText();
        return heading.equals("Manage Teachers");
    }

}

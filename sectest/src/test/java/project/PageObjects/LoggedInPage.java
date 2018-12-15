package project.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends PageObject{

    @FindBy(xpath = "//form[@name='admin']//input[@name='page2']")
    protected WebElement page2Field;

    @FindBy(xpath = "//a[contains(text(),'School')]")
    protected WebElement schoolButton;

    @FindBy(xpath = "//a[contains(text(),'Terms')]")
    protected WebElement termsButton;

    @FindBy(xpath = "//a[contains(text(),'Semesters')]")
    protected WebElement semestersButton;

    @FindBy(xpath = "//a[contains(text(),'Classes')]")
    protected WebElement classesButton;

    @FindBy(xpath = "//a[contains(text(),'Users')]")
    protected WebElement usersButton;

    @FindBy(xpath = "//a[contains(text(),'Teachers')]")
    protected WebElement teachersButton;

    @FindBy(xpath = "//a[contains(text(),'Students')]")
    protected WebElement studentsButton;

    @FindBy(xpath = "//a[contains(text(),'Registration')]")
    protected WebElement registrationButton;

    @FindBy(xpath = "//a[contains(text(),'Attendance')]")
    protected WebElement attendanceButton;

    @FindBy(xpath = "//a[contains(text(),'Parents')]")
    protected WebElement parentsButton;

    @FindBy(xpath = "//a[contains(text(),'Announcements')]")
    protected WebElement announcementsButton;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    protected WebElement logoutButton;

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public void clickSchoolButton(){
        schoolButton.click();
    }
    public void clickTermsButton(){
        termsButton.click();
    }
    public void clickSemestersButton(){
        semestersButton.click();
    }
    public void clickClassesButton(){
        classesButton.click();
    }
    public void clickUsersButton(){
        usersButton.click();
    }
    public void clickTeachersButton(){
        teachersButton.click();
    }
    public void clickStudentsButton(){
        studentsButton.click();
    }
    public void clickRegistrationButton(){
        registrationButton.click();
    }
    public void clickAttendanceButton(){
        attendanceButton.click();
    }
    public void clickParentsButton(){
        parentsButton.click();
    }
    public void clickAnnouncementsButton(){
        announcementsButton.click();
    }
    public void logout (){
        logoutButton.click();
    }

    public String getPageHeading(){
        String title;
        title = driver.findElement(By.xpath("//h1")).getText();
        return title;
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

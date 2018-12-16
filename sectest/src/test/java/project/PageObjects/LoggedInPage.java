package project.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends PageObject{

    @FindBy(xpath = "//form[@name='admin']//input[@name='page2']")
    protected WebElement page2Field;

    @FindBy(xpath = "//a[@class='menu'][contains(text(),'School')]")
    private WebElement schoolButton;

    @FindBy(xpath = "//a[contains(text(),'Terms')]")
    private WebElement termsButton;

    @FindBy(xpath = "//a[contains(text(),'Semesters')]")
    private WebElement semestersButton;

    @FindBy(xpath = "//a[contains(text(),'Classes')]")
    private WebElement classesButton;

    @FindBy(xpath = "//a[contains(text(),'Users')]")
    private WebElement usersButton;

    @FindBy(xpath = "//a[contains(text(),'Teachers')]")
    private WebElement teachersButton;

    @FindBy(xpath = "//a[contains(text(),'Students')]")
    private WebElement studentsButton;

    @FindBy(xpath = "//a[contains(text(),'Registration')]")
    private WebElement registrationButton;

    @FindBy(xpath = "//a[contains(text(),'Attendance')]")
    private WebElement attendanceButton;

    @FindBy(xpath = "//a[contains(text(),'Parents')]")
    private WebElement parentsButton;

    @FindBy(xpath = "//a[contains(text(),'Announcements')]")
    private WebElement announcementsButton;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    private WebElement logoutButton;

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public void clickSchoolButton(){
        schoolButton.click();
        utils.SimpleSleep(1);
    }
    public void clickTermsButton(){
        termsButton.click();
        utils.SimpleSleep(1);
    }
    public void clickSemestersButton(){
        semestersButton.click();
        utils.SimpleSleep(1);
    }
    public void clickClassesButton(){
        classesButton.click();
        utils.SimpleSleep(1);
    }
    public void clickUsersButton(){
        usersButton.click();
        utils.SimpleSleep(1);
    }
    public void clickTeachersButton(){
        teachersButton.click();
        utils.SimpleSleep(1);
    }
    public void clickStudentsButton(){
        studentsButton.click();
        utils.SimpleSleep(1);
    }
    public void clickRegistrationButton(){
        registrationButton.click();
        utils.SimpleSleep(1);
    }
    public void clickAttendanceButton(){
        attendanceButton.click();
        utils.SimpleSleep(1);
    }
    public void clickParentsButton(){
        parentsButton.click();
        utils.SimpleSleep(1);
    }
    public void clickAnnouncementsButton(){
        announcementsButton.click();
        utils.SimpleSleep(1);
    }
    public void logout (){
        logoutButton.click();
        utils.SimpleSleep(1);
    }

    public String getPageHeading(){
        String title;
        title = driver.findElement(By.xpath("//h1")).getText();
        return title;
    }

    public boolean isLinkPresentWithText(String text){
        return driver.findElements(By.linkText(text)).size() > 0;
    }

    public String getPage2Value(){
        page2Field = getPage2Field();
        return this.page2Field.getAttribute("value");
    }

    public void submitForm(String name){
        js.executeScript("document."+name+".submit()");
        utils.SimpleSleep(1);
    }

    public void setPage2Field(String s){
        page2Field = getPage2Field();
        String injection = "arguments[0].setAttribute(\"value\",\""+s+")";
        js.executeScript(injection, page2Field);
    }

    public WebElement getPage2Field() {
        return page2Field;
    }
}

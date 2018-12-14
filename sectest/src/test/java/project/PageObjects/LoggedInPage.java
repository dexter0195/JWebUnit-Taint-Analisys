package project.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends PageObject{
    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    private WebElement logoutButton;

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public void logout (){
        logoutButton.click();
    }
}

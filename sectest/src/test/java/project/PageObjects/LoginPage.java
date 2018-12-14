package project.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

    private String username;
    private String password;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle (){
        return driver.getTitle();
    }

    private void goToLoginPage(){
        // Storing the Application Url in the String variable
        String url = "http://192.168.56.103/schoolmate/index.php";
        //Launch the ToolsQA WebSite
        driver.get(url);
    }


    private void fillUsername(){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    private void fillPassword(){
        passwordField.clear();
        passwordField.sendKeys(username);
    }

    private void clickLoginButton() {
        this.loginButton.click();
    }

    public void login(String username, String password){

        goToLoginPage();

        this.username = username;
        this.password = password;

        fillUsername();
        fillPassword();

        clickLoginButton();
    }

}
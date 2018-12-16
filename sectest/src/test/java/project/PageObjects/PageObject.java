package project.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import project.utils.*;

public class PageObject {

    protected WebDriver driver;

    protected myUtils utils = new myUtils();

    public PageObject (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}

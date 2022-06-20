package pages.saucedemopage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {

    public SauceDemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input[id='user-name']")
    public WebElement userName;

    @FindBy(css = "input[id='password']")
    public WebElement passWord;

    @FindBy(css = "input[data-test$='-button']")
    public WebElement logInButton;

    @FindBy(css = "//span[text()='Products']")
    public WebElement assertionElement;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;



}

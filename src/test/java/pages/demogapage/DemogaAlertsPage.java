package pages.demogapage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemogaAlertsPage {
    public DemogaAlertsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//header//a")
    public WebElement toolsQA;

    @FindBy(xpath = "(//div[@class='card-body'])[3]")
    public WebElement alertsFrameWindow;

    @FindBy(xpath = "(//div[@class='element-list collapse show'])//ul//li[2]")
    public WebElement alertButton;

    @FindBy(xpath = "//button[@id='alertButton']")
    public WebElement clickMe01;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    public WebElement clickMe02;

    @FindBy(xpath = "//button[@id='confirmButton']")
    public WebElement clickMe03;

    @FindBy(id = "promtButton")
    public WebElement clickMe04;

    @FindBy(id = "promptResult")
    public WebElement messageResult;
}

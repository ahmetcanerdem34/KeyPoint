package pages.demogapage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemogaWidGetsPage {

    public DemogaWidGetsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[4]")
    public WebElement widgetsButton;

    @FindBy(xpath = "//span[text()='Tool Tips']")
    public WebElement toolTipsButton;

    @FindBy(id = "toolTipButton")
    public WebElement hoverOverMeToSee;

    @FindBy(xpath = "//input[@id='toolTipTextField']")
    public WebElement hoverText;


}

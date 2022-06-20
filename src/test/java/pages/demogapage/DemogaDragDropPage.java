package pages.demogapage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemogaDragDropPage {

    public DemogaDragDropPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-body'])[5]")
    public WebElement interactionsButton;

    @FindBy(xpath = "(//li[@id='item-3'])[4]")
    public WebElement dropabbleButton;

    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement dragMeBox;

    @FindBy(xpath = "(//div[@id='droppable'])[1]")
    public WebElement dropHereBox;
}

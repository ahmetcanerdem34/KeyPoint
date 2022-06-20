package stepdefinitions.demoga;

import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.demogapage.DemogaDragDropPage;
import stepdefinitions.demoga.DemogaHomePageAlerts;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethod;

public class DemogaHomePageDragDrop {

    DemogaDragDropPage page = new DemogaDragDropPage();
    Logger log = (Logger) LogManager.getLogger(DemogaHomePageAlerts.class);
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
    ReusableMethod wait;
    @Then("user clicks Interactions button")
    public void user_clicks_interactions_button() {
        log.info("user clicks Interactions button");
        js.executeScript("window.scrollBy(0,300)");
        page.interactionsButton.click();
        js.executeScript("window.scrollBy(0,300)");
    }
    @Then("user clicks Dropabble button")
    public void userClicksDropabbleButton() {
        log.info("user clicks Dropabble button");
        page.dropabbleButton.click();
    }

    @Then("user drags DragMe box in to DropHere box and verifies it")
    public void userDragsDragMeBoxInToDropHereBoxAndVerfiesIt() {
        log.info("user drags DragMe box in to DropHere box");
        Actions builder = new Actions(Driver.getDriver());
        Actions build= builder.dragAndDrop(page.dragMeBox, page.dropHereBox);
        build.perform();
        log.info("and verifies it");
        String expected = "Dropped!";
        Assert.assertTrue(expected,page.dropHereBox.getText().contains("Dropped!"));
        System.out.println(expected);
        Log.endTestCase("Test");
    }
}

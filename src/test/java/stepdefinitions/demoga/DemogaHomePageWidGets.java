package stepdefinitions.demoga;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.demogapage.DemogaWidGetsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.Log;

import java.io.File;
import java.io.IOException;

public class DemogaHomePageWidGets {

    DemogaWidGetsPage page = new DemogaWidGetsPage();
    Logger log = (Logger) LogManager.getLogger(DemogaHomePageAlerts.class);
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Given("users goes to demoga home page")
    public void users_goes_to_demoga_home_page() {
        Log.startTestCase("Tests");
        Driver.getDriver().get(ConfigurationReader.getProperty("demoga_url"));
        log.info("user goes to demoga home page");
        js.executeScript("window.scrollBy(0,300)");
    }
    @Then("user clicks WidGets button")
    public void user_clicks_wid_gets_button() {
        log.info("user clicks WidGets button");
        page.widgetsButton.click();
        js.executeScript("window.scrollBy(0,300)");
    }
    @Then("user clicks ToolTips button")
    public void userClicksToolTipsButton() {
        log.info("user clicks ToolTips button");
        page.toolTipsButton.click();
    }
    @Then("user hovers over Hover Me To See button and verifies it")
    public void userHoversOverHoverMeToSeeButtonAndVerifiesIt() throws IOException {
        log.info("user hovers over Hover Me To See button verifies it");
        Actions builder = new Actions(Driver.getDriver());
        Action build = builder.moveToElement(page.hoverOverMeToSee).build();
        build.perform();
        System.out.println(Color.fromString(page.hoverOverMeToSee.getCssValue("color")).asHex());
        WebDriverWait waiting1= new WebDriverWait(Driver.getDriver(),20);
        waiting1.until(ExpectedConditions.elementToBeClickable(page.hoverText));
        Assert.assertTrue(page.hoverText.isDisplayed());
        TakesScreenshot takeScreetShot= (TakesScreenshot)Driver.getDriver();
        File screenFiling = takeScreetShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenFiling, new File("screenshots/demoga/HoverOverControl.png") );
        Log.endTestCase("");
        Driver.closeDriver();

    }
}

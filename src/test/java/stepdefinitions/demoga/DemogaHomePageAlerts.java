package stepdefinitions.demoga;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.demogapage.DemogaAlertsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethod;


public class DemogaHomePageAlerts {

    DemogaAlertsPage page = new DemogaAlertsPage();
    Logger log = (Logger) LogManager.getLogger(DemogaHomePageAlerts.class);
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
    ReusableMethod wait;

    @Given("user goes to demoga home page")
    public void user_goes_to_demoga_home_page() {
        Log.startTestCase("");
        Driver.getDriver().get(ConfigurationReader.getProperty("demoga_url"));
        log.info("user goes to demoga home page");
    }
    @Then("user verifies that it is home page")
    public void userVerifiesThatItIsHomePage() {
        log.info("user verifies that it is home page");
        Assert.assertTrue(page.toolsQA.isDisplayed());
    }
    @Then("user clicks alerts frame window button")
    public void userClicksAlertsFrameWindowButton() {
        js.executeScript("window.scrollBy(0,300)");
        log.info("user clicks alerts frame window button");
        page.alertsFrameWindow.click();
    }
    @Then("user clicks alert button")
    public void userClicksAlertButton() {
        log.info("user clicks alert");
        js.executeScript("window.scrollBy(0,300)");
        page.alertButton.click();
    }
    @Then("user clicks first clickMe buttton and switchToAlert button")
    public void userClicksFirstClickMeButttonAndSwitchToAlertButton() {
        log.info("user clicks first clickMe And SwitchToAlert Button");
        page.clickMe01.click();
        Alert alert01 = Driver.getDriver().switchTo().alert();
        alert01.accept();
    }
    @Then("user clicks second clickMe buttton and switchToAlert button")
    public void userClicksSecondClickMeButttonAndSwitchToAlertButton() {
        log.info("user clicks second clickMe And SwitchToAlert Button");
        page.clickMe02.click();
        WebDriverWait waiting1= new WebDriverWait(Driver.getDriver(),20);
        waiting1.until(ExpectedConditions.elementToBeClickable(page.clickMe02));
        wait.sleep(7000);
        Alert alert02 = Driver.getDriver().switchTo().alert();
        alert02.accept();
    }
    @Then("user clicks third clickMe buttton and switchToAlert button and clicks confirm")
    public void userClicksThirdClickMeButttonAndSwitchToAlertButtonAndClicksConfirm(){
        js.executeScript("window.scrollBy(0,300)");
        log.info("user clicks third click");
        wait.sleep(3000);
        page.clickMe03.click();
        Alert alert03 = Driver.getDriver().switchTo().alert();
        alert03.accept();
    }
    @Then("user clicks fourth clickMe buttton and switchToAlert and sends name")
    public void userClicksFourthClickMeButttonAndSwitchToAlertAndSendsName() {
        log.info("user clicks fourth clickMe buttton and switchToAlert and sends name");
        wait.sleep(3000);
        page.clickMe04.click();
        Alert name = Driver.getDriver().switchTo().alert();
        log.info("Ahmet name was sent by user");
        name.sendKeys("Ahmet");
        name.accept();
    }
    @Then("user types name in box and verifies it")
    public void userTypesNameInBoxAndVerifiesIt() {
        log.info("user types name in box and verifies it");
        String expected = "Ahmet";
        Assert.assertTrue(expected,page.messageResult.getText().contains("Ahmet"));
        Log.endTestCase("test has finished");
    }
}

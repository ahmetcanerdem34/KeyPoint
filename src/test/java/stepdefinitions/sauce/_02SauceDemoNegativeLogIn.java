package stepdefinitions.sauce;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.saucedemopage.SauceDemoPage;
import stepdefinitions.demoga.DemogaHomePageAlerts;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethod;

import java.io.File;
import java.io.IOException;

public class _02SauceDemoNegativeLogIn {

    SauceDemoPage page = new SauceDemoPage();
    Logger log = (Logger) LogManager.getLogger(DemogaHomePageAlerts.class);
    ReusableMethod wait;

    @Given("users goes to saucedemo login page")
    public void usersGoesToSaucedemoLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("sauceDemo_url"));
    }
    @Then("user types invalid userName")
    public void user_types_invalid_user_name() {
        Log.startTestCase("");
         page.userName.sendKeys(ConfigurationReader.getProperty("inValid_sauceDemo_inValidUserName"));
    }

    @Then("user types valid password and clicks login button")
    public void user_types_invalid_password_and_clicks_login_button() {
        log.info("user types valid password and clicks login button");
        page.passWord.sendKeys(ConfigurationReader.getProperty("valid_sauceDemo_passWord"));
        page.logInButton.click();

    }
    @And("user checks error message and verifies it")
    public void userChecksErrorMessageAndVerifiesIt() throws IOException {
        log.info("user checks error message and verifies it");
        Assert.assertTrue(page.errorMessage.isDisplayed());
        WebDriverWait waiting1= new WebDriverWait(Driver.getDriver(),20);
        waiting1.until(ExpectedConditions.elementToBeClickable(page.errorMessage));
        TakesScreenshot takeScreetShot= (TakesScreenshot)Driver.getDriver();
        File screenFiling = takeScreetShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenFiling, new File("screenshots/sauceDemo/ErrorMessageControl.png") );
    }
    @Then("user types invalid password and clicks login button")
    public void userTypesInvalidPasswordAndClicksLoginButton() {
        log.info("user types invalid password and clicks login button");
        page.passWord.sendKeys(ConfigurationReader.getProperty("inValid_sauceDemo_passWord"));
        page.logInButton.click();
        Log.endTestCase("");
        Driver.getDriver().close();
    }
}

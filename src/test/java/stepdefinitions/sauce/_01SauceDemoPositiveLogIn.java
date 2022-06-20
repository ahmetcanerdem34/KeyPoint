package stepdefinitions.sauce;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.saucedemopage.SauceDemoPage;
import stepdefinitions.demoga.DemogaHomePageAlerts;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.Log;
import utilities.ReusableMethod;

public class _01SauceDemoPositiveLogIn {
    SauceDemoPage page = new SauceDemoPage();
    Logger log = (Logger) LogManager.getLogger(DemogaHomePageAlerts.class);
    ReusableMethod wait;

    @Given("users goes to saucedemo home page")
    public void users_goes_to_saucedemo_home_page() {
        Log.startTestCase("");
        Driver.getDriver().get(ConfigurationReader.getProperty("sauceDemo_url"));
        log.info("user went to Sauce Demo Log in Page");
    }

    @Then("user enters valid userName")
    public void userEntersValidUserName() {
        log.info("user enters valid userName");
        page.userName.sendKeys(ConfigurationReader.getProperty("valid_sauceDemo_userName"));
        log.info("User entered valid user name");

    }
    @Then("user enters valid password and clicks login button")
    public void userEntersValidPasswordAndClicksLoginButton() {
        log.info("user enters valid password and clicks login button");
        page.passWord.sendKeys(ConfigurationReader.getProperty("valid_sauceDemo_passWord"));
        log.info("User entered valid password");
        page.logInButton.click();
        log.info("User clicked login button");
    }
    @Then("user enters valid second userName")
    public void user_enters_valid_second_user_name() {
        log.info("User entered valid second user name");
        page.userName.sendKeys(ConfigurationReader.getProperty("validSecond_sauceDemo_userName"));

    }
    @Then("user enters valid third userName")
    public void userEntersValidThirdUserName() {
        log.info("User entered valid third user name");
        page.userName.sendKeys(ConfigurationReader.getProperty("validThird_sauceDemo_userName"));

    }


}




package utilities;



import io.github.bonigarcia.wdm.WebDriverManager;//yoldur bonugarsia yazmıştır, içerisinde chromedriver() gibi methodlar vardır
import org.openqa.selenium.WebDriver;//ise arabadır, seleniumdan gelir, WebDriver olmadan yolun anlamı olmaz, yolda arabasız olmaz
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){

    }
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver== null){

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        return driver;

    }

    public static void closeDriver(){

        if(driver != null){
            driver.quit();//kapat
            driver = null;//driver ı temizle
        }
    }
}

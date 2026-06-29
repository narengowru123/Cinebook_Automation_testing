package base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        String browser = ConfigReader.get("browser");
        logger.info("Launching browser : {}",browser);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            if (ConfigReader.getBoolean("headless")) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            } else {
                options.addArguments("--start-maximized");
            }

            driver = new ChromeDriver(options);



        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getInt("timeout"))
        );

        driver.get(ConfigReader.get("baseurl"));
    }

    protected void loginAsMoviegoer() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("moviegoer.username"),
                ConfigReader.get("moviegoer.password")
        );
    }

    protected void loginAsTheatreOwner() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("owner.username"),
                ConfigReader.get("owner.password")
        );
    }

    @AfterMethod
    public void tearMethod(){
        if(driver != null){
            driver.quit();
        }

    }
    public WebDriver getDriver() {
        return driver;
    }

}









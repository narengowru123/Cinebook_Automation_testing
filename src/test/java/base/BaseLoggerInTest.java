package base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;

public class BaseLoggerInTest extends BaseTest{
    private static final Logger logger = LogManager.getLogger(BaseLoggerInTest.class);

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest() {
        logger.info("Logging in before test");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("valid.username"),
                ConfigReader.get("valid.password")
        );

        wait.until(ExpectedConditions.urlContains("/movies"));
    }
}

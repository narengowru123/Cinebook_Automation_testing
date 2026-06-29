package base;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

public class BaseTheatreOwnerTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void loginOwnerBeforeTest() {
        loginAsTheatreOwner();
        wait.until(ExpectedConditions.urlContains("/owner"));
    }
}
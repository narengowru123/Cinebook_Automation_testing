package base;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;

public class BaseMoviegoerLogin extends BaseTest{
    @BeforeMethod
    public void loginMoviegoerBeforeTest() {
        loginAsMoviegoer();
        wait.until(ExpectedConditions.urlContains("/movies"));
    }
}

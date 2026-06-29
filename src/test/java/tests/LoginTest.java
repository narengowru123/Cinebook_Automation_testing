package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    private static final String LOGIN_DATA_PATH =
            "src/test/resources/LoginData.xlsx";

    @DataProvider(name = "moviegoerValidLoginData")
    public Object[][] moviegoerValidLoginData() {
        return ExcelUtils.getExcelData(LOGIN_DATA_PATH, "MoviegoerValid");
    }

    @DataProvider(name = "moviegoerInvalidLoginData")
    public Object[][] moviegoerInvalidLoginData() {
        return ExcelUtils.getExcelData(LOGIN_DATA_PATH, "MoviegoerInvalid");
    }

    @DataProvider(name = "ownerValidLoginData")
    public Object[][] ownerValidLoginData() {
        return ExcelUtils.getExcelData(LOGIN_DATA_PATH, "OwnerValid");
    }

    @DataProvider(name = "ownerInvalidLoginData")
    public Object[][] ownerInvalidLoginData() {
        return ExcelUtils.getExcelData(LOGIN_DATA_PATH, "OwnerInvalid");
    }

    @Test(dataProvider = "moviegoerValidLoginData")
    public void validMoviegoerLoginTest(String username, String password, String expectedUrl) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(dataProvider = "moviegoerInvalidLoginData")
    public void invalidMoviegoerLoginTest(String username, String password, String expectedUrl) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(dataProvider = "ownerValidLoginData")
    public void validOwnerLoginTest(String username, String password, String expectedUrl) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(dataProvider = "ownerInvalidLoginData")
    public void invalidOwnerLoginTest(String username, String password, String expectedUrl) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
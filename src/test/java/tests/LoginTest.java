package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Description("AUTHORIZATION CHECK")
    @Test(retryAnalyzer = Retry.class)
    public void loginTest() {
        loginPage
                .openPage()
                .loginPositive("testponch@mail.ru", "123456789test");
        myAccountPage.isPageOpened();

    }

    @Description("ERROR CHECK FOR EMPTY LOGIN")
    @Test(retryAnalyzer = Retry.class)
    public void emptyLogin() {
        loginPage.openPage().
                loginWithoutRedirect("", "").
                checkErrorMessage("There is 1 error\n" +
                        "An email address required.")
                .isPageOpened();
    }

    @Description("CHECK FOR ERRORS WITH EMPTY PASSWORD")
    @Test(retryAnalyzer = Retry.class)
    public void emptyPassword() {
        loginPage.openPage().
                loginWithoutRedirect("testponch@mail.ru", "")
                .checkErrorMessage("There is 1 error\n" +
                        "Password is required.")
                .isPageOpened();
    }
}


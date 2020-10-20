package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage extends BasePage {
    public static final By EMAIL_INPUT = By.id("email");
    public static final By PASSWORD_INPUT = By.id("passwd");
    public static final By LOGIN_BUTTON = By.id("SubmitLogin");
    public static final By ERROR_LABEL = By.cssSelector(".alert.alert-danger");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage isPageOpened() {
        Assert.assertTrue(driver.findElement(LOGIN_BUTTON).isDisplayed());
        return this;
    }

    public LoginPage openPage() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        isPageOpened();
        return this;
    }

    public MyAccountPage loginPositive(String username, String password) {
        loginWithoutRedirect(username, password);
        return new MyAccountPage(driver);
    }
    public LoginPage loginWithoutRedirect(String username, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    public LoginPage checkErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(driver.findElement(ERROR_LABEL).getText(), expectedErrorMessage);
        return this;
    }
}

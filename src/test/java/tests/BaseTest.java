package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    CartPage cartPage;
    ProductPage productPage;

    @BeforeMethod
    public void setBrowser(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if(driver != null)
            driver.quit();
    }
}

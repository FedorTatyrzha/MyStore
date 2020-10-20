package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    @BeforeMethod
    public void setBrowser(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() { driver.quit(); }
}

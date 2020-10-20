package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage isPageOpened() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".account")).isDisplayed());
        return this;
    }
}
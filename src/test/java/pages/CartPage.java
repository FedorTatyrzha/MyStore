package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static pages.ProductPage.WOMENCLOTHES;

public class CartPage extends BasePage {
    public static final By WOMEN_CLOTHES = By.linkText("http://automationpractice.com/index.php?id_category=3&controller=category");
    public static final By DRESSES = By.linkText("http://automationpractice.com/index.php?id_category=8&controller=category");
    public static final By T_SHORTS = By.linkText("http://automationpractice.com/index.php?id_category=5&controller=category");
    public static final By PROCECEED_TO_CHEKOUT = By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium");
    public static final By ADD_PRODUCT = By.cssSelector(".icon-plus");
    public static final By MINUS_PRODUCT = By.cssSelector(".icon-minus");
    public static final By DELETE_PRODUCT = By.cssSelector(".icon-trash");
    public static final By ERROR_MESSAGE = By.cssSelector(".fancybox-error");
    public static final By CONTINUE_SHOPPING = By.cssSelector(".button-exclusive.btn.btn-default");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage isPageOpened() {
        Assert.assertTrue(driver.findElement(By.xpath("span/class[text()='Your shopping cart']")).isDisplayed());
        return this;
    }

    public CartPage openPage() {
        driver.get("http://automationpractice.com/index.php?controller=order");
        isPageOpened();
        return this;
    }

    public CartPage openWomenClothes() {
        driver.findElement(WOMEN_CLOTHES).click();
        return this;
    }

    public CartPage openDressesClothes() {
        driver.findElement(DRESSES).click();
        return this;
    }

    public CartPage openTshirts() {
        driver.findElement(T_SHORTS).click();
        return this;
    }

    public CartPage proceedToCheckout() {
        driver.findElement(PROCECEED_TO_CHEKOUT).click();
        return this;
    }

    public CartPage addProduct() {
        driver.findElement(ADD_PRODUCT).click();
        return this;
    }

    public CartPage minusProduct() {
        driver.findElement(MINUS_PRODUCT).click();
        return this;
    }

    public CartPage deleteProduct() {
        driver.findElement(DELETE_PRODUCT).click();
        return this;
    }

    public CartPage checkBoxClick() {
        driver.findElement(By.id("cgv")).click();
        return this;
    }

    public CartPage continueButtonClick() {
        driver.findElement(CONTINUE_SHOPPING).click();
        return this;
    }


    public CartPage checkErrorMessage(String errorMessage) {
        Assert.assertEquals(driver.findElement(ERROR_MESSAGE).getText(), errorMessage);
        return this;
    }

    public CartPage closeErrorMessage() {
        driver.findElement(By.cssSelector(".fancybox-item.fancybox-close")).click();
        List<WebElement> errors = driver.findElements(By.cssSelector(".fancybox-error"));
        Assert.assertEquals(errors.size(), 0);
        return this;
    }

    private CartPage clickElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return this;
    }

    public CartPage checkout() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")).isDisplayed());
        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']")).isDisplayed());
        driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium")).click();
        driver.findElement(By.cssSelector(".bankwire")).click();
        driver.findElement(By.cssSelector("button[class='button btn btn-default button-medium']")).click();
        driver.findElement(By.xpath("//strong[text() = 'Your order on My Store is complete.']"));
        return this;

    }

    public CartPage cartIsEmpty() {
        driver.findElement(By.xpath("//p[text() = 'Your shopping cart is empty.']"));
        return this;

    }
}
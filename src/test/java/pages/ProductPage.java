package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;

public class ProductPage extends BasePage {
    public static final By WOMENCLOTHES = By.cssSelector(".sf-with-ul");
    public static final By DRESSES = By.linkText("http://automationpractice.com/index.php?id_category=8&controller=category");
    public static final By TSHORTS = By.linkText("http://automationpractice.com/index.php?id_category=5&controller=category");
    public static final By SEARCHINPUT = By.id("search_query_top");
    public static final By SEARCHBUTTON = By.cssSelector(".btn.btn-default.button-search");
    public static final By SORT_SELECT = By.cssSelector(".selectProductSort.form-control");
    By addProductLocator = By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default");
    By checkItemIntoCart = By.cssSelector(".product-name");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage isPageOpened() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".homefeatured")).isDisplayed());
        return this;
    }

    public ProductPage cartIsOpened() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[text() = 'Your shopping cart']")).isDisplayed());
        return this;
    }

    public ProductPage openPage() {
        driver.get("http://automationpractice.com/index.php");
        isPageOpened();
        return this;
    }

    public ProductPage openWomenClothes() {
        driver.findElement(WOMENCLOTHES).click();
        return this;
    }

    public ProductPage openDressesClothes() {
        driver.findElement(DRESSES).click();
        return this;
    }

    public ProductPage openTshirts() {
        driver.findElement(TSHORTS).click();
        return this;
    }

    public CartPage toCart() {
        driver.get("http://automationpractice.com/index.php?controller=order");
        cartIsOpened();
        return new CartPage(driver);

    }

    public ProductPage addProduct() {
        driver.findElement(By.cssSelector(".ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line")).click();
        driver.findElement((addProductLocator)).click();
        driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium")).click();
        return this;

    }

    public ProductPage checkCart(int expectedItems) {
        List allProductInCart = driver.findElements(By.cssSelector(".ajax_cart_quantity"));
        Assert.assertEquals(allProductInCart.size(), expectedItems);
        driver.get("http://automationpractice.com/index.php?controller=order");
        return this;
    }

    public ProductPage checkCartt(int expectedItems) {
        List allProductInCart = driver.findElements(By.cssSelector(".ajax_cart_quantity.unvisible"));
        Assert.assertEquals(allProductInCart.size(), expectedItems);
        driver.get("http://automationpractice.com/index.php?controller=order");
        return this;
    }


    public ProductPage checkCartByName(String itemName) {
        Assert.assertTrue(driver.findElement(By.xpath(String.format(itemName, checkItemIntoCart))).isDisplayed());
        toCart();
        return this;
    }

    public ProductPage sortBy(String sortByTo) {
        driver.findElement(SORT_SELECT);
        Select select = new Select(driver.findElement(SORT_SELECT));
        select.selectByVisibleText(sortByTo);
        return this;
    }

    public ProductPage checkPrice(String expectedPrice) {
        driver.findElement(By.cssSelector("li[class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']")).click();
        List<WebElement> allPrices = driver.findElements(By.cssSelector("span[id='our_price_display']"));
        Assert.assertEquals(allPrices, expectedPrice);
        return this;
    }

    public ProductPage searchItems() {
        openPage();
        driver.findElement(SEARCHINPUT).sendKeys("DRESSES");
        driver.findElement(SEARCHBUTTON).click();
        return this;
    }
}


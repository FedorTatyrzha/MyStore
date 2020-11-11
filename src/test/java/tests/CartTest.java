package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {
    @Description("ПРОВЕРКА ЧТО ТОВАР ДОБАВЛСЯЕТСЯ В КОРЗИНУ")
    @Test
    public void itemShouldBeAddedIntoCart() {
        loginPage.openPage().
                loginPositive("testponch@mail.ru", "123456789test");
        productPage.openWomenClothes().
                addProduct().
                checkCart(2);


    }

    @Description("Совершение покупки товара")
    @Test
    public void buyItems() {
        loginPage.openPage().
                loginPositive("testponch@mail.ru", "123456789test");
        productPage.openWomenClothes().
                addProduct();
        cartPage.checkout();


    }

    @Description("Удаление товара из корзины")
    @Test
    public void removeItemsFromCart() {
        loginPage.openPage().
                loginPositive("testponch@mail.ru", "123456789test");
        productPage.openWomenClothes().
                addProduct();
        cartPage.deleteProduct();

    }

    @Description("Добавление одной единицы товара в корзине")
    @Test
    public void addItemInCart() {
        loginPage.openPage().
                loginPositive("testponch@mail.ru", "123456789test");
        productPage.openWomenClothes().
                addProduct();
        cartPage.addProduct();
        productPage.checkCart(2);


    }
    @Description("Удаление товара из корзины")
    @Test
    public void  minusItemInCart(){
        loginPage.openPage().
                loginPositive("testponch@mail.ru", "123456789test");
        productPage.openWomenClothes().
                addProduct();
        cartPage.minusProduct()
        .cartIsEmpty();

}}

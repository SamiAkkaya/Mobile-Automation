package test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ItemAddBasketTest extends TestBase {

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        super.setUp();
        loginPage.login("hello@getir.com", "hello");
    }

    @BeforeTest
    public void twoItemAddBasket() throws InterruptedException {
        selectCategory("Kişisel Bakım");
        basePage.navigateUp();
        selectCategory("Ev Bakımı");
        basePage.navigateUp();
        basketPage.goBasket();
        basketPage.checkNumberOfItemInBasket();
    }

    @Test
    public void deleteItem() throws InterruptedException {
        basketPage.deleteAllItem();
        basketPage.checkEmptyBasket();
    }

    private void selectCategory(String category) {
        categoriesPage.selectCategories(category);
        categoriesPage.selectFirstItem();
    }


}

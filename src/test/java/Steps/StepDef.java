package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import test.TestBase;

public class StepDef extends TestBase {
    @BeforeSuite
    @Given("^uygulamaya giris yapilir$")
    public void uygulamayaGirisYapilir() throws Throwable {
        super.setUp();
        loginPage.login("hello@getir.com", "hello");
    }

    @Test(priority = 1)
    @When("^kisisel bakim ve ev bakimi kategorisinden ilk urunler sepete eklenir$")
    public void kisiselBakimVeEvBakimiKategorisindenIlkUrunlerSepeteEklenir() throws Throwable {
        selectCategory("Kişisel Bakım");
        basePage.navigateUp();
        selectCategory("Ev Bakımı");
        basePage.navigateUp();

    }

    @Test(priority = 2)
    @And("^sepete gidilir sepette iki urun oldugu dogrulanir$")
    public void sepeteGidilirSepetteIkiUrunOlduguDogrulanir() throws Throwable {
        basketPage.goBasket();
        basketPage.checkNumberOfItemInBasket();
    }

    @Test(priority = 3)
    @And("^sepette ki urunler silinir$")
    public void sepetteKiUrunlerSilinir() throws Throwable {
        basketPage.deleteAllItem();
    }

    @Test(priority = 4)
    @Then("^sepetin bos oldugu dogrulanir$")
    public void sepetinBosOlduguDogrulanir() throws Throwable {
        basketPage.checkEmptyBasket();
    }

    private void selectCategory(String category) {
        categoriesPage.selectCategories(category);
        categoriesPage.selectFirstItem();
    }
}

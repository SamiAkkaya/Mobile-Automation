package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BasketPage {
    private final AndroidDriver<MobileElement> driver;
    private final WebDriverWait wait;
    List<MobileElement> totalLinks;

    public BasketPage(final AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 35);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void goBasket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.getir.getirtestingcasestudy:id/basket"))).click();
    }

    public void checkNumberOfItemInBasket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout")));
        totalLinks = (List<MobileElement>)driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout"));
        Assert.assertEquals(totalLinks.size(), 2);
    }

    public void deleteAllItem() {
        for (int i = 0; i < totalLinks.size(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView"))).click();
        }
    }
    public void checkEmptyBasket() {
        String emptyText = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.getir.getirtestingcasestudy:id/empty_textview"))).getText();
        Assert.assertEquals(emptyText, "Your card is empty!");
    }

}

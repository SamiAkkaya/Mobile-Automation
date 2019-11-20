package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;

public class BasePage {
    private final AndroidDriver<MobileElement> driver;
    private final WebDriverWait wait;


    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 35);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void navigateUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"))).click();

    }


}

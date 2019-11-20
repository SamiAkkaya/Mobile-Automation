package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final AndroidDriver<MobileElement> driver;
    private final WebDriverWait wait;

    public LoginPage(final AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 35);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "com.getir.getirtestingcasestudy:id/email")
    private WebElement userNameField;

    @FindBy(id = "com.getir.getirtestingcasestudy:id/password")
    private WebElement passField;

    @FindBy(id = "com.getir.getirtestingcasestudy:id/email_sign_in_button")
    private WebElement submitButton;


    public void login(String userName, String pass) {
        wait.until(ExpectedConditions.visibilityOf(userNameField)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passField)).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
    }

}

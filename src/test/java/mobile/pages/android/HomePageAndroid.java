package mobile.pages.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import mobile.base.BasePage;
import org.openqa.selenium.WebElement;

public class HomePageAndroid extends BasePage {

    // locator android e özel bir locator, AppiumBy AndroidDriver kullaniyor
    private final String loginBtnXPATH = "//android.widget.Button(@content-type = 'Login')";

    public HomePageAndroid(AndroidDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
        WebElement element = driver.findElement(AppiumBy.xpath(loginBtnXPATH));
        element.click();
    }
}

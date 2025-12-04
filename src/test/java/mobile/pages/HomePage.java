package mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import mobile.base.BasePage;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final String loginBtnXPATH = "//android.widget.Button(@content-type = 'Login')";
    private final String loginBtn = "//XCUIElementTypeButton[@name='Login']";

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
        WebElement element = driver.findElement(AppiumBy.xpath(loginBtnXPATH));
        element.click();
    }

}

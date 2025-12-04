package mobile.pages.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import mobile.base.BasePage;
import org.openqa.selenium.WebElement;

public class HomePageIOS extends BasePage {

    // bu localtor ios e özel bir locator, bu yüzden AppiumBy IOSDriver kullaniyor
    private final String loginBtnXPATH = "//XCUIElementTypeButton[@name='Login']";

    public HomePageIOS(IOSDriver driver) {
        super(driver);
    }

    public void clickLoginBtn() {
        WebElement element = driver.findElement(AppiumBy.xpath(loginBtnXPATH));
        element.click();
    }
}

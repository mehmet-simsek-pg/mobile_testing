package mobile.base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected AppiumDriver driver;

    // AppiumDriver -> AndroidDriver ve IOSDriver in parent class i.
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void sendText(WebElement element, String text) {
        element.sendKeys(text);
    }
}

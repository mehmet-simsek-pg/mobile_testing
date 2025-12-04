package mobile.tests;

import mobile.enums.PlatformType;
import mobile.factory.DriverFactory;
import mobile.pages.android.HomePageAndroid;
import mobile.pages.ios.HomePageIOS;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest() {
        if (DriverFactory.getCurrentPlatform() == PlatformType.ANDROID) {
            new HomePageAndroid(androidDriver).clickLoginBtn();
        } else {
            new HomePageIOS(iosDriver).clickLoginBtn();
        }
    }
}

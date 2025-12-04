package mobile.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import mobile.enums.PlatformType;
import mobile.factory.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BaseTest {

    protected AndroidDriver androidDriver;
    protected IOSDriver iosDriver;

    @Parameters("platform")
    @BeforeMethod
    public void setup(@Optional("ANDROID") String platform) throws MalformedURLException, URISyntaxException {
        // xml kullanmadan testi calistirmak istersem default platform olarak Android i verdik.
        PlatformType platformType = PlatformType.valueOf(platform);

        DriverFactory.initDriver(platformType);

        if (platformType == PlatformType.ANDROID) {
            androidDriver = (AndroidDriver) DriverFactory.getDriver();
        } else {
            iosDriver = (IOSDriver) DriverFactory.getDriver();
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

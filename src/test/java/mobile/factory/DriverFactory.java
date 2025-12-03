package mobile.factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import mobile.enums.PlatformType;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class DriverFactory {

    // Paralel calistirma icin bu sekilde driver olusturduk
    private static final ThreadLocal<Object> driver = new ThreadLocal<>();

    // xml dosyasindan playtform type okuyacak ona göre android ya da ios driveri calistiracak
    private static PlatformType currentPlatform;

    private DriverFactory() {} // DriverFactory constructor i baska bir yerden new yapilmasin diye private yaptik.

    public static void initDriver(PlatformType platformType) throws MalformedURLException, URISyntaxException {

        if (driver.get() != null) {
            return;
        }

        currentPlatform = platformType;
        // xml dosyasindan platform type okunacak. Ona göre de driver kurulacak.
        switch (currentPlatform) {
            case ANDROID -> initAndroid();
            case IOS -> initIOS();
        }
    }

    private static void initAndroid() throws URISyntaxException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options(); // Android icin kullanilan driver options
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");
        options.setAppPackage("com.wdiodemoapp");
        options.setAppActivity("com.wdiodemoapp.MainActivity");

        AndroidDriver androidDriver = new AndroidDriver(
                new URI("http://127.0.0.1:4723").toURL(),
                options);

        driver.set(androidDriver);
    }

    private static void initIOS() throws URISyntaxException, MalformedURLException {

        XCUITestOptions options = new XCUITestOptions(); // IOS icin kullanilan driver options
        options.setPlatformName("IOS");
        options.setAutomationName("XCUITest");
        options.setDeviceName("iPhone 15");
        options.setBundleId("com.wdiodemoapp.ios"); // Örnek icin yazildi gercek bundle id bu degil

        IOSDriver iosDriver = new IOSDriver(
                new URI("http://127.0.0.1:4723").toURL(),
                options);

        driver.set(iosDriver);
    }

    public static Object getDriver() {
        return driver;
    }

    public static PlatformType getCurrentPlatform() {
        return currentPlatform;
    }

    public static void quitDriver() {

    }
}

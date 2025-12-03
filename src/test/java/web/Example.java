package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
    public static void main(String[] args) {

        // Bu satirda driver olusturduk
        WebDriver driver = new ChromeDriver();

        // bu satirda ise web uygulamasina giris yaptik
        driver.get("https://mvnrepository.com/");

    }
}

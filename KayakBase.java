package org.example.Kayak;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class KayakBase {
    protected static WebDriver driver;

    public KayakBase(WebDriver driver) {
        KayakBase.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void goTo() {
        driver.get("https://www.kayak.com");
    }

    protected void KayakBase() {
    }
}

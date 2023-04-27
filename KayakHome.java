package org.example.Kayak;

import org.example.Kayak.KayakBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KayakHome extends KayakBase {

    private static final By staysButton = By.cssSelector("a[aria-label='Search for hotels']");
    private static final By seeAllButton = By.xpath("/html/body/div[2]/div[1]/main/div[1]/div[1]/div/div[2]/div[1]/div/div/section[2]/div/header/div/div[2]/a");

    public KayakHome (WebDriver driver) {
         super (driver);
    }

    public static void stays() {
        WebDriverWait staysButtonWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement stay = staysButtonWait.until(ExpectedConditions.visibilityOfElementLocated(staysButton));
            stay.click();
//            Thread.sleep(5000); //bad practise as it can crash the site

        } catch (Exception e) {
            System.out.println("Stay button is not displayed.");
        }

        try {
            WebElement seeAll = staysButtonWait.until(ExpectedConditions.visibilityOfElementLocated(seeAllButton));
            seeAll.click();
        } catch (Exception e) {
            System.out.println("See All button is not displayed.");
        }

    }



    // System.setProperty("webdriver.chrome.driver", "/Users/gabriele.michne/Documents/chrm/chromedriver");


}

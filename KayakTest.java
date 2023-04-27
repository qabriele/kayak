package org.example.Kayak;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KayakTest extends KayakBase {

    private KayakHome kayakHome;

    public KayakTest() {
        super(driver);
    }

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/gabriele.michne/Documents/chrm/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        KayakBase.driver = new ChromeDriver(options);
        KayakBase.driver.manage().window().maximize();

    }

    @Test
    public void KayakStayTest(){
        KayakBase.goTo();
        KayakHome.stays();
    }

    @AfterClass
    public static void tearDown(){
//        driver.quit();
    }
    }

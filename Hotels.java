package org.example.Kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.example.Kayak.KayakHome.stays;

public class Hotels extends KayakBase {

    private DbConnection db;
    private final By hotels = By.cssSelector(".FLpo-hotel-name");

    public Hotels(WebDriver driver) {
        super(driver);
        db = new DbConnection();

    }

    public static void main (String[]args) throws SQLException {
        System.setProperty("webdriver.chrome.driver", "/Users/gabriele.michne/Documents/chrm/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        KayakBase.driver = new ChromeDriver(options);
        Hotels hotel1 = new Hotels(driver);
        KayakBase.goTo();
        KayakHome.stays();
        hotel1.KayakBase();
        hotel1.findHotels();
    }

    public void findHotels() {
//        WebElement stayBtn = driver.findElement(staysButton);
//        stayBtn.click();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);


        List<WebElement> hotelTitles = driver.findElements(hotels);

//        for (WebElement title : hotelTitles) {
//            String myTitle = title.getText();
//            System.out.println(myTitle);
//        }

        try {
            String sql = "INSERT INTO products(hotel_title) VALUES(?)";
            PreparedStatement pstmt = DbConnection.databaseConn(sql);

            for (WebElement title : hotelTitles) {
                assert false;
                pstmt.setString(1, title.getText());
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }


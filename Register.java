package org.example.Kayak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//public class Register {
//
//    private final WebDriver driver;
//
//    public Register(WebDriver driver) {
//        this.driver = driver;
//        driver.get("https://www.rde.lt/");
//    }
//
//    public void ieitiButton() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        try {
//            WebElement registerButton = driver.findElement(By.xpath("/html/body/header/div/div[2]/a[2]"));
//            wait.until(ExpectedConditions.elementToBeClickable(registerButton));
//            registerButton.click();
////        } catch (Exception e) {
////            System.out.println("Element not found." + e.getMessage());
////        }
//    }
//
//    public void Registruotis() {
//        WebElement register = driver.findElement(By.xpath("/html/body/header/div/div[2]/a[2]"));
//        register.click();
//
//    }
//}
//
//public class BrowserNotification{
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "/Users/gabriele.michne/Documents/chrm/chromedriver");
//        //ChromeOptions object
//        ChromeOptions op = new ChromeOptions();
//        //disable notification parameter
//        op.addArguments("--disable-notifications");
//        // configure options parameter to Chrome driver
//        WebDriver driver = new ChromeDriver(op);
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//        driver.get("https://www.redbus.in/");
//        driver.quit();
//    }
//}


public class Register {
    private WebDriver driver;
    public Register (WebDriver driver){
        this.driver = driver;
        driver.get("https://pigu.lt");
    }

    public void ieiti(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement atidarytiRegistracija = driver.findElement(By.xpath("/html/body/header/div/div[2]/a[2]"));
            wait.until(ExpectedConditions.elementToBeClickable(atidarytiRegistracija));
            atidarytiRegistracija.click();
        } catch (Exception e){
            System.out.println("Registration element not found " + e.getMessage());
        }
    }

    public class RegistrationMethods {

        private WebDriver driver;
        private final By registerButton = By.xpath("/html/body/header/div/div[2]/a[2]");
        private final By switchToLogin = By.xpath("//*[@id=\"auth-register-tab\"]");
        private final By emailFieldLocator = By.xpath("//*[@id=\"registrationEmail\"]");


        public void enterSite(WebDriver driver){
            this.driver = driver;
            driver.get("https://www.rde.lt/");
        }

        public void enterRegistrationPage(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement enterLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
            enterLogin.click();

            WebElement switchToRegistration = wait.until(ExpectedConditions.visibilityOfElementLocated(switchToLogin));
            switchToRegistration.click();
        }

        public void prefillRegInfo(String email, String password){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            //enter email once the input field is visible
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
            emailField.sendKeys(email);

            //enter password
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/form/div[1]/div[3]/div/input[2]")).sendKeys(password);

            //repeat password
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/form/div[1]/div[4]/div/input[2]")).sendKeys(password);

            //no marketing emails pls
            driver.findElement(By.xpath("//*[@id=\"auth-register-panel\"]/form/div[1]/div[5]/label/span[1]")).click();

            //submit form
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/form/div[1]/footer/button")).click();
        }
    }
}
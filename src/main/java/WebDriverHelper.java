import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ybalatc on 6/23/2017.
 */
public class WebDriverHelper {

    private static volatile WebDriver driver;


    public static WebDriver openBrowser(){
        driver = new ChromeDriver();
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        } else {
            System.out.println("Cant close session");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void printUrl() {
        System.out.println(driver.getCurrentUrl());
    }

//    public void waitUntilElementVisible(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 10, 250);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

    public static void waitForPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void waitForElement(WebElement element) throws NoSuchElementException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(css = "div[data-latest-bg]")
    private WebElement photo;

    public WebDriverHelper (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPhotoUrl() {
        waitForElement(photo);
        return photo.getAttribute("data-latest-bg");
    }
}

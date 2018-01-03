import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private static final String FIREFOX_WEBDRIVER = "webdriver.gecko.driver";
    private static final String WINDOWS_FIREFOX_WEBDRIVER_PATH = "src/main/resources/geckodriver.exe";
    private static volatile WebDriver driver;

    private static void setSystemProperties(){
        System.setProperty(FIREFOX_WEBDRIVER, WINDOWS_FIREFOX_WEBDRIVER_PATH);
    }

    public static WebDriver openBrowser(){
        setSystemProperties();
        driver = new FirefoxDriver();
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
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.wait(2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(css = "div[data-latest-bg]")
    private WebElement photo;

    public WebDriverHelper (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPhotoUrl() {
        return photo.getAttribute("data-latest-bg");
    }
}

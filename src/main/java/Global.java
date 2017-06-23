import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ybalatc on 6/23/2017.
 */
public class Global {
    private static final String FIREFOX_WEBDRIVER = "webdriver.gecko.driver";

    private static final String WINDOWS_FIREFOX_WEBDRIVER_PATH = "src/main/resources/geckodriver.exe";

    private static volatile WebDriver driver;


    private static void setSystemProperties(){
        System.setProperty(FIREFOX_WEBDRIVER, WINDOWS_FIREFOX_WEBDRIVER_PATH);
    }

    public static void openBrowser(String links){
        setSystemProperties();
        driver = new FirefoxDriver();
        driver.get(links);
    }
    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        } else {
            System.out.println("Cant close session");
        }
    }

    public static void waitUntilElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 250);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
//    @FindBy(className = ".background-image: url")
//
    public static void findByCss() {
        WebElement button = driver.findElement(By.xpath("//*[contains(@class, 'background-image: url')]"));
        button.click();
    }
}

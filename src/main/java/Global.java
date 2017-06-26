import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ybalatc on 6/23/2017.
 */
public class Global implements PageInitializer {
    private static final String FIREFOX_WEBDRIVER = "webdriver.gecko.driver";

    private static final String WINDOWS_FIREFOX_WEBDRIVER_PATH = "src/main/resources/geckodriver.exe";

    protected static volatile WebDriver driver;


    private static void setSystemProperties(){
        System.setProperty(FIREFOX_WEBDRIVER, WINDOWS_FIREFOX_WEBDRIVER_PATH);
    }

    public void pageInitialization(){
        PageFactory.initElements(driver, this);
    }

    public static WebDriver openBrowser(){
        setSystemProperties();
        driver = new FirefoxDriver();
//        driver.get(links);
//        PageFactory.initElements(driver, BaseUrl);
//        PageFactory.initElements(driver, links);
//        pageInitialization();
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

//    public static void printUrl() {
//        System.out.println(driver.getCurrentUrl());
//    }

    public void waitUntilElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 250);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10, 250);
        wait.wait(5);
    }

//	@FindBy(css = "a[href='/share/AF1QipPDd8WcssesV0ovkIw71agOl3Y8USnu6P5qF-eKIze4wNOqsoMDCsJ6vrr5BFVkhQ/photo/AF1QipMbWqpXGFMznXM_CeiWkLNq4AfS_mdhgJId7NZc?key=eC1RT0sxM1hEUFFpeHZmWldwckxiWlA5czlXeC1n']")
//	protected static WebElement photo;
////    @FindBy(css="")
////    private WebElement photo;
//
//
//    public static void findByCss() {
////        WebElement button = driver.findElement(By.xpath("//*[contains('background-image: url')]"));
////        WebElement button = driver.findElement(By.cssSelector('a[href*="example"]'));
////        WebElement button = driver.findElement(By.partialLinkText("./share/"));
////        WebElement button = driver.findElement(By.partialLinkText("https://lh3.googleusercontent.com"));
////        WebElement button = driver.findElement(By.xpath(".//*[text()='background-image: url']/.."));
////        WebElement button = driver.findElement(By.xpath("//a[contains(text(),'background-image: url')]"));
////        WebElement button = driver.findElement(By.partialLinkText("https://www.google.com.ua/intl/en/options/"));
////        WebElement element = driver.findElement(By.className("#element_id")));
//        WebElement photo = driver.findElement(By.id("ow58"));
//        photo.click();
//        return;
//    }
}

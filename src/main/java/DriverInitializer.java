import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ybalatc on 6/22/2017.
 */
public class DriverInitializer {
    private DriverInitializer() {
    }

    private static final String FIREFOX_WEBDRIVER = "webdriver.gecko.driver";
    private static final String CHROME_WEBDRIVER = "webdriver.chrome.driver";

    private static final String WINDOWS_FIREFOX_WEBDRIVER_PATH = "src/main/resources/geckodriver.exe";

    private static final String WINDOWS_CHROME_WEBDRIVER_PATH = "src/main/resources/chromedriver.exe";

    private static volatile WebDriver driver;

    private static WebDriverWait wait = new WebDriverWait(DriverInitializer.instance(), 30, 250);

    /**
     * This is a method which is used for setting os properties according to Operation System
     */
//    private static void setSystemProperties() {
//        String os = System.getProperty("os.name");
//        switch (os) {
//            case "Windows 10":
//                System.setProperty(FIREFOX_WEBDRIVER, WINDOWS_FIREFOX_WEBDRIVER_PATH);
//                System.setProperty(CHROME_WEBDRIVER, WINDOWS_CHROME_WEBDRIVER_PATH);
//                break;
//        }
//    }
    private static void setSystemProperties() {
        System.setProperty(FIREFOX_WEBDRIVER, WINDOWS_FIREFOX_WEBDRIVER_PATH);
        System.setProperty(CHROME_WEBDRIVER, WINDOWS_CHROME_WEBDRIVER_PATH);
    }

    /**
     * This is a method main goal of which is to initialize web driver with proper browser, name of which
     * is passed from Maven CL. This method also set implicit wait for all framework
     */
    public static void initialization() {
        setSystemProperties();
        ProfilesIni profile = new ProfilesIni();
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        String browserType = System.getProperty("browser.name");
        System.out.println(browserType);

        if (browserType.equals("firefox")) {
            driver = new FirefoxDriver(dc);

        } else if (browserType.equals("chrome")) {
            driver = new ChromeDriver();

//            case "phantomjs":
//                ArrayList<String> cliArgsCap = new ArrayList<>();
//                DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
//                cliArgsCap.add("--web-security=false");
//                cliArgsCap.add("--ssl-protocol=any");
//                cliArgsCap.add("--ignore-ssl-errors=true");
//                capabilities.setCapability("takesScreenshot", true);
//                capabilities.setCapability(
//                        PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
//                capabilities.setCapability(
//                        PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS,
//                        new String[] { "--logLevel=2" });
//                driver = new PhantomJSDriver(capabilities);
//                driver.manage().window().setSize(new Dimension(1024,768));
//                break;
//            case "jBrowserDriver":
//                driver = new JBrowserDriver(Settings.builder().
//                        timezone(Timezone.EUROPE_KIEV)
//                        .ssl("trustanything")
//                        .javaOptions("-Djsse.enableSNIExtension=false")
//                        .hostnameVerification(false)
//                        .blockAds(false)
//                        .cache(true)
//                        .userAgent(UserAgent.TOR)
//                        .headless(true)
//                        .javascript(true).build());
//                break;
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * This  method  return instance of Web Driver. If it is a first call of method it create instance
     * of webdriver, otherwise in return already created instance. This method is synchronized.
     * @return
     */
    public static synchronized WebDriver instance() {
        if (driver == null) {
            initialization();
            return driver;
        }
        return driver;
    }

    /**
     * This is a method which provide ability of moving to given url
     *
     * @param url string representation of target page url
     */
    public static void getToUrl(String url) {
        instance().get(url);
    }

    /**
     * This is a method which is provide closing of browser after test execution
     */
    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        } else {
            System.out.println("Cant close session");
        }
    }

    /**
     *  This is method which is used for cleaning cookies after closing browser window
     */
    public static void deleteAllCookies() {
        instance().manage().deleteAllCookies();
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void waitForPage(Long time) {
        DriverInitializer.instance().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public static void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

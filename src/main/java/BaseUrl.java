import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by ybalatc on 6/26/2017.
 */
public class BaseUrl extends Global {
//    @FindBy(css = "a[href='/share/AF1QipPDd8WcssesV0ovkIw71agOl3Y8USnu6P5qF-eKIze4wNOqsoMDCsJ6vrr5BFVkhQ/photo/AF1QipMbWqpXGFMznXM_CeiWkLNq4AfS_mdhgJId7NZc?key=eC1RT0sxM1hEUFFpeHZmWldwckxiWlA5czlXeC1n']")
//    @FindBy(className="rtIMgb fCPuz")
//     static WebElement photo;


//    @FindBy(className = "p137Zd")
    @FindBy(className = "rtIMgb fCPuz")
    private static WebElement photo;

//    @FindBy(css="")
//    private WebElement photo;


    public static BaseUrl findByCss() throws InterruptedException {
//        WebElement button = driver.findElement(By.xpath("//*[contains('background-image: url')]"));
//        WebElement button = driver.findElement(By.cssSelector('a[href*="example"]'));
//        WebElement button = driver.findElement(By.partialLinkText("./share/"));
        WebElement button = driver.findElement(By.partialLinkText("https://lh3.googleusercontent.com"));
//        WebElement button = driver.findElement(By.xpath(".//*[text()='background-image: url']/.."));
//        WebElement button = driver.findElement(By.xpath("//a[contains(text(),'background-image: url')]"));
//        WebElement button = driver.findElement(By.partialLinkText("https://www.google.com.ua/intl/en/options/"));
//        WebElement element = driver.findElement(By.className("#element_id")));
//        WebElement photo = driver.findElement(By.id("ow58"));
        button.click();
//        photo.click();
        waitForPage();
        return new BaseUrl(driver, );
    }

    public BaseUrl (WebDriver driver, String links) {
        driver.get(links);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ybalatc on 6/26/2017.
 */
public class BaseUrl extends WebDriverHelper {

    @FindBy(css = "div[data-latest-bg]")
    private WebElement photo;

    public BaseUrl (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPhotoUrl() {
        return photo.getAttribute("data-latest-bg");
    }
}

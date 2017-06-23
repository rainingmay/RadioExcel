import org.openqa.selenium.support.PageFactory;

/**
 * Created by ybalatc on 6/22/2017.
 */
public class PageInitializer {
    public void pageInitialization(){
        PageFactory.initElements(Global.driver, Global.class);
    }
}

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ybalatc on 6/22/2017.
 */
public class Main {
    public Properties properties;

    public static void main(String[] args) throws IOException, InterruptedException {
        FileInputStream in = new FileInputStream("трансформация в сайт_190617.xls");
        HSSFWorkbook wb = new HSSFWorkbook(in);
        Sheet sheet1 = wb.getSheetAt(1);
        WebDriverHelper.openBrowser();
        BaseUrl baseUrl = new BaseUrl(WebDriverHelper.getDriver());
        for (Row row : sheet1) {
            for (Cell cell : row) {
                Hyperlink link = cell.getHyperlink();
                if (link != null) {
                    System.out.println(link.getAddress());
                    WebDriverHelper.getDriver().get(link.getAddress());
                    System.out.println(baseUrl.getPhotoUrl());
                }
            }
        }
        WebDriverHelper.close();
    }
}

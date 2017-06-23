import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ybalatc on 6/22/2017.
 */
public class Main {
    public static Properties properties;

   public static void main(String... args) throws IOException {
//        System.out.println(ReadingParser.parse("трансформация в сайт_190617.xls"));
//        ReadingParser2.parse2();
//        ReadingParser2.readingSheet(super, fo);
       FileInputStream in = new FileInputStream("трансформация в сайт_190617.xls");
       HSSFWorkbook wb = new HSSFWorkbook(in);
       DataFormatter formatter = new DataFormatter();
       Sheet sheet1 = wb.getSheetAt(1);
        for (Row row : sheet1) {
            for (Cell cell : row) {
                Hyperlink link = cell.getHyperlink();
                if (link != null) {
                    System.out.println(link.getAddress());
                    Global.openBrowser(link.getAddress().toString());
                    Global.findByCss();
//                    Global.findByCss(Global.element);
//                    DriverInitializer.getToUrl(link.getAddress().toString());
                }
            }
        }
    }
}

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
//        ExcelHelper.readBook();
//        ExcelHelper.createBookAndSheet();
        ExcelHelper.readAndWrite();
    }
}

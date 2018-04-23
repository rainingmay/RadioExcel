import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.FileInputStream;


public class MainTest {

    @Test
    public void verifyExcel() throws Exception {

        Workbook wbOut;
        Sheet sheetOut2, sheetIn1;
        FileInputStream in, out;
        HSSFWorkbook wbIn;
        String inputFile = "ВсеНовПоступл на ..10.xls";
        String outputFile = "трансформация в сайт.xls";

        in = new FileInputStream(inputFile);
        wbIn = new HSSFWorkbook(in);
        sheetIn1 = wbIn.getSheetAt(0);

        out = new FileInputStream(outputFile);
        wbOut = new HSSFWorkbook(out);
        sheetOut2 = wbOut.getSheetAt(1);

        int rowNumIn = sheetIn1.getPhysicalNumberOfRows();
        int rowNumOut = sheetOut2.getPhysicalNumberOfRows();
            if (rowNumIn == rowNumOut) {
            System.out.println("Number of rows is equal");
        }
        Assert.assertEquals(rowNumIn, rowNumOut, "Number of rows is not equal: expected: " + rowNumIn +
                ", but found: " + rowNumOut);
        int rowIn = (int) sheetIn1.getRow(1).getCell(11).getNumericCellValue();
        int rowOut = (int) sheetOut2.getRow(1).getCell(3).getNumericCellValue();

        Assert.assertEquals(rowIn, rowOut, "Codes at 1st row isn't equal: expected: " + rowIn + ", but found: " +
                rowOut);
    }
}

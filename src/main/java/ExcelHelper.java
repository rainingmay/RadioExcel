import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ybalatc on 7/11/2017.
 */
public class ExcelHelper {
    int sheetIndex;
    int rowIndex;
    static int colIndex = 0;


    public static void createBookAndSheet() throws IOException {
        Workbook wbOut = new HSSFWorkbook();
        Sheet sheetOut1 = wbOut.createSheet("new sheet");
        Row row1 = sheetOut1.createRow((short) 0);
//        while (colIndex <= 16) {
//            Cell cell = row1.createCell(colIndex);
        Cell cell = row1.createCell(0);
            cell.setCellValue("Категория товаров");
//        }
        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        wbOut.write(fileOut);
        fileOut.close();
    }

    public static void readAndWrite() throws IOException {

        FileInputStream in = new FileInputStream("ВсеНовПоступл на ..10_.xls");
        HSSFWorkbook wbIn = new HSSFWorkbook(in);
        Sheet sheetIn1 = wbIn.getSheetAt(0);
        String result = sheetIn1.getRow(1).getCell(0).getStringCellValue();


        Workbook wbOut = new HSSFWorkbook();
        Sheet sheetOut1 = wbOut.createSheet("new sheet");
        Row row1 = sheetOut1.createRow((short) 0);
        Cell cellOut = row1.createCell(0);
        cellOut.setCellValue(result);
        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        wbOut.write(fileOut);
        wbIn.close();
        fileOut.close();
    }



    public static void readBook() throws IOException, InterruptedException {
        FileInputStream in = new FileInputStream("ВсеНовПоступл на ..10_.xls");
        HSSFWorkbook wbIn = new HSSFWorkbook(in);
        Sheet sheetIn1 = wbIn.getSheetAt(0);
        WebDriverHelper.openBrowser();
        WebDriverHelper baseUrl = new WebDriverHelper(WebDriverHelper.getDriver());
        for (Row row : sheetIn1) { // For each Row.
            for (int cellIndex = 6; cellIndex <= 10; cellIndex++) {
                Cell cell = row.getCell(cellIndex); // Get the Cell at the Index / Colum you want.
                Hyperlink link = cell.getHyperlink();
                        if (link != null) {
//                            System.out.println(link.getAddress());
//                            String result = cell.getStringCellValue();
//                            System.out.println(result);
//                    cell.setCellValue(link.getAddress());
                            WebDriverHelper.getDriver().get(link.getAddress());
                            WebDriverHelper.waitForPage();
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            System.out.println(baseUrl.getPhotoUrl());
                            cell.setCellValue(baseUrl.getPhotoUrl());
                            cell.setCellValue(baseUrl.getPhotoUrl());
//                    cell.setCellValue(baseUrl.getPhotoUrl());
                        } else {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            cell.setCellValue("");
                        }
            }
        }
        wbIn.close();
        WebDriverHelper.close();
    }


    public static void readAndReWriteHyperlink() throws IOException, InterruptedException {
        FileInputStream in = new FileInputStream("ВсеНовПоступл на ..10_.xls");
        HSSFWorkbook wbIn = new HSSFWorkbook(in);
        Sheet sheetIn1 = wbIn.getSheetAt(0);
        WebDriverHelper.openBrowser();
        WebDriverHelper baseUrl = new WebDriverHelper(WebDriverHelper.getDriver());
        for (Row row : sheetIn1) {
            for (Cell cell : row) {
                Hyperlink link = cell.getHyperlink();
                if (link != null) {
                    System.out.println(link.getAddress());
//                    cell.setCellValue(link.getAddress());
                    WebDriverHelper.getDriver().get(link.getAddress());
                    WebDriverHelper.waitForPage();
                    System.out.println(baseUrl.getPhotoUrl());
//                    cell.setCellValue(baseUrl.getPhotoUrl());
                } else {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue("");
                }
            }
        }
//        String result = wbIn.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
//        System.out.println(result);
        wbIn.close();
        WebDriverHelper.close();
    }
}

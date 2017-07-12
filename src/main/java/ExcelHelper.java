import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ybalatc on 7/11/2017.
 */
public class ExcelHelper {
    private static Workbook wbOut;
    private static Sheet sheetOut1;
    private static Row row0, row1, row2, row4, row5, row6, row7, row8, row9, row10;

    private static Cell cell0Category, cell1Group, cell2KeyWords, cell3Code, cell4Name, cell5Price, cell6OptNumber,
            cell7OptPrice, cell8Year, cell9Note, cell10Package, cell11Producer, cell12Photo, cell13Photo, cell14Photo,
            cell15Photo, cell16Photo, categoryField11Out;
    static FileOutputStream fileOut;
    int sheetIndex;
    int rowIndex;
    static int colIndex = 0;

    public ExcelHelper() throws FileNotFoundException {
    }


    public static void createBookAndSheet() throws IOException {
        wbOut = new HSSFWorkbook();
        sheetOut1 = wbOut.createSheet("готово");
        row0 = sheetOut1.createRow((short) 0);
        row1 = sheetOut1.createRow((short) 1);
        row2 = sheetOut1.createRow((short) 2);
        row4 = sheetOut1.createRow((short) 3);
        row4 = sheetOut1.createRow((short) 4);
        row5 = sheetOut1.createRow((short) 5);
        row6 = sheetOut1.createRow((short) 6);
        row7 = sheetOut1.createRow((short) 7);
        row7 = sheetOut1.createRow((short) 8);
        row9 = sheetOut1.createRow((short) 9);
        cell0Category = row0.createCell(0);
        cell0Category.setCellValue("Категория товаров");
        cell1Group = row0.createCell(1);
        cell1Group.setCellValue("Группа товаров");
        cell2KeyWords = row0.createCell(2);
        cell2KeyWords.setCellValue("Ключевые слова");
        cell3Code = row0.createCell(3);
        cell3Code.setCellValue("Код");
        cell4Name = row0.createCell(4);
        cell4Name.setCellValue("Наименование");
        cell5Price = row0.createCell(5);
        cell5Price.setCellValue("ЦенаГрн");
        cell6OptNumber = row0.createCell(6);
        cell6OptNumber.setCellValue("ОптомОт");
        cell7OptPrice = row0.createCell(7);
        cell7OptPrice.setCellValue("ОптЦгрн");
        cell8Year = row0.createCell(8);
        cell8Year.setCellValue("Год");
        cell9Note = row0.createCell(9);
        cell9Note.setCellValue("Примечание");
        cell10Package = row0.createCell(10);
        cell10Package.setCellValue("Упаковка");
        cell11Producer = row0.createCell(11);
        cell11Producer.setCellValue("Изготовитель");
        cell12Photo = row0.createCell(12);
        cell12Photo.setCellValue("Фото");
        cell13Photo = row0.createCell(13);
        cell13Photo.setCellValue("Фото");
        cell14Photo = row0.createCell(14);
        cell14Photo.setCellValue("Фото");
        cell15Photo = row0.createCell(15);
        cell15Photo.setCellValue("Фото");
        cell16Photo = row0.createCell(16);
        cell16Photo.setCellValue("Фото");
        fileOut = new FileOutputStream("workbook.xls");
//        wbOut.write(fileOut);
    }

    public static void readAndWrite() throws IOException, InterruptedException {
        createBookAndSheet();
        FileInputStream in = new FileInputStream("ВсеНовПоступл на ..10_.xls");
        HSSFWorkbook wbIn = new HSSFWorkbook(in);
        Sheet sheetIn2 = wbIn.getSheetAt(0);
        String cellIn0Category = sheetIn2.getRow(1).getCell(0).getStringCellValue();
        String cellIn1Group = sheetIn2.getRow(1).getCell(1).getStringCellValue();
        String cellIn2Name = sheetIn2.getRow(1).getCell(2).getStringCellValue();
        int cellIn11Code = Integer.valueOf((int) sheetIn2.getRow(1).getCell(11).getNumericCellValue());
        int cellIn12Price = (int) Math.round(sheetIn2.getRow(1).getCell(12).getNumericCellValue());
        int cellIn13OptNumber = Integer.valueOf((int) sheetIn2.getRow(1).getCell(13).getNumericCellValue());
        int cellIn14OptPrice = Integer.valueOf((int) sheetIn2.getRow(1).getCell(14).getNumericCellValue());
        String cellIn4Year = sheetIn2.getRow(1).getCell(4).getStringCellValue();
        String cellIn3Note = sheetIn2.getRow(1).getCell(3).getStringCellValue();
        String cellIn5Package = sheetIn2.getRow(1).getCell(5).getStringCellValue();

        // to fix hyperlinks
        String cellIn6Photo = sheetIn2.getRow(1).getCell(6).getStringCellValue();
        String cellIn7Photo = sheetIn2.getRow(1).getCell(7).getStringCellValue();
        String cellIn8Photo = sheetIn2.getRow(1).getCell(8).getStringCellValue();
        String cellIn9Photo = sheetIn2.getRow(1).getCell(9).getStringCellValue();
        String cellIn10Photo = sheetIn2.getRow(1).getCell(10).getStringCellValue();
//

        cell0Category = row1.createCell(0);
        cell0Category.setCellValue(cellIn0Category);
        cell1Group = row1.createCell(1);
        cell1Group.setCellValue(cellIn1Group);
        cell2KeyWords = row1.createCell(2);
        cell2KeyWords.setCellValue(cellIn1Group);
        cell3Code = row1.createCell(3);
        cell3Code.setCellValue(cellIn11Code);
        cell4Name = row1.createCell(4);
        cell4Name.setCellValue(cellIn2Name);
        cell5Price = row1.createCell(5);
        cell5Price.setCellValue(cellIn12Price);
        cell6OptNumber = row1.createCell(6);
        cell6OptNumber.setCellValue(cellIn13OptNumber);
        cell7OptPrice = row1.createCell(7);
        cell7OptPrice.setCellValue(cellIn14OptPrice);
        cell8Year = row1.createCell(8);
        cell8Year.setCellValue(cellIn4Year);
        cell9Note = row1.createCell(9);
        cell9Note.setCellValue(cellIn3Note);
        cell10Package = row1.createCell(10);
        cell10Package.setCellValue(cellIn5Package);


        cell12Photo = row1.createCell(12);
        cell12Photo.setCellValue(cellIn6Photo);
        cell13Photo = row1.createCell(13);
        cell12Photo.setCellValue(cellIn7Photo);
        cell14Photo = row1.createCell(14);
        cell12Photo.setCellValue(cellIn8Photo);
        cell15Photo = row1.createCell(15);
        cell12Photo.setCellValue(cellIn9Photo);
        cell16Photo = row1.createCell(16);
        cell12Photo.setCellValue(cellIn10Photo);



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

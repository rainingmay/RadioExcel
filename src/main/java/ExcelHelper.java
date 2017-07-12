import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ybalatc on 7/11/2017.
 */
public class ExcelHelper {
    private static Workbook wbOut;
    private static Sheet sheetOut1, sheetIn1;
    private static FileInputStream in;
    private static HSSFWorkbook wbIn;
    private static Row row0, row1;
    private static Cell cell0Category, cell1Group, cell2KeyWords, cell3Code, cell4Name, cell5Price, cell6OptNumber,
            cell7OptPrice, cell8Year, cell9Note, cell10Package, cell11Producer, cell12Photo, cell13Photo, cell14Photo,
            cell15Photo, cell16Photo;
    private static String cellIn0Category, cellIn1Group, cellIn2Name, cellIn4Year, cellIn3Note, cellIn5Package,
            cellIn6Photo_, cellIn7Photo_, cellIn8Photo_, cellIn9Photo_, cellIn10Photo_;
    private static int cellIn11Code, cellIn12Price, cellIn13OptNumber, cellIn14OptPrice;
    private static Cell cellIn6Photo, cellIn7Photo, cellIn8Photo, cellIn9Photo, cellIn10Photo;
    static FileOutputStream fileOut;
    private static WebDriverHelper baseUrl;

    public static void mainMethodReadAndWrite() throws IOException, InterruptedException {
        in = new FileInputStream("ВсеНовПоступл на ..10_.xls");
        wbIn = new HSSFWorkbook(in);
        sheetIn1 = wbIn.getSheetAt(0);
        WebDriverHelper.openBrowser();
        baseUrl = new WebDriverHelper(WebDriverHelper.getDriver());
        createBookAndSheet();
        WebDriverHelper.close();
        wbOut.write(fileOut);
        wbIn.close();
        fileOut.close();
    }

    public static void createBookAndSheet() throws IOException, InterruptedException {
        wbOut = new HSSFWorkbook();
        sheetOut1 = wbOut.createSheet("готово");
        row0 = sheetOut1.createRow((short) 0);
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

        for (int i = 1; i < wbIn.getSheetAt(0).getPhysicalNumberOfRows(); i++) {
            row1 = sheetOut1.createRow(i);
            readingIncomingFileAndWriting(i, row1);
        }

        fileOut = new FileOutputStream("workbook.xls");
    }

    public static void readingIncomingFileAndWriting(int numberOfRow, Row row) throws IOException, InterruptedException {
        cellIn0Category = sheetIn1.getRow(numberOfRow).getCell(0).getStringCellValue();
        cellIn1Group = sheetIn1.getRow(numberOfRow).getCell(1).getStringCellValue();
        cellIn2Name = sheetIn1.getRow(numberOfRow).getCell(2).getStringCellValue();
        cellIn11Code = Integer.valueOf((int) sheetIn1.getRow(numberOfRow).getCell(11).getNumericCellValue());
        cellIn12Price = (int) Math.round(sheetIn1.getRow(numberOfRow).getCell(12).getNumericCellValue());
        cellIn13OptNumber = Integer.valueOf((int) sheetIn1.getRow(numberOfRow).getCell(13).getNumericCellValue());
        cellIn14OptPrice = Integer.valueOf((int) sheetIn1.getRow(numberOfRow).getCell(14).getNumericCellValue());
        cellIn4Year = sheetIn1.getRow(numberOfRow).getCell(4).getStringCellValue();
        cellIn3Note = sheetIn1.getRow(numberOfRow).getCell(3).getStringCellValue();
        cellIn5Package = sheetIn1.getRow(numberOfRow).getCell(5).getStringCellValue();

        cellIn6Photo = sheetIn1.getRow(numberOfRow).getCell(6);
        writeHyperlink(cellIn6Photo);
        cellIn6Photo_ = cellIn6Photo.getStringCellValue();

        cellIn7Photo = sheetIn1.getRow(numberOfRow).getCell(7);
        writeHyperlink(cellIn7Photo);
        cellIn7Photo_ = cellIn7Photo.getStringCellValue();

        cellIn8Photo = sheetIn1.getRow(numberOfRow).getCell(8);
        writeHyperlink(cellIn8Photo);
        cellIn8Photo_ = cellIn8Photo.getStringCellValue();

        cellIn9Photo = sheetIn1.getRow(numberOfRow).getCell(9);
        writeHyperlink(cellIn9Photo);
        cellIn9Photo_ = cellIn9Photo.getStringCellValue();

        cellIn10Photo = sheetIn1.getRow(numberOfRow).getCell(10);
        writeHyperlink(cellIn10Photo);
        cellIn10Photo_ = cellIn10Photo.getStringCellValue();

        cell0Category = row.createCell(0);
        cell0Category.setCellValue(cellIn0Category);
        cell1Group = row.createCell(1);
        cell1Group.setCellValue(cellIn1Group);
        cell2KeyWords = row.createCell(2);
        cell2KeyWords.setCellValue(cellIn1Group);
        cell3Code = row.createCell(3);
        cell3Code.setCellValue(cellIn11Code);
        cell4Name = row.createCell(4);
        cell4Name.setCellValue(cellIn2Name);
        cell5Price = row.createCell(5);
        cell5Price.setCellValue(cellIn12Price);
        cell6OptNumber = row.createCell(6);
        cell6OptNumber.setCellValue(cellIn13OptNumber);
        cell7OptPrice = row.createCell(7);
        cell7OptPrice.setCellValue(cellIn14OptPrice);
        cell8Year = row.createCell(8);
        cell8Year.setCellValue(cellIn4Year);
        cell9Note = row.createCell(9);
        cell9Note.setCellValue(cellIn3Note);
        cell10Package = row.createCell(10);
        cell10Package.setCellValue(cellIn5Package);
        cell12Photo = row.createCell(12);
        cell12Photo.setCellValue(cellIn6Photo_);
        cell13Photo = row.createCell(13);
        cell13Photo.setCellValue(cellIn7Photo_);
        cell14Photo = row.createCell(14);
        cell14Photo.setCellValue(cellIn8Photo_);
        cell15Photo = row.createCell(15);
        cell15Photo.setCellValue(cellIn9Photo_);
        cell16Photo = row.createCell(16);
        cell16Photo.setCellValue(cellIn10Photo_);
    }

    public static Cell writeHyperlink(Cell cell) throws IOException, InterruptedException {
        Hyperlink link = cell.getHyperlink();
        cell.setCellType(Cell.CELL_TYPE_STRING);
        if (link != null) {
            WebDriverHelper.getDriver().get(link.getAddress());
            WebDriverHelper.waitForPage();
            System.out.println(baseUrl.getPhotoUrl());
            cell.setCellValue(baseUrl.getPhotoUrl());
        } else {
            cell.setCellValue("");
        }
        return cell;
    }
}
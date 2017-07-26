import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.xpath.operations.String;
import org.openqa.selenium.NoSuchElementException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHelperOverwrite {
    private static Workbook wbOut;
    private static Sheet sheetOut2, sheetIn1, sheetIn2;
    private static FileInputStream in, out;
    private static HSSFWorkbook wbIn;
    private static Row row0, row1;
    private static Cell cell0Category, cell1Group, cell2KeyWords, cell3Code, cell4Name, cell5Price, cell6OptNumber,
            cell7OptPrice, cell8Year, cell9Note, cell10Package, cell11Producer, cell12Photo, cell13Photo, cell14Photo,
            cell15Photo, cell16Photo;
    private static java.lang.String cellIn0Category;
    private static java.lang.String cellIn1Group;
    private static java.lang.String cellIn2Name;
    private static java.lang.String cellIn4Year;
    private static java.lang.String cellIn3Note;
    private static java.lang.String cellIn5Package;
    private static java.lang.String cellIn6Photo_;
    private static java.lang.String cellIn7Photo_;
    private static java.lang.String cellIn8Photo_;
    private static java.lang.String cellIn9Photo_;
    private static java.lang.String cellIn10Photo_;
    private static int cellIn11Code, cellIn12Price, cellIn13OptNumber, cellIn14OptPrice;
    private static Cell cellIn6Photo, cellIn7Photo, cellIn8Photo, cellIn9Photo, cellIn10Photo;
    static FileOutputStream fileOut;
    private static WebDriverHelper baseUrl;

    public static void mainMethodOverWrite() throws IOException, InterruptedException {
        in = new FileInputStream("ВсеНовПоступл на ..10 (3).xls");
        wbIn = new HSSFWorkbook(in);
        sheetIn1 = wbIn.getSheetAt(0);

        out = new FileInputStream("трансформация в сайт_030717.xls");
        wbOut = new HSSFWorkbook(out);
        sheetOut2 = wbOut.getSheetAt(1);

        WebDriverHelper.openBrowser();
        baseUrl = new WebDriverHelper(WebDriverHelper.getDriver());

        //first - deleted all old data at 2nd sheet
        for (int i = 1; i < sheetOut2.getPhysicalNumberOfRows(); i++) {
            row1 = sheetOut2.getRow(i);
            if (row1 != null) {
                sheetOut2.removeRow(row1);
            }
        }

        //created all new rows
        for (int i = 1; i < sheetIn1.getPhysicalNumberOfRows(); i++) {
            row1 = sheetOut2.createRow(i);
            readingIncomingFileAndWriting(i, row1);
        }
fileOut = new FileOutputStream("трансформация в сайт_030717.xls");
        WebDriverHelper.close();
        wbOut.write(fileOut);
        wbIn.close();
        fileOut.close();
    }

    public static void readingIncomingFileAndWriting(int numberOfRow, Row row) throws IOException, InterruptedException {
        cellIn0Category = sheetIn1.getRow(numberOfRow).getCell(0).getStringCellValue();
        cellIn1Group = sheetIn1.getRow(numberOfRow).getCell(1).getStringCellValue();
        cellIn2Name = sheetIn1.getRow(numberOfRow).getCell(2).getStringCellValue();
        cellIn11Code = Integer.valueOf((int) sheetIn1.getRow(numberOfRow).getCell(11).getNumericCellValue());
//        if (sheetIn1.getRow(numberOfRow).getCell(12) != null) {
            cellIn12Price = (int) Math.round(sheetIn1.getRow(numberOfRow).getCell(12).getNumericCellValue());
//        } else sheetIn1.getRow(numberOfRow).getCell(12).setCellValue("0");
//        if (sheetIn1.getRow(numberOfRow).getCell(13) != null) {
        cellIn13OptNumber = Integer.valueOf((int) sheetIn1.getRow(numberOfRow).getCell(13).getNumericCellValue());
//        } else cellIn13OptNumber = sheetIn1.getRow(numberOfRow).getCell(13).setCellValue(0);

        cellIn14OptPrice = (int) Math.round(sheetIn1.getRow(numberOfRow).getCell(14).getNumericCellValue());

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

    public static Cell writeHyperlink(Cell cell) throws IOException, InterruptedException, NoSuchElementException {
        Hyperlink link = cell.getHyperlink();
        cell.setCellType(Cell.CELL_TYPE_STRING);
        if (link != null) {
            if (link.getAddress() != null) {
                WebDriverHelper.getDriver().get(link.getAddress());
                WebDriverHelper.waitForPage();
                System.out.println(baseUrl.getPhotoUrl());
                cell.setCellValue(baseUrl.getPhotoUrl());
            } else {
                cell.setCellValue("");
            }
        }
        return cell;
    }
}

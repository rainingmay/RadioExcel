import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by ybalatc on 6/22/2017.
 */
public class ReadingParser2 {
    FileInputStream in = new FileInputStream("трансформация в сайт_190617.xls");
    HSSFWorkbook wb = new HSSFWorkbook(in);
    DataFormatter formatter = new DataFormatter();
    Sheet sheet1 = wb.getSheetAt(1);

    public ReadingParser2() throws IOException {
    }

    public static void parse2() throws IOException {
    }

//    public static void getHyperlinks(Sheet sheet1) {
//        for (Row row : sheet1) {
//            for (Cell cell : row) {
////                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//                Hyperlink link = cell.getHyperlink();
//                if (link != null) {
//                    System.out.println(link.getAddress());
//                }
//            }
//        }
//    }

    public static void readingSheet(Sheet sheet1, DataFormatter formatter) {
        for (Row row : sheet1) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");

                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = formatter.formatCellValue(cell);
                System.out.println(text);

                // Alternatively, get the value and format it yourself
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.println(cell.getDateCellValue());
                        } else {
                            System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        System.out.println(cell.getCellFormula());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                }
            }
        }
    }
}
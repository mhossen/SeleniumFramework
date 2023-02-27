package helpers;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelHelper {
    String xlPath;
    InputStream fileInput;
    HSSFWorkbook wb;
    HSSFSheet sheet;
    HSSFRow row;
    HSSFCell cell;

    public ExcelHelper(String path) throws FileNotFoundException {
        xlPath = path;
        fileInput = new FileInputStream(path);
    }

    public void readXLSFile() throws IOException {
        wb = new HSSFWorkbook(fileInput);
        sheet = wb.getSheetAt(0);
        Iterator rows = sheet.rowIterator();
        while (rows.hasNext()) {
            row = (HSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while ((cells.hasNext())) {
                cell = (HSSFCell)cells.next();
                //if(cell.getc)
            }
        }
    }
}


package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    // Reads the Excel sheet and returns a List of Maps (Rows)
    public static List<Map<String, String>> getData(String excelFileName, String sheetName) throws IOException {
        
        // 1. Build the path
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + excelFileName;
        
        // 2. Open File
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        // 3. Get Headers (Row 0)
        Row headerRow = sheet.getRow(0);
        List<String> headers = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        
        for (Cell cell : headerRow) {
            headers.add(formatter.formatCellValue(cell));
        }

        // 4. Get Data (Row 1 to End)
        List<Map<String, String>> dataList = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Map<String, String> rowMap = new LinkedHashMap<>();
            for (int j = 0; j < headers.size(); j++) {
                Cell cell = row.getCell(j);
                String value = formatter.formatCellValue(cell);
                rowMap.put(headers.get(j), value);
            }
            dataList.add(rowMap);
        }

        workbook.close();
        fis.close();
        return dataList;
    }
}
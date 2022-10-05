package guru.qa.zipTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import com.codeborne.xlstest.XLS;

public class XlsTest {
    public static void checkXls(String xlsFile) {
        XLS xls = new XLS(new File(xlsFile));
        assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue()).isEqualTo("Hashimoto");
        assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(5).getNumericCellValue()).isEqualTo(25);
    }
}

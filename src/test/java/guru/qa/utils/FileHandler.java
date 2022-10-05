package guru.qa.utils;

import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.nio.file.Path;

import guru.qa.zipTests.CsvTest;
import guru.qa.zipTests.PdfTest;
import guru.qa.zipTests.XlsTest;

public class FileHandler {
    public static String getFileExtension(String fileName) {
        final String fileExt = FilenameUtils.getExtension(fileName);
        return null == fileExt || fileExt.isEmpty() ? null : fileExt.toLowerCase();
    }

    public static void iterateAndTestFiles(String dirPath) throws Exception {
        File dir = new File(dirPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                    String fileExtension = FileHandler.getFileExtension(String.valueOf(child));
                if (fileExtension != null) {
                    if (fileExtension.equals("xls"))
                        XlsTest.checkXls(String.valueOf(child));
                    else if (fileExtension.equals("csv"))
                        CsvTest.checkCsv(Path.of(String.valueOf(child)));
                    else
                        PdfTest.checkPdf(child);
                }
            }
        }
    }
}


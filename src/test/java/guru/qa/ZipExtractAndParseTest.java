package guru.qa;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import guru.qa.utils.FileHandler;
import guru.qa.utils.UnzipFile;

public class ZipExtractAndParseTest {

    @Test
    void zipExtractAndParseTest() throws Exception {
        String filePath = "src/test/resources/zip_test.zip";
        String destDir = "src/test/resources/unzippedFiles";
        UnzipFile.doUnzip(filePath, destDir);
        FileHandler.iterateAndTestFiles(destDir);
        FileUtils.deleteDirectory(new File(destDir));
    }
}

package guru.qa.zipTests;

import com.codeborne.pdftest.PDF;
import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;

public class PdfTest {
    public static void checkPdf(File extractedFile) throws Exception {
        PDF pdf = new PDF(extractedFile);
        assertThat(pdf, containsText("appropriate"));
    }
}

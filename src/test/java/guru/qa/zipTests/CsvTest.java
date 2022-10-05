package guru.qa.zipTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.opencsv.CSVReader;

public class CsvTest {

    public static void checkCsv(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                List<String[]> content = csvReader.readAll();
                String[] row = content.get(1);
                String[] row1 = content.get(2);
                assertThat(row[0]).isEqualTo("Milk");
                assertThat(row[1]).isEqualTo("15");
                assertThat(row1[0]).isEqualTo("Bread");
                assertThat(row1[1]).isEqualTo("10");
            }
        }
    }
}

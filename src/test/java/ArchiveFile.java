import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование распковки zip архива")
public class ArchiveFile {
    private final ClassLoader cl = ArchiveFile.class.getClassLoader();


    @DisplayName("Читаем ПДФ с архива")
    @Test
    void readPDFka() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("zip_fo_HW.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("pdf-forma-dlya-zapolneniya.pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat(pdf.text).contains("Пример PDF формы");
                    break;
                }
            }
        }
    }

    @DisplayName("Read xls")
    @Test
    void readXLSTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("zip_fo_HW.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("sample-empty.xls")) {
                    XLS xls = new XLS(zis);
                    String value = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
                    assertThat(value).contains("Андрюха");
                }
            }
        }

    }

    @Test
    @DisplayName("CSV file read")
    void csvFileTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("zip_fo_HW.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("ForTest.csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = csvReader.readAll();
                    assertThat(content).contains(new String[]{"Горнолыжная одежда"});
                }
            }


        }

    }
}




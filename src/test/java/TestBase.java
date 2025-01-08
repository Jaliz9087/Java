import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;



public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
       // Configuration.baseUrl = "https://miuz.ru/catalog/";
        Configuration.pageLoadStrategy = "eager";



    }
}
//"ptitsy","apteka",
//        "https:4lapy.rushareskorma-i-lakomstva-dlya-koshek-i-sobakfilter?cut_price=yes",
//        "shops","brand"
//"gryzuny-i-khorki"
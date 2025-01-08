
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JavaHWTests extends TestBase {
    @DisplayName("Смотрим сайт KIXBOX")
    @CsvSource(value = {
            "new-arrivals, Новинки",
            "muzhskoe, Мужское",
            "zhenskoe, Женское"})
    @ParameterizedTest(name = "Проверка хэдера на сайте KIXBOX")
    public void checkHeaderOnMainPageTest(String Items, String Result) {
        open("https://kixbox.ru/");
        $("a[href=\"/collection/" + Items + "\"]").click();
        $(".sitewide--title-wrapper").shouldHave(text(Result));
    }

}

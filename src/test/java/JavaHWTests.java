import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @CsvFileSource(resources = "/test_data/ForTest.csv")
    @DisplayName("Cмотрим RideStep")
    @ParameterizedTest(name = "Checking Ridestep Catalog")
    void checkRideStepCatalogTest(String Href, String Expected) {
        open("https://ridestep.ru/");
        $("a[href=\"/category/" + Href + "/\"]").shouldHave(text(Expected)).click();
        $(".category-name").shouldHave(text(Expected));


    }
    @ValueSource(strings = {
            "Сертификаты Wildberries"
    })
    @ParameterizedTest(name = "Просмотрим какую то страницу ")
    void checkBrowserPage(String Check){
        open("https://www.wildberries.ru/");
        $(".nav-element__burger-line").click();
        $("a[href=\"/gift/certificates\"]").shouldHave(text(Check));


    }

}



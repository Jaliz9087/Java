import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class JavaHWTests extends TestBase{
    @DisplayName("Смотрим сайт KIXBOX")

        @CsvSource(value ={
                "new-arrivals, Новинки",
                "muzhskoe, Мужское",
                "zhenskoe, Женское"
    })
    @ParameterizedTest(name = "Проверка хэдера на сайте МИУЗ")
    public void checkHeaderOnMainPageTest(String Items , String Result) {
        open("https://kixbox.ru/");
        //$("._1FCssP6rL7_header-footer gwlXjiSOOU_header-footer _3dDd9c-UkO_header-footer mo1x39g_header-footer _1YB06NgQR3_header-footer _1SXHAseo8i_header-footer _1YgCdvadZh_header-footer").
                //click();
        //$(".searchbox_input__bEGm3").setValue("https://miuz.ru/").pressEnter();
        //$("#r1-0").click();
//        $(".icon icon-bars").click();
        $("a[href=\"/collection/" + Items + "\"]").click();
        $(".sitewide--title-wrapper").shouldHave(text(Result));
        //$(".mb-7 mt-5 flex flex-col items-baseline gap-5 overflow-hidden").shouldHave(text(Items));
//        $(".Breadcrumbs_list__zCs6V").shouldHave(text(Animals));

    }

}

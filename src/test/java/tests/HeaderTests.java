package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HeaderPage;
import pages.MainPage;

@Epic("Шапка сайта")
@Feature("Навигация в хэдере")
@Owner("vmn_qa")
public class HeaderTests extends TestBase {

    MainPage mainPage = new MainPage();
    HeaderPage headerPage = new HeaderPage();

    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения всех разделов в шапке")
    @Story("Отображение элементов")
    void headerSectionsAreDisplayedTest() {
        mainPage.openMainPage();
        headerPage.checkHeaderSections();
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения кнопки 'Ещё' и доп. разделов")
    @Story("Дополнительные разделы")
    void moreButtonOpensAdditionalSectionsTest() {
        mainPage.openMainPage();
        headerPage.openMoreSections();
        headerPage.checkMoreSections();
    }
}

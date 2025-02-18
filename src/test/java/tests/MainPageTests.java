package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Epic("Главная страница")
@Feature("Основные проверки")
@Owner("vmn_qa")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения кнопки 'Войти в интернет-банк' и ее цвета")
    @Story("Проверка UI элементов")
    void loginButtonIsDisplayedTest() {
        mainPage.openMainPage()
                .isLoginButtonDisplayedAnClickable()
                .checkLoginButtonColor();
    }

    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения иконки ВКонтакте и перехода по ней")
    @Story("Проверка внешних ссылок")
    void vkLinkIconIsVisibleTest() {
        mainPage.openMainPage()
                .verifyVkLinkIsDisplayed()
                .clickVkLinkAndVerifyRedirection();
    }
}

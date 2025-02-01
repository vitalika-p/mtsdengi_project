package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MtsDengiPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsDengiTests extends TestBase {

    MtsDengiPage mtsDengiPage = new MtsDengiPage();

    @Tag("Simple")
    @Test
    @DisplayName("Проверка отображения текста на странице после перехода по ссылке")
    void openDebitCardPageTest() {
        mtsDengiPage.openMainPage()
                .debitCardButtonClick("Дебетовая карта");
        assertTrue(new MtsDengiPage().isPageTextDisplayed("Маркетплейсы с 15% кешбэком"));
    }

    @Tag("Simple")
    @Test
    @DisplayName("Проверка  клика на 'Дебетовая карта' и перехода к форме")
    void clickOnTheButtonTest() {
        mtsDengiPage.openMainPage()
                .debitCardButtonClick("Дебетовая карта")
                .bankCardOrder()
                .isBlockTitleDisplayed("Оформите карту");
    }

    @Tag("Simple")
    @Test
    @DisplayName("Отображение ошибки при отправке пустого значения")
    void sendEmptyValueTest() {
        mtsDengiPage.openMainPage()
                .debitCardButtonClick("Дебетовая карта")
                .sendEmptyValue()
                .isFirstErrorMessageDisplayed("Введите верный номер телефона");
    }

    @Tag("Simple")
    @Test
    @DisplayName("Проверка отображения иконки для перехода к ВКонтакте")
    void vkLinkIconIsVisibleTest() {
        mtsDengiPage.openMainPage()
                .debitCardButtonClick("Дебетовая карта")
                .isVkLinkDisplayed();
    }

    @Tag("Simple")
    @Test
    @DisplayName("Проверка отображения кнопки 'Войти в интернет-банк'")
    void loginButtonIsDisplayedTest() {
        mtsDengiPage.openMainPage()
                .debitCardButtonClick("Дебетовая карта")
                .isLoginButtonDisplayed();
    }
}

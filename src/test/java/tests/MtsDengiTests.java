package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ChatPage;
import pages.DebitCardPage;
import pages.HeaderPage;
import pages.MainPage;

public class MtsDengiTests extends TestBase {

    DebitCardPage debitCardPage = new DebitCardPage();
    MainPage mainPage = new MainPage();
    ChatPage chatPage = new ChatPage();
    HeaderPage headerPage = new HeaderPage();

    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения текста на странице после перехода по кнопке 'Дебетовая карта'")
    void openDebitCardPageTest() {
        String buttonText = "Дебетовая карта";
        String expectedText = "Маркетплейсы\n" +
                "с кешбэком до 15%";

        mainPage.openMainPage();
        debitCardPage
                .debitCardButtonClick(buttonText)
                .validateDebitCardPageText(expectedText);
    }


    @Tag("Smoke")
    @Test
    @DisplayName("Проверка перехода к форме оформления карты")
    void clickOnTheButtonTest() {
        String buttonLabel = "Дебетовая карта";
        String pageTitle = "Оформите карту";

        mainPage.openMainPage();
        debitCardPage
                .debitCardButtonClick(buttonLabel)
                .validateGetACardButtonDisplayed()
                .bankCardOrder()
                .validateBankCardOrderForm(pageTitle);
    }


    @Tag("Smoke")
    @Test
    @DisplayName("Отображение ошибки при отправке невалидного значения в поле ввода")
    void sendInvalidValuesTest() {
        String buttonText = "Дебетовая карта";
        String invalidPhone = "767";
        String expectedError = "Введите верный номер телефона";

        mainPage.openMainPage();
        debitCardPage
                .debitCardButtonClick(buttonText)
                .enterInvalidPhoneNumber(invalidPhone)
                .sendInvalidValues()
                .checkErrorMessages(expectedError);
    }


    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения иконки для перехода к ВКонтакте и переход по ней")
    void vkLinkIconIsVisibleTest() {
        mainPage
                .openMainPage()
                .verifyVkLinkIsDisplayed()
                .clickVkLinkAndVerifyRedirection();
    }


    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения кнопки 'Войти в интернет-банк' и ее цвета")
    void loginButtonIsDisplayedTest() {
        mainPage.openMainPage()
                .isLoginButtonDisplayedAnClickable()
                .checkLoginButtonColor();
    }


    @Tag("Smoke")
    @Test
    @DisplayName("Проверка открытия и закрытия чата с поддержкой")
    void chatSupportTest() {
        String expectedTitle = "Здравствуйте!";
        String expectedSubtitle = "Введите ваш вопрос и начните чат с оператором";

        mainPage.openMainPage();
        chatPage.waitForChatButton()
                .verifyChatButtonIsVisible()
                .clickChatButton()
                .verifyChatWindowIsVisible()
                .verifyChatTitle(expectedTitle)
                .verifyChatSubtitle(expectedSubtitle)
                .verifyCloseButtonIsVisible()
                .clickCloseButton()
                .verifyChatWindowIsHidden();
    }


    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения разделов в шапке")
    void headerSectionsAndMoreButtonTest() {
        mainPage.openMainPage();
        headerPage.checkAllSections();
    }
}

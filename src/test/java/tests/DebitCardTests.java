package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DebitCardPage;
import pages.MainPage;

@Epic("Дебетовая карта")
@Feature("Оформление карты")
@Owner("vmn_qa")
public class DebitCardTests extends TestBase {

    MainPage mainPage = new MainPage();
    DebitCardPage debitCardPage = new DebitCardPage();

    @Tag("Smoke")
    @Test
    @DisplayName("Проверка отображения текста на странице после перехода по кнопке 'Дебетовая карта'")
    @Story("Проверка текста")
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
    @Story("Форма оформления")
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
    @DisplayName("Проверка отображения ошибки при отправке пустой формы")
    @Story("Форма оформления")
    void errorMessageIsDisplayedTest() {
        String buttonLabel = "Дебетовая карта";
        String invalidPhoneNumber = "75";

        mainPage.openMainPage();
        debitCardPage
                .debitCardButtonClick(buttonLabel)
                .validateGetACardButtonDisplayed()
                .bankCardOrder()
                .enterInvalidPhoneNumber(invalidPhoneNumber)
                .sendInvalidValues()
                .checkErrorMessages("Введите верный номер телефона");
    }
}

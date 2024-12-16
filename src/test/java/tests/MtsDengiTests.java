package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MtsDengiPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MtsDengiTests extends TestBase {

    MtsDengiPage mtsDengiPage = new MtsDengiPage();

    @Tag("Simple")
    @Test
    @Description("Проверка, что отображается текст на странице после перехода по ссылке 'Дебетовая карта'")
    void openDebitCardPageTest() {
        step("Открыть страницу", () -> {
            mtsDengiPage.openMainPage();
        });
        step("Нажать на Дебетовые карты", () -> {
            mtsDengiPage.debitCardButtonClick();
        });
        step("Проверить отображение текста", () -> {
            mtsDengiPage.isPageTextDisplayed();
        });
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что после клика на 'Дебетовая карта' открывается блок с заказом карты")
    void clickOnTheButtonTest() {
        step("Открыть страницу", () -> {
            mtsDengiPage.openMainPage();
        });
        step("Нажать на Дебетовые карты", () -> {
            mtsDengiPage.debitCardButtonClick();
        });
        step("Нажать на Оформить карту", () -> {
            mtsDengiPage.bankCardOrder();
        });
        step("Проверить отображение названия блока", () -> {
            mtsDengiPage.isBlockTitleDisplayed();
        });
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что при отправке пустого значения отображается ошибка")
    void sendEmptyValueTest() {
        step("Открыть страницу", () -> {
            mtsDengiPage.openMainPage();
        });
        step("Нажать на Дебетовые карты", () -> {
            mtsDengiPage.debitCardButtonClick();
        });
        step("Нажать на Оформить", () -> {
            mtsDengiPage.sendEmptyValue();
        });
        step("Проверить отображение ошибки", () -> {
            mtsDengiPage.isFirstErrorMessageDisplayed("Введите верный номер телефона");
        });
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что иконка на ВКонтакте отображается")
    void VkLinkIconIsVisible() {
        step("Открыть страницу", () -> {
            mtsDengiPage.openMainPage();
        });
        step("Нажать на Дебетовые карты", () -> {
            mtsDengiPage.debitCardButtonClick();
        });
        step("Проверить отображение кнопки для перехода в ВК", () -> {
            mtsDengiPage.isVkLinkDisplayed();
        });
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что кнопка 'Войти в интернет-банк' отображается")
    void loginButtonIsDisplayedTest() {
        step("Открыть страницу", () -> {
            mtsDengiPage.openMainPage();
        });
        step("Нажать на Дебетовые карты", () -> {
            mtsDengiPage.debitCardButtonClick();
        });
        step("Проверка отображения кнопки логина", () -> {
            mtsDengiPage.isLoginButtonDisplayed();
        });
    }
}
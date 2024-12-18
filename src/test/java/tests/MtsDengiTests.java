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
        mtsDengiPage.openMainPage()
                .debitCardButtonClick()
                .isPageTextDisplayed();
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что после клика на 'Дебетовая карта' открывается блок с заказом карты")
    void clickOnTheButtonTest() {
        mtsDengiPage
                .openMainPage()
                .debitCardButtonClick()
                .bankCardOrder()
                .isBlockTitleDisplayed();
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что при отправке пустого значения отображается ошибка")
    void sendEmptyValueTest() {
        mtsDengiPage
                .openMainPage()
                .debitCardButtonClick()
                .sendEmptyValue()
                .isFirstErrorMessageDisplayed("Введите верный номер телефона");
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что иконка на ВКонтакте отображается")
    void vkLinkIconIsVisibleTest() {
        mtsDengiPage
                .openMainPage()
                .debitCardButtonClick()
                .isVkLinkDisplayed();
    }

    @Tag("Simple")
    @Test
    @Description("Проверка, что кнопка 'Войти в интернет-банк' отображается")
    void loginButtonIsDisplayedTest() {
        mtsDengiPage.openMainPage()
                .debitCardButtonClick()
                .isLoginButtonDisplayed();
    }
}

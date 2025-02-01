package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MtsDengiPage {

    private final SelenideElement
            debitCardElement = $x("//a[.//div[text()='Дебетовая карта']]"),
            getACardButton = $("#topBanner .styled__ButtonContainer-sc-e25894b-6 button div"),
            blockName = $("#issueCard form > div"),
            pageText = $("#topBanner .styled__TextContainer-sc-e25894b-0 h1"),
            continueButton = $("#issueCard form div.sc-f77916f4-5 button"),
            firstErrorMessage = $("#issueCard form .HelperText-sc-15b8l92-0"),
            vkLink = $("#mtsdengi-footer a:nth-child(2)"),
            loginButton = $("#__next .styled__HeaderContainer-sc-vvwooi-0 .ui__SmartVisibleChild-sc-a9c9b92d-0.bkjWql a");

    @Step("Открываем главную страницу")
    public MtsDengiPage openMainPage() {
        open("");
        return this;
    }

    @Step("Нажимаем на кнопку с текстом '{buttonText}'")
    public MtsDengiPage debitCardButtonClick(String buttonText) {
        debitCardElement.shouldHave(text(buttonText)).click();
        return this;
    }

    @Step("Проверяем, что текст '{expectedText}' отображается на странице")
    public boolean isPageTextDisplayed(String expectedText) {
        return pageText.getText().contains(expectedText);
    }

    @Step("Оформляем заказ банковской карты")
    public MtsDengiPage bankCardOrder() {
        getACardButton.click();
        return this;
    }

    @Step("Проверяем, что заголовок блока содержит текст '{expectedText}'")
    public boolean isBlockTitleDisplayed(String expectedText) {
        return blockName.getText().contains(expectedText);
    }


    @Step("Отправляем пустое значение формы")
    public MtsDengiPage sendEmptyValue() {
        continueButton.click();
        return this;
    }

    @Step("Проверяем отображение сообщения об ошибке: {expectedMessage}")
    public boolean isFirstErrorMessageDisplayed(String expectedMessage) {
        return firstErrorMessage.getText().contains(expectedMessage);
    }

    @Step("Проверяем, что ссылка VK отображается")
    public MtsDengiPage isVkLinkDisplayed() {
        if (!vkLink.shouldBe(Condition.visible).exists()) {
            throw new AssertionError("Ссылка VK не отображается");
        }
        return this;
    }

    @Step("Проверяем, что кнопка логина отображается")
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}

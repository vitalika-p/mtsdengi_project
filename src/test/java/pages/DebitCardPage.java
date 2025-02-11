package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DebitCardPage {

    private final SelenideElement
            debitCardElement = $x("//a[.//div[text()='Дебетовая карта']]"),
            getACardButton = $x("//button[@type='button' and contains(@class, 'Button-sc-14n6qm4-0')]" + "//div[@data-testid='text' and text()='Оформить карту']"),
            blockName = $("#issueCard form > div"),
            pageText = $("#topBanner .styled__TextContainer-sc-e25894b-0 h1"),
            continueButton = $x("//button[text()='Продолжить']"),
            firstErrorMessage = $("#issueCard form .HelperText-sc-15b8l92-0"),
            phoneInput = $("#cardFormInput");


    @Step("Нажать на кнопку с текстом '{buttonText}'")
    public DebitCardPage debitCardButtonClick(String buttonText) {
        debitCardElement.shouldHave(text(buttonText)).click();
        return this;
    }


    @Step("Проверить, что текст '{expectedText}' отображается на странице")
    public boolean isPageTextDisplayed(String expectedText) {
        return pageText.getText().contains(expectedText);
    }

    @Step("Проверка, что после перехода на странице содержится текст '{expectedText}'")
    public DebitCardPage validateDebitCardPageText(String expectedText) {
        assertTrue(isPageTextDisplayed(expectedText), "Ожидаемый текст не найден на странице");
        return this;
    }


    @Step("Проверить, что кнопка 'Оформить карту' отображается")
    public DebitCardPage validateGetACardButtonDisplayed() {
        getACardButton.shouldBe(visible);
        return this;
    }

    @Step("Тап на кнопку 'Оформить карту")
    public DebitCardPage bankCardOrder() {
        getACardButton.click();
        return this;
    }

    @Step("Проверить, что заголовок блока содержит текст 'Оформите карту'")
    public DebitCardPage validateBlockTitle(String expectedText) {
        blockName.shouldBe(visible).shouldHave(text(expectedText));
        return this;
    }

    @Step("Проверить, что кнопка 'Продолжить' отображается")
    public DebitCardPage validateContinueButtonDisplayed() {
        continueButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что форма для оформления карты отображается")
    public DebitCardPage validateFormDisplayed() {
        blockName.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что страница оформления карты загружена корректно")
    public DebitCardPage validateBankCardOrderForm(String expectedTitle) {
        return validateBlockTitle(expectedTitle)
                .validateFormDisplayed()
                .validateContinueButtonDisplayed();
    }

    @Step("Ввести номер телефона: {phoneNumber}")
    public DebitCardPage enterInvalidPhoneNumber(String phoneNumber) {
        phoneInput.setValue(phoneNumber);
        return this;
    }


    @Step("Тап на кнопку Продолжить")
    public DebitCardPage sendInvalidValues() {
        continueButton.click();
        return this;
    }

    @Step("Проверить отображение сообщения об ошибке")
    public DebitCardPage checkErrorMessages(String expectedMessage1) {
        firstErrorMessage.shouldBe(visible);

        String actualMessage = firstErrorMessage.getText();
        assertTrue(actualMessage.contains(expectedMessage1),
                String.format("Ожидали сообщение: '%s', но получили: '%s'", expectedMessage1, actualMessage));
        return this;
    }


}

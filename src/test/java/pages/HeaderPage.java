package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HeaderPage {

    private final SelenideElement virtualCard = $$("div").findBy(text("Виртуальная карта")),
            debitCard = $x("//a[.//div[text()='Дебетовая карта']]"),
            creditCard = $x("//div[contains(text(), 'Кредитная карта')]"),
            credit = $x("//div[contains(text(), 'Кредит')]"),
            deposit = $x("//div[contains(text(), 'Вклад')]"),
            moreButton = $("div.styled__MoreButton-sc-f8xjqq-5.eOLAq"),
            mtsFlexButton = $x("//div[@data-testid='text' and text()='МТС Флекс']"),
            officesAndATMsButton = $x("//div[@data-testid='text' and text()='Офисы и банкоматы']");


    @Step("Проверить отображение всех разделов на шапке")
    public HeaderPage checkHeaderSections() {
        assertThat(virtualCard.isDisplayed()).isTrue();
        assertThat(debitCard.isDisplayed()).isTrue();
        assertThat(creditCard.isDisplayed()).isTrue();
        assertThat(credit.isDisplayed()).isTrue();
        assertThat(deposit.isDisplayed()).isTrue();
        assertThat(moreButton.isDisplayed()).isTrue();
        return this;
    }

    @Step("Открыть дополнительные разделы по кнопке 'Ещё'")
    public HeaderPage openMoreSections() {
        moreButton.shouldBe(visible);
        moreButton.click();
        return this;
    }

    @Step("Проверка наличия разделов 'МТС Флекс' и 'Офисы и банкоматы'")
    public HeaderPage checkMoreSections() {
        assertThat(mtsFlexButton.isDisplayed()).isTrue();
        assertThat(officesAndATMsButton.isDisplayed()).isTrue();
        return this;
    }

    @Step("Проверка разделов в шапке")
    public HeaderPage checkAllSections() {
        checkHeaderSections();
        openMoreSections();
        checkMoreSections();
        return this;
    }
}

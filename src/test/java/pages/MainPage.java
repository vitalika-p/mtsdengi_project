package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage {

    private final SelenideElement
            vkLink = $("#mtsdengi-footer a:nth-child(2)"),
            loginButton = $$("a[href='https://online.mtsdengi.ru/']")
                    .findBy(text("войти в интернет-банк"));
    private final String expectedButtonColor = "rgba(143, 143, 255, 1)";


    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("");
        return this;
    }

    @Step("Проверить, что ссылка на VK отображается")
    public MainPage verifyVkLinkIsDisplayed() {
        boolean isDisplayed = vkLink.shouldBe(Condition.visible).exists();
        assertTrue(isDisplayed, "Иконка VK не отображается!");
        return this;
    }


    @Step("Проверить отображение ссылки на VK и переход по ней")
    public MainPage clickVkLinkAndVerifyRedirection() {
        vkLink.shouldBe(Condition.visible).click();
        switchTo().window(1);
        String currentUrl = WebDriverRunner.url();
        assertTrue(currentUrl.contains("vk.com"), "После клика на иконку VK открылась неверная страница: " + currentUrl);
        return this;
    }

    @Step("Проверить, что кнопка '{expectedButton}' отображается и доступна для клика")
    public MainPage isLoginButtonDisplayedAnClickable() {
        loginButton.shouldBe(Condition.visible);
        loginButton.shouldBe(Condition.enabled);
        return this;
    }

    @Step("Проверить цвет кнопки входа в интернет-банк")
    public void checkLoginButtonColor() {
        String buttonColor = loginButton.getCssValue("background-color");
        assertThat(buttonColor).isEqualTo(expectedButtonColor);
    }
}

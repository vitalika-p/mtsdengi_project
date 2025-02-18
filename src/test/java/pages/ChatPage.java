package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ChatPage {

    private final SelenideElement chatButton = $("div.webim-html-button-element.webim-html-button-main[data-webim-type='dropdown-toggle']"),
            chatWindow = $("div.webim-no-operator-block"),
            chatTitle = $("span.webim-no-operator-title[data-webim-resource='chat.header.default_title']"),
            chatSubtitle = $("span.first-question-header-subtitle[data-webim-resource='chat.header.first_question_subtitle']"),
            closeButton = $("div.webim-action.webim-action-close[data-webim-request='service:chat:close'] svg.webim-ico-close-light");

    @Step("Ожидание загрузки кнопки чата")
    public ChatPage waitForChatButton() {
        chatButton.shouldBe(Condition.visible, Condition.enabled);
        return this;
    }

    @Step("Проверить, что кнопка чата отображается")
    public ChatPage verifyChatButtonIsVisible() {
        chatButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Нажать на кнопку чата")
    public ChatPage clickChatButton() {
        waitForChatButton(); // Явное ожидание перед кликом
        chatButton.click();
        return this;
    }

    @Step("Проверить, что окно чата открылось")
    public ChatPage verifyChatWindowIsVisible() {
        chatWindow.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить заголовок чата")
    public ChatPage verifyChatTitle(String expectedTitle) {
        chatTitle.shouldHave(Condition.text(expectedTitle));
        return this;
    }

    @Step("Проверить подзаголовок чата")
    public ChatPage verifyChatSubtitle(String expectedSubtitle) {
        chatSubtitle.shouldHave(Condition.text(expectedSubtitle));
        return this;
    }

    @Step("Проверить, что кнопка закрытия (крестик) отображается")
    public ChatPage verifyCloseButtonIsVisible() {
        closeButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Нажать на кнопку закрытия чата (крестик)")
    public ChatPage clickCloseButton() {
        closeButton.click();
        return this;
    }

    @Step("Проверить, что окно чата закрылось")
    public ChatPage verifyChatWindowIsHidden() {
        chatWindow.shouldNotBe(Condition.visible);
        return this;
    }
}

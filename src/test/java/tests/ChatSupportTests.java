package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ChatPage;
import pages.MainPage;

@Epic("Поддержка")
@Feature("Чат с поддержкой")
@Owner("vmn_qa")
public class ChatSupportTests extends TestBase {

    MainPage mainPage = new MainPage();
    ChatPage chatPage = new ChatPage();

    @Tag("Smoke")
    @Test
    @DisplayName("Проверка открытия и закрытия чата с поддержкой")
    @Story("Чат")
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
}

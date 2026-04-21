package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.*;

public class GithubHoverTest extends BaseTest {

    @Test
    void checkEnterprisePage() {

        // Сначала открываем браузер!
        open("https://github.com");

        // Потом можно чистить
        clearBrowserCookies();
        clearBrowserLocalStorage();

        // Hover
        $(byText("Solutions")).shouldBe(visible).hover();

        // Click
        $(byText("Enterprise")).shouldBe(visible).click();

        // Проверка
        $("body").shouldHave(text("AI-powered"));
    }
}
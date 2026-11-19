package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.*;

public class GithubHoverTest extends BaseTest {

    @Test
    void checkEnterprisePage() {
        open("https://github.com");

        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();

        $("body").shouldBe(visible);

        $(byText("Solutions"))
                .shouldBe(visible)
                .hover();

        $(byText("Enterprise"))
                .shouldBe(visible)
                .click();

        $("body").shouldHave(text("AI-powered"));
    }
}
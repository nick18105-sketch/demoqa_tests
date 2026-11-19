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

        $("button[aria-controls='_R_1nd_']")
                .shouldBe(visible)
                .hover();

        $("button[aria-controls='_R_1nd_']")
                .shouldHave(attribute("aria-expanded", "true"));

        $(byText("Enterprises"))
                .shouldBe(visible)
                .click();

        $("body").shouldHave(text("GitHub for Enterprise"));
    }
}
package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubWikiTest extends BaseTest {

    @Test
    void checkSoftAssertionsPage() {

        open("https://github.com/selenide/selenide/wiki");

        $("#wiki-pages-box").shouldBe(visible);

        $("#wiki-pages-filter").setValue("SoftAssertions");

        $("#wiki-pages-box")
                .shouldHave(text("SoftAssertions"));

        $("#wiki-pages-box")
                .$(byText("SoftAssertions"))
                .shouldBe(visible)
                .click();

        $(".markdown-body").shouldHave(text("JUnit5"));
    }
}
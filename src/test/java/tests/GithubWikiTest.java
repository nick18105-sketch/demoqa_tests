package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubWikiTest extends BaseTest {

    @Test
    void checkSoftAssertionsPage() {

        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();

        $("#wiki-pages-box").shouldBe(visible);

        $("#wiki-pages-filter").setValue("SoftAssertions");

        if ($(".wiki-more-pages-link").exists()) {
            $(".wiki-more-pages-link").click();
        }

        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("JUnit5"));
    }
}
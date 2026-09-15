package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GithubIssueTest extends BaseTest {

    @Test
    void checkIssueName() {

        step("Открыть страницу Issue", () -> {
            open("https://github.com/nick18105-sketch/demoqa_tests/issues/1");
        });

        step("Проверить название Issue", () -> {
            $("h1").shouldHave(text("Allure test issue"));
        });
    }
}
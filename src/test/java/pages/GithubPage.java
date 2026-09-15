package pages;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;

public class GithubPage {

    public GithubPage openPage() {
        open("https://github.com/");
        return this;
    }

    public GithubPage searchRepository(String repository) {
        $("[data-target='qbsearch-input.inputButtonText']")
                .click();

        $("#query-builder-test")
                .setValue(repository)
                .pressEnter();

        return this;
    }

    public GithubPage openRepository(String repository) {
        $(byText(repository)).click();
        return this;
    }
    public GithubPage goToIssues() {
        $(byText("Issues")).click();
        return this;
    }
    public GithubPage openIssue(String issueName) {
        $(byText(issueName)).click();
        return this;
    }
    public GithubPage checkIssueTitle(String expectedTitle) {
        $("h1").shouldHave(text(expectedTitle));
        return this;
    }
}
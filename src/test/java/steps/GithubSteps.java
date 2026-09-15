package steps;

import io.qameta.allure.Step;
import pages.GithubPage;

public class GithubSteps {

    private final GithubPage githubPage = new GithubPage();

    @Step("Открыть страницу Issue")
    public void openIssue() {
        githubPage.openPage();
    }

    @Step("Проверить название Issue")
    public void checkIssueName(String expectedName) {
        githubPage.checkIssueTitle(expectedName);
    }
}
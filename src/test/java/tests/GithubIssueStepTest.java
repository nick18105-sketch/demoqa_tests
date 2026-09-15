package tests;

import org.junit.jupiter.api.Test;
import steps.GithubSteps;

public class GithubIssueStepTest extends BaseTest {

    private final GithubSteps githubSteps = new GithubSteps();

    @Test
    void checkIssueNameWithSteps() {

        githubSteps.openIssue();

        githubSteps.checkIssueName("The future of building happens together");
    }
}
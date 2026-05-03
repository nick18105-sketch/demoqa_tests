package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class ResultTableComponent {

    public void checkResult(String key, String value) {
        $(".table-responsive").shouldHave(text(key), text(value));
    }
}
package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DragAndDropPage {

    public DragAndDropPage openPage() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        return this;
    }

    public DragAndDropPage dragAtoB() {
        var columnA = $("#column-a");
        var columnB = $("#column-b");

        columnA.dragAndDropTo(columnB);

        if (!columnA.has(text("B"))) {
            actions()
                    .clickAndHold(columnA)
                    .moveToElement(columnB)
                    .release()
                    .perform();
        }

        return this;
    }

    public DragAndDropPage checkResult() {
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        return this;
    }
}
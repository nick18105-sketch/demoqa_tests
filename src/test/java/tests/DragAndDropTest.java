package tests;

import org.junit.jupiter.api.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    DragAndDropPage page = new DragAndDropPage();

    @Test
    void dragAndDropTest() {

        page.openPage()
                .dragAtoB()
                .checkResult();
    }
}
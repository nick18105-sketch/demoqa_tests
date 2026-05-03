package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest extends BaseTest {

    PracticeFormPage formPage = new PracticeFormPage();

    @Test
    public void fillFormTest() {
        formPage.openPage()
                .setFirstName("Nikolay")
                .setLastName("Trunov")
                .setEmail("test@test.com")
                .selectGender("Male")
                .setPhone("9999999999")
                .submit()
                .checkResult("Student Name", "Nikolay Trunov");
    }

    @Test
    public void fillMinimumFormTest() {
        formPage.openPage()
                .setFirstName("Nikolay")
                .setLastName("Trunov")
                .selectGender("Male")
                .setPhone("9999999999")
                .submit()
                .checkResult("Student Name", "Nikolay Trunov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999");
    }

    @Test
    public void negativeFormTest() {
        formPage.openPage()
                .setFirstName("Nikolay")
                // не заполняем LastName
                .selectGender("Male")
                .setPhone("9999999999")
                .submit();

        $(".modal-content").shouldNotBe(visible);
    }
}
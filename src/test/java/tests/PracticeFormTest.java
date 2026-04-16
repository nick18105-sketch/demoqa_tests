package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class PracticeFormTest {

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    @Test
    public void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Nikolay");
        $("#lastName").setValue("Trunov");
        $("#userEmail").setValue("test@test.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9999999999");

        // DATE
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--016:not(.react-datepicker__day--outside-month)").click();

        // SUBJECT
        $("#subjectsInput").setValue("Economics").pressEnter();

        // HOBBIES
        $("#hobbiesWrapper").$(byText("Sports")).click();

        // ADDRESS
        $("#currentAddress").setValue("Pobedy 31, 390");

        // STATE + CITY
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();

        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        // SUBMIT
        $("#submit").scrollTo().click();

        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(
                text("Nikolay Trunov"),
                text("test@test.com"),
                text("Male"),
                text("9999999999"),
                text("Pobedy 31, 390")
        );
}
}

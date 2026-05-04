package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class PracticeFormTest extends BaseTest {

    PracticeFormPage formPage = new PracticeFormPage();

Faker faker = new Faker(new Locale("en"));

    @Test
    public void fillFormTest() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.number().digits(10);

        String gender = faker.options().option("Male", "Female", "Other");

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setPhone(phone)
                .submit()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone);
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
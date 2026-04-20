package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

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
                .setBirthDate("May", "1997", "16")
                .setSubject("Economics")
                .selectHobby("Sports")
                .setAddress("Pobedy 31, 390")
                .setState("NCR")
                .setCity("Delhi")
                .submit()
                .checkResult(
                        "Nikolay Trunov",
                        "test@test.com",
                        "Male",
                        "9999999999",
                        "Pobedy 31, 390"
                );
    }
}
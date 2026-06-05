package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import pages.PracticeFormPage;

import java.util.stream.Stream;

public class ParameterizedPracticeFormTest extends BaseTest {

    PracticeFormPage formPage = new PracticeFormPage();

    // =====================================
    // Test 1 - ValueSource
    // =====================================

    @ParameterizedTest(name = "Имя: {0}")
    @ValueSource(strings = {
            "Nikolay",
            "Ivan",
            "Petr"
    })
    void firstNameTest(String firstName) {

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName("Test")
                .setPhone("9999999999")
                .selectGender("Male")
                .submit()
                .checkResult("Student Name", firstName + " Test");
    }

    // =====================================
    // Test 2 - CsvSource
    // =====================================

    @ParameterizedTest(name = "{0} {1}")
    @CsvSource({
            "Nikolay, Trunov",
            "Ivan, Ivanov",
            "Petr, Petrov"
    })
    void fullNameTest(String firstName, String lastName) {

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhone("9999999999")
                .selectGender("Male")
                .submit()
                .checkResult("Student Name", firstName + " " + lastName);
    }

    // =====================================
    // Data Provider for MethodSource
    // =====================================

    static Stream<Arguments> usersData() {
        return Stream.of(
                Arguments.of("Nikolay", "Male"),
                Arguments.of("Ivan", "Male"),
                Arguments.of("Anna", "Female")
        );
    }

    // =====================================
    // Test 3 - MethodSource
    // =====================================

    @ParameterizedTest(name = "{0} - {1}")
    @MethodSource("usersData")
    void genderTest(String firstName, String gender) {

        formPage.openPage()
                .setFirstName(firstName)
                .setLastName("Test")
                .setPhone("9999999999")
                .selectGender(gender)
                .submit()
                .checkResult("Gender", gender);
    }
}
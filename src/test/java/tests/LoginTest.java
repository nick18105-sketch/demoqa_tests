package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest {

    @ParameterizedTest(name = "Проверка логина: {0}")
    @CsvSource({
            "admin, 12345",
            "user, qwerty",
            "test, test123"
    })
    void loginTest(String login, String password) {

        System.out.println("Login: " + login);
        System.out.println("Password: " + password);

    }
}
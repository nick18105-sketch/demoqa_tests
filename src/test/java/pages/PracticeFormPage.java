package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;

public class PracticeFormPage {

    public PracticeFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public PracticeFormPage setState(String state) {
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public PracticeFormPage setCity(String city) {
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public PracticeFormPage submit() {
        $("#submit").scrollTo().click();
        return this;
    }

    public PracticeFormPage checkResult(String name, String email, String gender, String phone, String address) {
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(
                text(name),
                text(email),
                text(gender),
                text(phone),
                text(address)
        );
        return this;
    }
}
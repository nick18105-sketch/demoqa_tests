package pages;

import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class PracticeFormPage {

    // подключили компонент
    ResultTableComponent resultTable = new ResultTableComponent();

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
        $(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        $("#state").click();
        $(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();
        return this;
    }

    public PracticeFormPage submit() {
        $("#submit").click();
        return this;
    }

    // теперь используем компонент
    public PracticeFormPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);
        return this;
    }
}
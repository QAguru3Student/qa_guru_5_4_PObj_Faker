package tests.pages;

import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoFillFormWithFakerPage {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "male";
    String mobileNumber = faker.number().digits(10);
    String year = "1987";
    String month = "October";
    String day = "24";
    String[] hobbies = {"Sports", "Music"};
    String subjects = "Maths";
    String address = faker.address().fullAddress();
    String state = "Uttar Pradesh";
    String city = "Agra";
    String filename = "avatar.jpg";

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");

    }

    public void fillForm() {
        //заполниь форму
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(mobileNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day).click();

        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFromClasspath(filename);

        $("#currentAddress").setValue(address).scrollTo();

        $("#state").parent().click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

    }

    public void checkForm() {
        //проверить форму
        checkValue("Student Name", firstName + " " + lastName);
        checkValue("Student Email", email);
        checkValue("Gender", gender);
        checkValue("Mobile", mobileNumber);
        checkValue("Date of Birth", day + " " + month + "," + year);
        checkValue("Subjects", subjects);
        checkValue("Hobbies", String.join(", ",hobbies));
        checkValue("Picture", filename);
        checkValue("Address", address);
        checkValue("State and City", state + " " + city);
    }

   public void checkValue (String key, String value) {
        $$(".table-responsive td").find(text(key)).sibling(0).shouldHave(exactText(value));
    }
}
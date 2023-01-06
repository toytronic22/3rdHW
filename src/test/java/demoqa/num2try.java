import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void studentRegistrationFormTest() {
        String name = "Alexey";
        String lastName = "Martynov";
        String email = "leshaklew@gmail.com";
        String phoneNumber = "9604613587";
        String currentAddress = "Taganrog-2 station, house 119";
        String gender = "Male";
        String dateOfBirth = "18 May,1989";
        String subject = "Computer Science";
        String hobbies = "Music, Reading";
        String pictureFIleName = "brad_pitt.png";
        String stateAndCity = "NCR Noida";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("images/brad_pitt.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(name + " " + lastName), (text(email)),
                (text(phoneNumber)), (text(currentAddress)), (text(gender)),
                (text(dateOfBirth)), (text(subject)), (text(hobbies)),
                (text(hobbies)), (text(pictureFIleName)), (text(stateAndCity)));
    }
}

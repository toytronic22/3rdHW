package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxes {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Alex Egorov";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Anyway");
        $("#lastName").setValue("Anykey");
        $("#userEmail").setValue("qaguru@qa.gu");
        $("label=gender-radio-1").click();
        $("label=gender-radio-2").click();
        $("label=gender-radio-3").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text(userName)));
        $("#output #email").shouldHave((text("qaguru@qa.gu")));
        // todo check addresses
    }
}
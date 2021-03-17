package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    @BeforeAll
    static void fullScreen() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Bogdanova");
        $("#lastName").setValue("Evgeniya");
        $("#userEmail").setValue("ebogdanova123@qq.qq");
        $(byText("Female")).click();
        $("#userNumber").setValue("9001112233");
        $(byId("dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__year-select").selectOptionByValue("1997");
        $(".react-datepicker__day.react-datepicker__day--019").click();
        $("#subjectsInput").setValue("biology").pressEnter();
        $("#subjectsInput").setValue("computer science").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Yaroslavskaya street, Moscow, Russia");
        $("#react-select-3-input").setValue("ncr").pressEnter();
        $("#react-select-4-input").setValue("delhi").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name Bogdanova Evgeniya"),
                text("Student Email ebogdanova123@qq.qq"),
                text("Gender Female"),
                text("Mobile 9001112233"),
                text("Date of Birth 19 November,1997"),
                text("Subjects Biology, Computer Science"),
                text("Hobbies Music"),
                text("Picture test.jpg"),
                text("Address Yaroslavskaya street, Moscow, Russia"),
                text("State and City NCR Delhi"));
    }
}

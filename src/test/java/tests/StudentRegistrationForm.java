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

        $(By.xpath("//td[text()='Student Name']/following-sibling::td")).shouldHave(text("Bogdanova Evgeniya"));
        $(By.xpath("//td[text()='Student Email']/following-sibling::td")).shouldHave(text("ebogdanova123@qq.qq"));
        $(By.xpath("//td[text()='Gender']/following-sibling::td")).shouldHave(text("Female"));
        $(By.xpath("//td[text()='Mobile']/following-sibling::td")).shouldHave(text("9001112233"));
        $(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).shouldHave(text("19 November,1997"));
        $(By.xpath("//td[text()='Subjects']/following-sibling::td")).shouldHave(text("Biology, Computer Science"));
        $(By.xpath("//td[text()='Hobbies']/following-sibling::td")).shouldHave(text("Music"));
        $(By.xpath("//td[text()='Picture']/following-sibling::td")).shouldHave(text("test.jpg"));
        $(By.xpath("//td[text()='Address']/following-sibling::td")).shouldHave(text("Yaroslavskaya street, Moscow, Russia"));
        $(By.xpath("//td[text()='State and City']/following-sibling::td")).shouldHave(text("NCR Delhi"));
    }
}

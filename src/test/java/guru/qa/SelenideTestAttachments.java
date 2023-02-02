package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class SelenideTestAttachments {
    public static final String NAME_ISSUE = "SoftAsserts not working with Cucumber/Junit4 runner";
    public static final String URL = "https://github.com/selenide/selenide";

    @Test
    void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу Selenide в Github", () -> {
            open(URL);
            attachment("Source", webdriver().driver().source());
        });
    }
        @Test
        public void testAnnotatedAttachments() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            SelenideTestWithSteps steps = new SelenideTestWithSteps();

            steps.openSelenideInGithub(URL);
            steps.takeScreenShot();
        }
    }



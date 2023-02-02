package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

        @Test
        void searchNameIssue() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com/selenide/selenide");
            $("#issues-tab").click();
            $(withText("SoftAsserts not working with Cucumber/Junit4 runner")).should(Condition.exist);
        }

    }


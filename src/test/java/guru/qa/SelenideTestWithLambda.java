package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTestWithLambda {
    public static final String NAME_ISSUE = "SoftAsserts not working with Cucumber/Junit4 runner";
    public static final String URL = "https://github.com/selenide/selenide";

        @Test
        @Feature("Issue в репозитории")
        @Story("Проверка Issue")
        @Owner("shkrebayv")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Testing", url = "https://github.com/selenide/selenide")
        @DisplayName("Проверка наличия Issue с наименованием (lambda)")
        void searchNameIssueWithLambda() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            step("Открываем страницу Selenide в Github", () -> {
                open(URL);
            });

            step("Переходим на вкладку Issues", () -> {
                $("#issues-tab").click();
            });

            step("Проверяем наличие Issue с наименованием " + NAME_ISSUE, () ->{
                $(withText(NAME_ISSUE)).should(Condition.exist);
            });
        }

        @Test
        @Feature("Issue в репозитории")
        @Story("Проверка Issue")
        @Owner("shkrebayv")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Testing", url = "https://github.com/selenide/selenide")
        @DisplayName("Проверка наличия Issue с наименованием (steps)")
        public void testAnnotatedStep(){
            SelenideTestWithSteps steps = new SelenideTestWithSteps();
            SelenideLogger.addListener("allure", new AllureSelenide());

            steps.openSelenideInGithub(URL);
            steps.goToTabIssues();
            steps.shouldSeeIssueWithText(NAME_ISSUE);
        }

    }


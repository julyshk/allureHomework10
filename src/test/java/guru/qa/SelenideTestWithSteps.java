package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.Screenshot;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTestWithSteps {
    public static final String NAME_ISSUE = "SoftAsserts not working with Cucumber/Junit4 runner";
    public static final String URL = "https://github.com/selenide/selenide";

    @Step ("Открываем страницу Selenide в Github")
    void openSelenideInGithub(String url) {
        open(url);
    }

    @Step ("Переходим на вкладку Issues")
    void goToTabIssues() {
        $("#issues-tab").click();
    }

    @Step ("Проверяем наличие Issue с наименованием {issue}")
    void shouldSeeIssueWithText(String issue) {
        $(withText(issue)).should(Condition.exist);
    }

    @Attachment (value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}


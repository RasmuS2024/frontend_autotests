package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;

public class Hooks {

    /**
     * логгер для вывод сообщений о работе хуков
     */
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    /**
     * запускается перед всеми сценариями
     */
    @BeforeAll
    public static void setup() {
        log.info("Установка конфигурации браузера");
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.timeout = 10_000;
        Configuration.headless = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)           // Делать скриншоты при ошибках
                .savePageSource(false)         // Не сохранять HTML страницы
                .includeSelenideSteps(true)                // Добавить каждый шаг Selenide
        );
    }

    /**
     * Выполняктся после каждого сценария
     */
    @After
    public void addScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            if (WebDriverRunner.hasWebDriverStarted()) {
                try {
                    byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver())
                            .getScreenshotAs(OutputType.BYTES);

                    Allure.getLifecycle().addAttachment(
                            "Screenshot on failure",
                            "image/png",
                            "png",
                            new ByteArrayInputStream(screenshot)
                    );
                } catch (Exception e) {
                    log.error("Failed to take screenshot", e);
                }
            }
        }
    }

    /**
    * Выполняется один раз после завершения ВСЕХ сценариев Cucumber.
     */

    @AfterAll
    public static void afterAll() {
        log.info("Закрытие веб-драйвера");
        SelenideLogger.removeListener("AllureSelenide");
        Selenide.closeWebDriver();
    }


}

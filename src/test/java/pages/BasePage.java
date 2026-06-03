package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Базовый класс для всех Page Object
 * Универсальные методы взаим-я
 */
public class BasePage {
    /**
     * Заполняет поле ввода
     * Предварительно выделяет и удаляет текст
     */
    protected void fillField(By locator, String value) {
        String chord = Keys.chord(Keys.COMMAND, "a");
        $(locator).sendKeys(chord);

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.sendKeys(Keys.BACK_SPACE).perform();

        $(locator).clear();
        $(locator).setValue(value);
    }

    /**
     * Нажимает на элемент
     * Перед кликом проверяет, что элемент активен
     */
    protected void click(By locator) {
        $(locator).shouldBe(enabled).click();
    }

    /**
     * Выбирает значение из кастомного выпадающего списка (React/MUI)
     * Кликает по полю, дожидается появления списка и выбирает нужный
     */
    protected void select(By locator, String value) {
        $(locator).shouldBe(visible).click();
        SelenideElement list = $("[role='listbox']");
        SelenideElement option = list.$x(String.format("./li[@data-value='%s']", value));
        option.shouldBe(visible).click();
    }

    /**
     * Проверяет видимый текст
     */
    protected void shouldHaveText(By locator, String text) {
        $(locator).shouldHave(text(text));
    }

    /**
     * Проверяет значение атрибута value у поля ввода
     * Использует Duration.ZERO для мгновенной проверки (без ожидания)
     */
    protected void shouldHaveTextByAttributeValue(By locator, String text) {
        $(locator).shouldHave(attribute("value", text), Duration.ZERO);
    }

}

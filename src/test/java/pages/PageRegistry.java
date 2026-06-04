package pages;

import java.util.Map;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.open;

/**
 * Реестр страниц
 */
public class PageRegistry {
    /**
     * Маршруты
     */
    private static final Map<String, String> routes = Map.of(
            "SampleAppPage", "http://www.uitestingplayground.com/sampleapp",
            "FramesPage", "http://www.uitestingplayground.com/frames"
    );

    /**
     * Фабрики
     */
    private static final Map<String, Supplier<Page>> pages = Map.of(
            "SampleAppPage", SampleAppPage::new,
            "FramesPage", FramesPage::new
    );

    /**
     * Загружает страницу по имени
     * Открывает браузер по соответствующему URL и возвращает объект страницы
     *
     * @param pageName имя страницы (ключ в routes и pages)
     * @return объект запрошенной страницы
     */
    public static Page load(String pageName) {
        System.out.println("Открываю страницу: " + routes.get(pageName));
        open(routes.get(pageName));

        return pages.get(pageName).get();
    }
}
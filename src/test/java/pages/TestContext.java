package pages;

public class TestContext {

    /** Текущая активная стр.
     */
    private static Page currentPage;

    /**
     * Устанавливает текущую стр.
     * @param page объект страницы
     */
    public static void setCurrentPage(Page page) {
        currentPage = page;
    }

    /**
     * Возвращает текущую стр.
     * @return текущий Page Object
     */
    public static Page getCurrentPage() {
        return currentPage;
    }
}

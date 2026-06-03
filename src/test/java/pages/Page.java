package pages;

public interface Page {

    /** Заполняет поле ввода значения */
    void fillField(String fieldName, String value);

    /** Нажимает кнопку */
    void clickButton(String buttonName);

    /** Проверяет текст элемента */
    void checkText(String fieldName, String value);

    /** Проверяет значение атрибута value у поля ввода */
    void checkTextByAttributeValue(String fieldName, String value);

    /** Выбирает значение из выпадающего списка */
    void selectDropdown(String fieldName, String value);
}
# Разработка автотестов для фронтенда

### Тестируемые темы:
На сайте http://www.uitestingplayground.com/home покрыты тестами 5 сценариев (по одному тесту на каждый):
    Sample App + 
    Frames (в процессе)
    3 любые другие темы на твой выбор  (в процессе)

### Установка

Склонируйте репозиторий и войдите в директорию проекта:

```bash
git clone https://github.com/RasmuS2024/frontend_autotests.git
cd frontend_autotests
```

Как запускать тесты:
```bash
./gradlew test
```

### Allure-отчёт

После прогона тестов сформировать и открыть отчёт:

```bash
./gradlew allureReport
./gradlew allureServe
```

- `allureReport` - генерирует HTML-отчёт в папку `build/reports/allure-report/` текущего проекта;
- `allureServe` - запускает локальный веб-сервер и открывает отчёт в браузере.


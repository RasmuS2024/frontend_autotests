# Разработка автотестов для фронтенда

### Тестируемые темы:
Покрыты тестами 5 сценариев с сайта http://www.uitestingplayground.com/home:  
- Sample App (http://www.uitestingplayground.com/sampleapp)  
- Frames (http://www.uitestingplayground.com/frames)  
- Click (http://www.uitestingplayground.com/click)  
- 

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


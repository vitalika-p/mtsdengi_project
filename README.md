# Проект по автоматизации тестовых сценариев для сайта [МТС-Деньги](https://mtsdengi.ru/)
<p align="center">
<a href="https://mtsdengi.ru/"><img width="300" img title="https://mtsdengi.ru/" src="media/logo/logo.png"></a>
</p>


##  Содержание:
- <a href="#tools"> Технологии и инструменты</a>
- <a href="#cases"> Тест-кейсы</a>
- <a href="#autotests"> Запуск автотестов</a>
- <a href="#jenkins"> Сборка в Jenkins</a>
- <a href="#allureReport"> Пример Allure-отчета</a>
- <a href="#allureReport2"> Пример отчета Allure TestOps</a>
- <a href="#tg"> Уведомления в Telegram с использованием бота</a>
- <a href="#movie">Видео примера запуска тестов в Selenoid</a>


Тесты написаны на языке <code>Java</code> с использованием фреймворка для автоматизации тестирования <code>[Selenide](https://selenide.org/)</code>, сборщик - <code>Gradle</code>.
<code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
____
<a id="tools"></a>
## 🔨 Технологии и инструменты:
<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="media/logo/Intelij_IDEA.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="media/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="media/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="media/logo/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="media/logo/JUnit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="media/logo/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="media/logo/Selenoid.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="media/logo/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="media/logo/Allure_Report.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="media/logo/AllureTestOps.svg" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="media/logo/Telegram.svg" width="50"/></a>
</div>

____
<a id="cases"></a>
## 🕵️‍♂️ Тест-кейсы
- Проверка отображения ошибки при отправке пустой формы
- Проверка отображения иконки для перехода к ВКонтакте и переход по ней
- Проверка отображения кнопки 'Войти в интернет-банк' и ее цвета
- Проверка отображения разделов в шапке
- Проверка отображения текста на странице после перехода по кнопке 'Дебетовая карта'
- Проверка перехода к форме оформления карты
- Проверка отображения кнопки 'Ещё' и доп. разделов


____
<a id="autotests"></a>
## ▶️ Команда для запуска автотестов из терминала


```bash 
gradle clean simple_test
```

---
<a id="jenkins"></a>
## <img width="30" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> </a> Сборка в <a target="_blank" href="https://jenkins.autotests.cloud/job/31_mtsdengi/"> Jenkins </a>
Для доступа в Jenkins необходима регистрация на ресурсе [Jenkins](https://jenkins.autotests.cloud/)
Для запуска сборки необходимо нажать кнопку <code>Build now</code>.
<p align="center">
<img title="jenkins" src="media/screens/JenkinsBuild.png">
</p>
После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значки 
<code>Allure Report</code>, при клике на которые откроется страница с сформированным html-отчетом.

____
<a id="allureReport"></a>
## <img width="30" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> </a> Пример <a target="_blank" href="https://jenkins.autotests.cloud/job/c31_vmnqa_mobile_tests_wiki/56/allure/"> Allure-отчета </a>
<p align="center">
<img title="Allure Report" src="media/screens/allure.png">
</p>

____
<a id="allureReport2"></a>
## <img width="30" style="vertical-align:middle" title="Allure Report" src="media/logo/AllureTestOps.svg"> </a> Пример <a target="_blank" href="https://allure.autotests.cloud/launch/44571"> отчета Allure TestOps</a>
<p align="center">
<img title="Allure Report" src="media/screens/allure2.png">
</p>

____
<a id="tg"></a>
## <img width="30" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом
о прогоне тестов в чат
<p align="center" style="background-color: #18222d">
<img width="40%" title="Telegram Notifications" src="media/screens/notification.png">
</p>

____
<a id="movie"></a>
## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>

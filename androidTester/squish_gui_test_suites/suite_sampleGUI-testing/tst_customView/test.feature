# feature-file by Борискин М.А.
Feature: Демонстрация работы фреймворка Squish для Android GUI-тестирования

    Выполнил ст. гр. Java-30 (Технополис) Борискин М.А.

    курс "Автоматизированное тестирование" (2020)

    Scenario: Проверка свойств - картинка по нажатию поворачивается на 90 град.

        Given запустили приложение
          And нажали на кнопку -custom view-
         When нажали на картинку
         Then картинка повернулась на 90 град

    Scenario: Проверка визуально - картинка по нажатию поворачивается на 90 град.

        Given запустили приложение
          And нажали на кнопку -custom view-
         When нажали на картинку
         Then картинка повернулась на 90 град визуально

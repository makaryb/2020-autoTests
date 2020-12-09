# feature-file by Борискин М.А.
Feature: Демонстрация работы фреймворка Squish для Android GUI-тестирования

    Выполнил ст. гр. Java-30 (Технополис) Борискин М.А.

    курс "Автоматизированное тестирование" (2020)

    Scenario: Проверим, что кнопки появляются по нажатию и вызывают другие кнопки

        Given запустили приложение
          And нажали на кнопку -many steps-
          And активна кнопка -show second button-
         When нажали на кнопку -show second button-
         Then стала активной кнопка -show third button-
         When нажали на кнопку -show third button-
         Then стала активной кнопка -hide all buttons-
         When нажали на кнопку -hide all buttons-
         Then исчезли все кнопки, которые были активны до этого шага

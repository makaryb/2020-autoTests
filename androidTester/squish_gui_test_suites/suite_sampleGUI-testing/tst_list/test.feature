# feature-file by Борискин М.А.
Feature: Демонстрация работы фреймворка Squish для Android GUI-тестирования

    Выполнил ст. гр. Java-30 (Технополис) Борискин М.А.

    курс "Автоматизированное тестирование" (2020)

    Scenario: Проверка - изначально в списке 20 элементов

        Given запустили приложение
          And нажали на кнопку -list-
         When промотали список вниз
         Then количество элементов в списке - равно 20-ти

    Scenario: Проверка - удаляются ли элементы списка по нажатию на них

        Given запустили приложение
          And нажали на кнопку -list-
         When нажали на элементы списка: 3, 4, 2
         Then данные элементы должны были исчезнуть из списка

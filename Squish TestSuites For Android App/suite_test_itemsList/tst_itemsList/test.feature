# This is a sample .feature file
# Squish feature files use the Gherkin language for describing features, a short example
# is given below. You can find a more extensive introduction to the Gherkin format at
# https://github.com/cucumber/cucumber/wiki/Gherkin
Feature: Проверить работоспособность системы

    Здесь может быть описание в свободной форме.
    Например, бизнес-цель данной проверки.

    Описание может содержать множество параграфов.

    Scenario: Проверить удаляются ли элементы списка по нажатию на них

        Given запустили приложение
          And нажали на кнопку -list-
         When нажали на элементы списка: 3, 4, 2
         Then данные элементы должны были исчезнуть из списка

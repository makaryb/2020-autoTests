# This is a sample .feature file
# Squish feature files use the Gherkin language for describing features, a short example
# is given below. You can find a more extensive introduction to the Gherkin format at
# https://github.com/cucumber/cucumber/wiki/Gherkin
Feature: Проверить работоспособность системы

    Здесь может быть описание в свободной форме.
    Например, бизнес-цель данной проверки.

    Описание может содержать множество параграфов.

    Scenario: Проверить, что при нажатии на кнопку изменяется текстовое поле

        Given запустили приложение
         When нажали на кнопку -single change-
         Then появился текст -hello Technopolis-
         When нажали на кнопку -change text-
         Then изменился текст в текстовом поле

# This is a sample .feature file
# Squish feature files use the Gherkin language for describing features, a short example
# is given below. You can find a more extensive introduction to the Gherkin format at
# https://github.com/cucumber/cucumber/wiki/Gherkin
Feature: Проверить работоспособность системы

    Здесь может быть описание в свободной форме.
    Например, бизнес-цель данной проверки.

    Описание может содержать множество параграфов.

    Scenario: Проверить появляется ли возможность нажать на новые кнопки

        Given запустили приложение
          And нажали на кнопку -many steps-
         When появился экран с кнопкой, нажали на новую кнопку -show second button-
         Then появилась новая кнопка, нажали на -show third button-
          And появилась новая кнопка, нажали на -hide all buttons-

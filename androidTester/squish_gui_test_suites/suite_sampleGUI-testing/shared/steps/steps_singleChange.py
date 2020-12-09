# -*- coding: utf-8 -*-

# A quick introduction to implementing scripts for BDD tests:
#
# This file contains snippets of script code to be executed as the .feature
# file is processed. See the section 'Behaviour Driven Testing' in the 'API
# Reference Manual' chapter of the Squish manual for a comprehensive reference.
#
# The decorators Given/When/Then/Step can be used to associate a script snippet
# with a pattern which is matched against the steps being executed. Optional
# table/multi-line string arguments of the step are passed via a mandatory
# 'context' parameter:
#
#   @When("I enter the text")
#   def whenTextEntered(context):
#      <code here>
#
# The pattern is a plain string without the leading keyword, but a couple of
# placeholders including |any|, |word| and |integer| are supported which can be
# used to extract arbitrary, alphanumeric and integer values resp. from the
# pattern; the extracted values are passed as additional arguments:
#
#   @Then("I get |integer| different names")
#   def namesReceived(context, numNames):
#      <code here>
#
# Instead of using a string with placeholders, a regular expression can be
# specified. In that case, make sure to set the (optional) 'regexp' argument
# to True.

import names

@Given("нажали на кнопку -singlechange-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Single_change_Button), 96, 103)

@Given("изначальный текст -hello Technopolis!-")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_Hello_Technopolis_Text).text, "Hello Technopolis!",
        "изначальный текст соответсвует ожиданиям")
    test.compare(
        waitForObjectExists(
            names.androidTester_Hello_Technopolis_Text).enabled, True,
        "текстовое поле активно")
    test.compare(
        waitForObjectExists(
            names.androidTester_Hello_Technopolis_Text).visible, True,
        "текстовое поле видимо")

@When("нажали на кнопку -changetext-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Change_text_Button), 123, 83)

@Then("текст изменился на -clicked-")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).enabled, True,
        "текстовое поле активно")
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).visible, True,
        "текстовое поле видимо")
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).text, "Clicked",
        "текст изменился на ожидаемый")

@Given("текст в текстовом поле по прежнему -clicked-")
def step(context):
    startApplication("com.example.hellosquish")
    tapObject(
        waitForObject(
            names.androidTester_Single_change_Button), 135, 63)
    tapObject(
        waitForObject(
            names.androidTester_Change_text_Button), 94, 42)
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).enabled, True,
        "текстовое поле активно")
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).visible, True,
        "текстовое поле видимо")
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).text, "Clicked",
        "изначальный текст соответствует ожиданиям")

@When("повторно нажали на кнопку -singlechange-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Change_text_Button), 132, 84)

@Then("текст в текстовом поле все еще -clicked-")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).enabled, True,
        "текстовое поле активно")
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).visible, True,
        "текстовое поле видимо")
    test.compare(
        waitForObjectExists(
            names.androidTester_Clicked_Text).text, "Clicked",
        "текст не изменился")
    

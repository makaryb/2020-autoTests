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

@Given("нажали на кнопку -many steps-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Many_steps_Button), 133, 84)

@Given("активна кнопка -show second button-")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_Show_second_button_Button).enabled, True,
        "кнопка -show second button- активна")
    test.compare(
        waitForObjectExists(
            names.androidTester_Show_second_button_Button).visible, True,
        "кнопка -show second button- видима")

@When("нажали на кнопку -show second button-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Show_second_button_Button), 110, 41)

@Then("стала активной кнопка -show third button-")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_Show_third_button_Button).enabled, True,
        "кнопка -show third button- активна")
    test.compare(
        waitForObjectExists(
            names.androidTester_Show_third_button_Button).visible, True,
        "кнопка -show third button- видима")

@When("нажали на кнопку -show third button-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Show_third_button_Button), 183, 106)

@Then("стала активной кнопка -hide all buttons-")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_Hide_all_buttons_Button).visible, True,
        "кнопка -hide all buttons- активна")
    test.compare(
        waitForObjectExists(
            names.androidTester_Hide_all_buttons_Button).enabled, True,
        "кнопка -hide all buttons- видима")

@When("нажали на кнопку -hide all buttons-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Hide_all_buttons_Button), 131, 65)

@Then("исчезли все кнопки, которые были активны до этого шага")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_Show_second_button_Button_2).visible, False,
        "кнопка -show second button- скрыта")
    test.compare(
        waitForObjectExists(
            names.androidTester_Show_third_button_Button_2).visible, False,
        "кнопка -show third button- скрыта")
    test.compare(
        waitForObjectExists(
            names.androidTester_Hide_all_buttons_Button_2).visible, False,
        "кнопка -hide all buttons- скрыта")

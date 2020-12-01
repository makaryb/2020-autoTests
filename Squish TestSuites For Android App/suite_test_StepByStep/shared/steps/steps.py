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

@Given("запустили приложение")
def step(context):
    startApplication("com.example.hellosquish")

@Given("нажали на кнопку -many steps-")
def step(context):
    tapObject(waitForObject(names.androidTester_Many_steps_Button), 149, 75)

@When("появился экран с кнопкой, нажали на новую кнопку -show second button-")
def step(context):
    tapObject(waitForObject(names.androidTester_Show_second_button_Button), 124, 55)

@Then("появилась новая кнопка, нажали на -show third button-")
def step(context):
    tapObject(waitForObject(names.androidTester_Show_third_button_Button), 84, 27)

@Then("появилась новая кнопка, нажали на -hide all buttons-")
def step(context):
    tapObject(waitForObject(names.androidTester_Hide_all_buttons_Button), 150, 77)

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

@Given("нажали на кнопку -custom view-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Custom_view_Button), 105, 55)


@When("нажали на картинку")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_rotatingImage_Image).nativeObject.clickable, True,
        "картинка кликабельна")
    tapObject(
        waitForObject(
            names.androidTester_rotatingImage_Image), 114, 135)


@Then("картинка повернулась на 90 град")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_rotatingImage_Image).nativeObject.rotation, 90,
        "картинка повернута на 90 градусов после одного нажатия")
    
    tapObject(
        waitForObject(
            names.androidTester_rotatingImage_Image), 107, 166)
    test.compare(
        waitForObjectExists(
            names.androidTester_rotatingImage_Image).nativeObject.rotation, 180,
        "картинка повернута на 180 градусов после двух нажатий")
    
    tapObject(
        waitForObject(
            names.androidTester_rotatingImage_Image), 106, 151)
    test.compare(
        waitForObjectExists(
            names.androidTester_rotatingImage_Image).nativeObject.rotation, 270,
        "картинка повернута на 270 градусов после трех нажатий")
    
    tapObject(
        waitForObject(
            names.androidTester_rotatingImage_Image), 76, 189)
    test.compare(
        waitForObjectExists(
            names.androidTester_rotatingImage_Image).nativeObject.rotation, 360,
        "картинка повернута на 360 градусов после четырех нажатий")
    
@Then("картинка повернулась на 90 град визуально")
def step(context):
    test.imagePresent("image")    
    
    
    
    
    
    
    
    
    
    
    
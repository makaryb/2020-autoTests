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

@Given("нажали на кнопку -list-")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_List_Button), 139, 87)


@When("промотали список вниз")
def step(context):
    touchAndDrag(
        waitForObject(
            names.androidTester_Element_7_Text), 616, 56, -184, -585)
    touchAndDrag(
        waitForObject(
            names.androidTester_Element_12_Text), 563, 105, -38, -318)
    touchAndDrag(
        waitForObject(
            names.androidTester_Element_15_Text), 556, 127, -221, -617)


@Then("количество элементов в списке - равно 20-ти")
def step(context):
    test.compare(
        waitForObjectExists(
            names.androidTester_list_Panel).nativeObject.adapter.itemCount, 20,
        "количество элементов лист-адаптера равно совпадает с ожидаемым")


@When("нажали на элементы списка: 3, 4, 2")
def step(context):
    tapObject(
        waitForObject(
            names.androidTester_Element_3_Text), 400, 46)
    tapObject(
        waitForObject(
            names.androidTester_Element_3_Text), 457, 81)
    tapObject(
        waitForObject(
            names.androidTester_Element_4_Text), 470, 78)
    tapObject(
        waitForObject(
            names.androidTester_Element_2_Text), 477, 73)
    tapObject(
        waitForObject(
            names.androidTester_Element_2_Text), 433, 97)


@Then("данные элементы должны были исчезнуть из списка")
def step(context):
    test.compare(
        object.exists(names.androidTester_Element_3_Text
                      ), False, "элемент 3 удален по нажатию")
    test.compare(
        object.exists(names.androidTester_Element_4_Text
                      ), False, "элемент 4 удален по нажатию")
    test.compare(
        object.exists(names.androidTester_Element_2_Text
                      ), False, "элемент 2 удален по нажатию")

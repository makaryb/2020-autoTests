package com.boriskin.androidtester.stepbystep

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.boriskin.androidtester.LifecycleWithKaspressoTest
import com.boriskin.androidtester.StepByStepActivity
import com.boriskin.androidtester.instances.StepByStepScreenInstance
import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.junit.Test
import org.junit.runner.RunWith

class CheckAllButtonsAreVisible : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit
        get() = {
            StepByStepScreenInstance {
                firstButton.isVisible()
                secondButton.isVisible()
                thirdButton.isVisible()
            }
        }
}

@RunWith(AndroidJUnit4::class)
class StepByStepActivityWithKaspressoTest :
        LifecycleWithKaspressoTest<StepByStepActivity>(StepByStepActivity::class.java) {

    override fun onSetup() = Unit

    @Test
    fun checkThatOnFirstButtonClickShouldShowSecondButton() {
        run {
            // Kaspresso Test
            StepByStepScreenInstance {
                // синтаксис Kakao
                // step-by-step
                step("Click first button") { firstButton { click() } }
                step("Check if second button visible") {
                    firstButton { isVisible() }
                }
            }
        }
    }

    @Test
    fun checkThatOnBothButtonsClickShouldShowAllButtons() {
        StepByStepScreenInstance {
            before {
                // подготовка
            }.after {
                // по окончанию теста
            }.run {
                step("Click first button") { firstButton.click() }
                step("Click second button") { secondButton.click() }
                step("Check if all buttons are visible") {
                    CheckAllButtonsAreVisible()
                }
            }
        }
    }
}


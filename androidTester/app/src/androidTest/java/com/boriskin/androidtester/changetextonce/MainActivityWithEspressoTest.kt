package com.boriskin.androidtester.changetextonce

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.boriskin.androidtester.R
import com.boriskin.androidtester.ChangeTextOnceActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityWithEspressoTest {

    @get:Rule
    val activityRule = ActivityTestRule(ChangeTextOnceActivity::class.java)

    @Test
    fun checkThatMainTextFieldChangeTextAfterClickedOnButton() {
        Espresso
                .onView(ViewMatchers.withId(R.id.button))
                .perform(ViewActions.click())

        Espresso
                .onView(ViewMatchers.withId(R.id.textView))
                .check(ViewAssertions.matches(ViewMatchers.withText("Clicked")))
    }
}

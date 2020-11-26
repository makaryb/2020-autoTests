package com.boriskin.androidtester.changetextonce

import androidx.core.view.isVisible
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.boriskin.androidtester.R
import com.boriskin.androidtester.ChangeTextOnceActivity
import com.boriskin.androidtester.onStop
import kotlinx.android.synthetic.main.activity_single_change.button
import kotlinx.android.synthetic.main.activity_single_change.logoView
import kotlinx.android.synthetic.main.activity_single_change.textView
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChangeTextOnceWithScenarioActivityTest {

    private lateinit var activity: ActivityScenario<ChangeTextOnceActivity>

    @Before
    fun setup() {
        // Изачально установлен стэйт RESUMED
        activity = launchActivity()

        // Когда активити запущено, проверить -соблюдены ли начальные условия для проведения теста
        activity.onActivity {
            assert(!it.logoView.isVisible)
            assert(it.button.isVisible)
            assert(it.textView.isVisible)
        }
    }

    @Test
    fun showSavedTextWhenActivityIsRecreated() {
        // SAVE_INSTANCE -> DESTROYED -> RESUMED
        activity.recreate()

        onView(withId(R.id.textView))
                .check(matches(withText("State saved")))
    }

    @Test
    fun showAlertWhenUserStoppedApp() {
        activity.onStop()

        onView(withId(R.id.logoView)).check(matches(isDisplayed()))
    }

    @After
    fun release() {
        activity.close()
    }
}

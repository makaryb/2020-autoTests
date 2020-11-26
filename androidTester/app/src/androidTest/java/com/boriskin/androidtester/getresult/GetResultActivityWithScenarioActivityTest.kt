package com.boriskin.androidtester.getresult

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import com.boriskin.androidtester.GetResultActivity
import org.junit.Before
import org.junit.Test

class GetResultActivityWithScenarioActivityTest {
    private lateinit var activityScenario: ActivityScenario<GetResultActivity>

    @Before
    fun setup() {
        // Изначально стэйт RESUMED
        activityScenario = launchActivity()
    }

    @Test
    fun checkThatActivityTerminateWithResult() {
        with(activityScenario) {
            assert(result.resultCode == Activity.RESULT_OK)
        }
    }
}

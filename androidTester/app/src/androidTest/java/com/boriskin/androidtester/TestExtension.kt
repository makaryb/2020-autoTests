package com.boriskin.androidtester

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario

fun ActivityScenario<out Activity>.onStop() {
    // После onStop() будет следующий стэйт
    moveToState(Lifecycle.State.CREATED)
    // Test case будет ожидать получения стэйта: RESUME
    moveToState(Lifecycle.State.RESUMED)
}

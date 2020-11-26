package com.boriskin.androidtester.instances

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.boriskin.androidtester.R

object StepByStepScreenInstance : Screen<StepByStepScreenInstance>() {
    val firstButton = KButton {
        withId(R.id.actionShowSecond)
    }
    val secondButton = KButton {
        withId(R.id.actionShowThird)
    }
    val thirdButton = KButton {
        withId(R.id.actionHideAll)
    }
}

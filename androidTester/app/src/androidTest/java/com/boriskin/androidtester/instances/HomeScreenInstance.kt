package com.boriskin.androidtester.instances

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.boriskin.androidtester.R

class HomeScreenInstance : Screen<HomeScreenInstance>() {
    val button = KButton {
        withId(R.id.button)
    }
    val field = KTextView {
        withId(R.id.textView)
    }
}

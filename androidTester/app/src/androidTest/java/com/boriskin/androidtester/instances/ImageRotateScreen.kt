package com.boriskin.androidtester.instances

import android.view.View
import androidx.test.espresso.DataInteraction
import com.agoda.kakao.common.actions.BaseActions
import com.agoda.kakao.common.builders.ViewBuilder
import com.agoda.kakao.common.views.KBaseView
import com.agoda.kakao.screen.Screen
import com.boriskin.androidtester.R
import com.boriskin.androidtester.AssertionsForImageRotate
import org.hamcrest.Matcher

class ImageRotateScreen : Screen<ImageRotateScreen>() {
    // для того, чтобы использовать как обычный kotlin synthetic view
    val image = KRotatingImageView {
        withId(R.id.rotatingImage)
    }
}

/**
 * KBaseView<KRotatingImageView> - должен быть определен;
 * BaseActions - определенное действие. Есть набор предопределенных;
 * RotatingViewAssertions - можно передавать любые свои проверки.
 */
class KRotatingImageView :
        KBaseView<KRotatingImageView>,
        BaseActions,
        AssertionsForImageRotate
{
    // Add all possible constructors
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(parent: Matcher<View>, function: ViewBuilder.() -> Unit) : super(parent, function)
    constructor(parent: DataInteraction, function: ViewBuilder.() -> Unit) : super(parent, function)
}

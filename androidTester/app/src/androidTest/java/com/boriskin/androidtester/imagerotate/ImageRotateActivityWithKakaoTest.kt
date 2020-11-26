package com.boriskin.androidtester.imagerotate

import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.boriskin.androidtester.LifecycleTest
import com.boriskin.androidtester.instances.ImageRotateScreen
import com.boriskin.androidtester.rotation.ImageRotateActivity
import org.junit.Test

class ImageRotateActivityWithKakaoTest :
        LifecycleTest<ImageRotateActivity>(ImageRotateActivity::class.java) {

    override fun onSetup() = Unit

    @Test
    fun checkThatViewRotateDefaultDegreesAfterClick() {
        onScreen<ImageRotateScreen> {
            image {
                click()
                isRotated(90)
            }
        }
    }
}

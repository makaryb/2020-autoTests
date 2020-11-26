package com.boriskin.androidtester

import android.view.View
import androidx.test.espresso.assertion.ViewAssertions
import com.agoda.kakao.common.assertions.BaseAssertions
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

/**
 * Метод проверки правильности вращения элемента
 */
interface AssertionsForImageRotate : BaseAssertions {
    fun isRotated(angle: Int) {
        view.check(
                ViewAssertions.matches(
                        RotationMatcher(angle.toFloat())
                )
        )
    }
}

/**
 * Для проверки совпадают ли угол, на который был осуществлен поворот, и заданный угол поворота
 */
class RotationMatcher(private val rotation: Float) : TypeSafeMatcher<View>() {

    override fun describeTo(description: Description?) {
        description?.appendText("is rotated by $rotation angle")
    }

    override fun matchesSafely(item: View?): Boolean = item?.rotation == rotation
}

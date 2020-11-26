package com.boriskin.androidtester.rotation

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class ImageRotateView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attributeSet, defStyleAttr) {

    init {
        setOnClickListener {
            it.rotation += ROTATION_DEGREES
        }
    }

    companion object {
        const val ROTATION_DEGREES = 90
    }
}

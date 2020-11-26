package com.boriskin.androidtester.rotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boriskin.androidtester.R

class ImageRotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotating_image)
    }
}

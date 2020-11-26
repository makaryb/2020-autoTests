package com.boriskin.androidtester

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_many_steps.actionHideAll
import kotlinx.android.synthetic.main.activity_many_steps.actionShowSecond
import kotlinx.android.synthetic.main.activity_many_steps.actionShowThird

class StepByStepActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_many_steps)

        actionShowSecond.setOnClickListener {
            actionShowThird.isVisible = true
        }

        actionShowThird.setOnClickListener {
            actionHideAll.isVisible = true
        }

        actionHideAll.setOnClickListener {
            actionShowSecond.isVisible = false
            actionShowThird.isVisible = false
            actionHideAll.isVisible = false
        }
    }
}

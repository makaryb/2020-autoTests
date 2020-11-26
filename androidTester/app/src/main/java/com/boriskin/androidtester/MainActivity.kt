package com.boriskin.androidtester

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boriskin.androidtester.list.ItemsListActivity
import com.boriskin.androidtester.rotation.ImageRotateActivity
import kotlinx.android.synthetic.main.activity_main.actionSingleChange
import kotlinx.android.synthetic.main.activity_main.actionList
import kotlinx.android.synthetic.main.activity_main.actionCustomView
import kotlinx.android.synthetic.main.activity_main.actionManySteps
import kotlinx.android.synthetic.main.activity_main.actionWithResult
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionSingleChange.setOnClickListener {
            start(ChangeTextOnceActivity::class)
        }
        actionList.setOnClickListener {
            start(ItemsListActivity::class)
        }
        actionCustomView.setOnClickListener {
            start(ImageRotateActivity::class)
        }
        actionManySteps.setOnClickListener {
            start(StepByStepActivity::class)
        }
        actionWithResult.setOnClickListener {
            start(GetResultActivity::class)
        }
    }

    private fun start(kClass: KClass<out Activity>) {
        startActivity(Intent(this, kClass.java))
    }
}

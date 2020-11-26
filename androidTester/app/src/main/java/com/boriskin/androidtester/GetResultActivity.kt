package com.boriskin.androidtester

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GetResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        GlobalScope.launch(Dispatchers.Main) {
            delay(DELAY_TIME)
            setResult(RESULT_OK)
            finish()
        }
    }

    companion object {
        const val DELAY_TIME: Long = 2000
    }
}

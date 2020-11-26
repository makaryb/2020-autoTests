package com.boriskin.androidtester

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_single_change.button
import kotlinx.android.synthetic.main.activity_single_change.textView
import kotlinx.android.synthetic.main.activity_single_change.logoView

private const val EXTRA_TEXT_FIELD = "MainActivity.textField"

class SingleChangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_change)

        button.setOnClickListener {
            textView.text = getString(R.string.clicked)
        }
    }

    override fun onStop() {
        showLogo()
        super.onStop()
    }

    private fun showLogo() {
        logoView.isVisible = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_TEXT_FIELD, "State saved")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString(EXTRA_TEXT_FIELD)
    }
}

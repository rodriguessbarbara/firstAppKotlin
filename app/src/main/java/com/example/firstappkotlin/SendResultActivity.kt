package com.example.firstappkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

class SendResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_result)

        val btnYes = findViewById<Button>(R.id.btnYes)
        val btnNo = findViewById<Button>(R.id.btnNo)
        val btnCancel = findViewById<Button>(R.id.btnCancel)


        btnYes.setOnClickListener {
            sendResult(R.string.yes)
        }

        btnNo.setOnClickListener{
            sendResult(R.string.no)
        }

        btnCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)

            finish()
        }
    }

    private fun sendResult(@StringRes stringResId: Int) {
        val intent = Intent()
        intent.putExtra("RESULT", getString(stringResId))
        setResult(RESULT_OK, intent)

        finish()
    }
}
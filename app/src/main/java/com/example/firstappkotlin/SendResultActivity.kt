package com.example.firstappkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SendResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_result)

        val btnYes = findViewById<Button>(R.id.btnYes)
        val btnNo = findViewById<Button>(R.id.btnNo)

        btnYes.setOnClickListener {
            val intent = Intent()
            intent.putExtra("RESULT", getString(R.string.yes))
            setResult(Activity.RESULT_OK, intent)

            finish()
        }

        btnNo.setOnClickListener{
            val intent = Intent()
            intent.putExtra("RESULT", getString(R.string.no))
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
}
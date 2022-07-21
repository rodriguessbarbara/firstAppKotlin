package com.example.firstappkotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResultado = findViewById<TextView>(R.id.textoView)
        val nome = findViewById<EditText>(R.id.editTextTextName)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val btnEnviar2 = findViewById<Button>(R.id.btnEnviar2)
        val btnEnviar3 = findViewById<Button>(R.id.btnEnviar3)


        btnEnviar.setOnClickListener {
            if (nome.text.isNotBlank()) {
                tvResultado.text = getString(R.string.hello_name, nome.text.toString())
            } else {
                nome.error = getString(R.string.type_your_name)
            }
        }

        btnEnviar2.setOnClickListener {
            if (nome.text.isNotBlank()) {
                val nomeDigitado = nome.text.toString()
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("NOME_DIGITADO", nomeDigitado)

                startActivity(intent)
            } else {
                nome.error = getString(R.string.type_your_name)
            }
        }

        btnEnviar3.setOnClickListener {
            val intent = Intent(this, SendResultActivity::class.java)
            val requestCode = 1

            startActivityForResult(intent, requestCode)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 ) {

            if (resultCode == Activity.RESULT_OK && data != null) {
                val result = data.getStringExtra("RESULT")
                val tvResultado = findViewById<TextView>(R.id.textoView)
                tvResultado.text = getString(R.string.data_received, result)

            } else if (requestCode == Activity.RESULT_CANCELED ) {
                val tvResultado = findViewById<TextView>(R.id.textoView)
                tvResultado.text = getString(R.string.Activity_was_cancelled)
            }
        }

    }
}
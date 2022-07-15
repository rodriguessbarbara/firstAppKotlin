package com.example.firstappkotlin

import android.annotation.SuppressLint
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
    }
}
package com.example.firstappkotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val nomeDigitado = intent.getStringExtra("NOME_DIGITADO")
        val tvResultado = findViewById<TextView>(R.id.textoView)

        tvResultado.text = nomeDigitado
    }
}
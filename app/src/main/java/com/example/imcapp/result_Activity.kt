package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val dados = intent.extras

        valorIMC.text = dados?.getString("valorIMC")
        avaliar(dados?.getFloat("imcFloat"))
    }

    private fun avaliar (valor: Float?){
        if (valor != null) {
            if (valor<=18.5) {
                avaliacaoIMC.text = getString(R.string.info_desnutricao)
                imagem.setImageResource(R.drawable.desnutricao)}
            else if (valor>18.5 && valor<=24.9) {avaliacaoIMC.text = getString(R.string.info_pesoIdeal)
                imagem.setImageResource(R.drawable.pesoideal)}
            else if (valor>24.9 && valor<=29.9) {avaliacaoIMC.text = getString(R.string.info_sobrePeso)
                imagem.setImageResource(R.drawable.sobrepeso)}
            else {
                avaliacaoIMC.text = getString(R.string.info_obesidade)
                imagem.setImageResource(R.drawable.obesidade)
            }
        }
    }
}


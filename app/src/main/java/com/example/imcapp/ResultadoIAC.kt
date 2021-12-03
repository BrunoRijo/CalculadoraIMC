package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_resultado_iac.*

class ResultadoIAC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_iac)

        val dados = intent.extras

        resultadoIAC.text = dados?.getString("valorIAC")
        dados?.getFloat("iacFloat")?.let { avaliacao(it) }
    }

    private fun avaliacao(valorIAC:Float){
        if (valorIAC != null) {
            if (valorIAC>=8.0 && valorIAC<=21.0) {
                avaliaIAC.text = getString(R.string.adiposidade_normal)
            }
            else if (valorIAC>21.0 && valorIAC<=25.9) {
                avaliaIAC.text = getString(R.string.adiposidade_sobrepeso)
            }
            else {
                avaliaIAC.text = getString(R.string.adiposidade_obesidade)
            }
        }
    }

}
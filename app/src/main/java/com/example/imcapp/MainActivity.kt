package com.example.imcapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()


    }

    private fun setListeners() {
        chave.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                //Para calcular o IAC
                calcularBTN.setEnabled(false)
                calcularIAC.setEnabled(true)
                titleTXT.text = "IAC"
                pesoEDIT.hint = getString(R.string.cintura_hint)
            }
            else {
                //Para calcular o IMC
                calcularBTN.setEnabled(true)
                calcularIAC.setEnabled(false)
                titleTXT.text = "IMC"
                pesoEDIT.hint = getString(R.string.peso_hint)
            }
        }
        calcularBTN.setOnClickListener { calcularIMC(pesoEDIT.text.toString(), alturaEDIT.text.toString()) }
        calcularIAC.setOnClickListener{ calcularIAC(pesoEDIT.text.toString(), alturaEDIT.text.toString()) }
    }

    private fun calcularIMC (peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura =  altura.toFloatOrNull()
        if ( peso != null && altura != null){
            val imc =  peso / (altura*altura)
            val telaResultado = Intent(this, result_Activity::class.java)
            telaResultado.putExtra("valorIMC", imc.toString())
            telaResultado.putExtra("imcFloat", imc)
            startActivity(telaResultado)
        }
    }

    private fun calcularIAC (cintura:String, altura: String){
        val cintura = cintura.toFloatOrNull()
        val altura =  altura.toFloatOrNull()
        if ( cintura != null && altura != null){
            val iac =  (cintura/(altura*sqrt(altura)))-18
            val resultadoIAC = Intent(this, ResultadoIAC::class.java)
            resultadoIAC.putExtra("valorIAC", iac.toString())
            resultadoIAC.putExtra("iacFloat", iac)
            startActivity(resultadoIAC)
        }
    }
}
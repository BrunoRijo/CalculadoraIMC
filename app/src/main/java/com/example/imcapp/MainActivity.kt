package com.example.imcapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        calcularBTN.setOnClickListener { calcularIMC(pesoEDIT.text.toString(), alturaEDIT.text.toString()) }
    }

    private fun calcularIMC (peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura =  altura.toFloatOrNull()
        if ( peso != null && altura != null){
            val imc =  peso / (altura*altura)
            titleTXT?.text = "O seu IMC é "+imc
        }
    }
}
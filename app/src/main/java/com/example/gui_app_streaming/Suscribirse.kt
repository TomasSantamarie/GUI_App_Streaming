package com.example.gui_app_streaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.view.isGone
import com.example.gui_app_streaming.databinding.ActivitySuscribirseBinding

class Suscribirse : AppCompatActivity() {
    private lateinit var binding: ActivitySuscribirseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuscribirseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // para desaparecer en un principio elementos que no querramos que el usuario pueda ver
        binding.contenedor2.isGone=true
        binding.textAparecer1.isGone= true
        binding.textAparecer2.isGone= true
        binding.textAparecer3.isGone= true
        binding.textAparecer4.isGone= true
        binding.textAparecer5.isGone= true
        binding.textAparecer6.isGone= true
        binding.textAparecer7.isGone= true

        var email = ""
        binding.sesion.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        //Esto lo que hace es que cuando el usuario interactua con dicho editText este quede guardado en una variable llamada email
        binding.correo2.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                email=binding.correo2.text.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {} })

        // setOnClickListener hace referencia a cuando el usuario clica sobre el elemento tu puedas hacer que se desencadene determinadas acciones
        binding.empezar.setOnClickListener {
            // prevención de errores
            if (binding.correo2.text.isNullOrEmpty() || !binding.correo2.text.toString().contains("@gmail")) {
                binding.contenedor2.isGone = false
            }
            else {

                val intent = Intent(this, Registro::class.java).apply {
                    putExtra("email", email)
                }
                startActivity(intent)
            }
        }

        binding.button2.setOnClickListener{

            if (binding.button2.text.toString()=="+"){
                binding.textAparecer1.isGone=false
                binding.button2.text ="x"
            }
            else {
                binding.textAparecer1.isGone = true
                binding.button2.text ="+"
            }
        }
        binding.button3.setOnClickListener{

            if (binding.button3.text.toString()=="+"){
                binding.textAparecer2.isGone=false
                binding.button3.text ="x"
            }
            else {
                binding.textAparecer2.isGone = true
                binding.button3.text ="+"
            }
        }
        binding.button4.setOnClickListener{

            if (binding.button4.text.toString()=="+"){
                binding.textAparecer3.isGone=false
                binding.button4.text ="x"
            }
            else {
                binding.textAparecer3.isGone = true
                binding.button4.text ="+"
            }
        }
        binding.button5.setOnClickListener{

            if (binding.button5.text.toString()=="+"){
                binding.textAparecer4.isGone=false
                binding.button5.text ="x"
            }
            else {
                binding.textAparecer4.isGone = true
                binding.button5.text ="+"
            }
        }
        binding.button6.setOnClickListener{

            if (binding.button6.text.toString()=="+"){
                binding.textAparecer5.isGone=false
                binding.button6.text ="x"
            }
            else {
                binding.textAparecer5.isGone = true
                binding.button6.text ="+"
            }
        }
        binding.button7.setOnClickListener{

            if (binding.button7.text.toString()=="+"){
                binding.textAparecer6.isGone=false
                binding.button7.text ="x"
            }
            else {
                binding.textAparecer6.isGone = true
                binding.button7.text ="+"
            }
        }
        binding.button8.setOnClickListener{

            if (binding.button8.text.toString()=="+"){
                binding.textAparecer7.isGone=false
                binding.button8.text ="x"
            }
            else {
                binding.textAparecer7.isGone = true
                binding.button8.text ="+"
            }

        }


    }
}
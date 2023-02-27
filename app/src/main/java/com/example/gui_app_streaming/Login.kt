package com.example.gui_app_streaming

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.gui_app_streaming.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var pulsado = false
        binding.informacion.isGone=false
        binding.texto.isInvisible = true
        binding.contenedor.isGone=true
        binding.contenedor2.isGone=true

        val bundle = intent.extras
        val pss = bundle?.getString("contraseña")
        val email = bundle?.getString("email")

        binding.correo.setText(email)
        binding.contrasena1.setText(pss)

        // setOnClickListener hace referencia a cuando el usuario clica sobre el elemento tu puedas hacer que se desencadene determinadas acciones
        binding.recordar.setOnClickListener {
            if (pulsado) {
                binding.recordar.isChecked = false
            }
            pulsado = true
        }

        binding.ayuda.setOnClickListener {
            val intent = Intent(this, Informacion::class.java)
            startActivity(intent)
        }

        binding.informacion.setOnClickListener{
            binding.informacion.isGone= true
            binding.texto.isVisible = true
        }
        binding.subscribirse.setOnClickListener{
            val intent = Intent(this, Suscribirse::class.java)
            startActivity(intent)
        }

        binding.registrar.setOnClickListener{ acceder()}
    }
    @SuppressLint("SuspiciousIndentation")
    // Esta clase sirve para comprobar si el email y la contraseña que ha metido el usuario en el EditText son correctos
    private fun acceder() {

        val email = binding.correo.text
        val pss = binding.contrasena1.text

            if (email.isNotEmpty() && pss.isNotEmpty()){

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email.toString(),
                        pss.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            cambioPagina()
                        }else {
                            binding.contenedor.isGone=false
                            binding.contenedor2.isGone = !(pss.length<4 || pss.length>60)
                        }
                    }
            }

    }
    private fun cambioPagina() {
        val intent = Intent(this, Aplicacion::class.java)
        startActivity(intent)
    }
}
package com.example.gui_app_streaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.core.view.isGone
import com.example.gui_app_streaming.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
        val bundle = intent.extras
        val email = bundle?.getString("email")
        Log.v("email", email.toString())
        binding.correo.setText(email)

        binding.contenedor1.isGone = true
        binding.contenedor2.isGone = true
        binding.contenedor3.isGone = true
        binding.texto.isGone= true



        binding.sesion.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.registrar.setOnClickListener { acceder() }

        binding.informacion.setOnClickListener{
            binding.texto.isGone= false
        }



    }
    //Con esto el usuario puede crear una cuenta y que se guarde en Firebase . Tiene integrado una prevención de errores en el
    private fun acceder() {

        val email = binding.correo.text
        val contrasena = binding.contrasena1.text
        Log.v("email", email.toString())
        Log.v("contrasena", email.toString())
        if (email.isNotEmpty() && contrasena.isNotEmpty()) {
            if (binding.contrasena1.text.toString().length < 8 || binding.contrasena1.text.toString().length > 60) {
                binding.contenedor2.isGone = false
                binding.aviso2.text = "La contraseña debe tener entre 8 y 60 caracteres"
                Log.v("Aviso", "La contraseña debe tener entre 8 y 60 caracteres")
            } else {
                if (!binding.contrasena1.text.toString()
                        .equals(findViewById<EditText>(R.id.contrasena2).text.toString())
                ) {
                    binding.contenedor2.isGone = false
                    binding.contenedor3.isGone = false
                    binding.aviso2.text = "Las contraseñas no coinciden"
                    binding.aviso3.text = "Las contraseñas no coinciden"
                    Log.v("Aviso", "Las contraseñas no coinciden")
                } else {
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(
                            email.toString(),
                            contrasena.toString()
                        ).addOnCompleteListener {

                            if (it.isSuccessful) {
                                cambioPagina2(it.result?.user?.email ?: "", contrasena.toString())
                            } else {
                                binding.contenedor1.isGone = false
                                binding.aviso.text = "Correo o teléfono no válido"
                            }
                        }
                }
            }

        }

    }

    private fun cambioPagina2(email: String, contrasena: String) {

        val registroIntent = Intent(this, Login::class.java).apply {
            putExtra("email", email)
            putExtra("contraseña", contrasena)
        }
        startActivity(registroIntent)
    }
}
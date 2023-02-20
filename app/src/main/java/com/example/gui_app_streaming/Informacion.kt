package com.example.gui_app_streaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import com.example.gui_app_streaming.databinding.ActivityInformacionBinding
import com.example.gui_app_streaming.databinding.ActivityRegistroBinding

class Informacion : AppCompatActivity() {
    private lateinit var binding: ActivityInformacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.textMensaje.isGone=true
        binding.escribirtelefono.isGone=true
        binding.botonCorreo.isChecked = true
        binding.masInformacion.isGone=false
        binding.informacionExtra.isGone=true

        binding.iniciar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.botonCorreo.setOnClickListener{
            binding.botonMensaje.isChecked = false
            binding.textMensaje.isGone=true
            binding.textCorreo.isGone=false
            binding.escribirtelefono.isGone=true
            binding.escribirCorreo.isGone=false
            binding.enviar.text="ENVIARME CORREO"
        }
        binding.botonMensaje.setOnClickListener{
            binding.botonCorreo.isChecked = false
            binding.textMensaje.isGone=false
            binding.textCorreo.isGone=true
            binding.escribirtelefono.isGone=false
            binding.escribirCorreo.isGone=true
            binding.enviar.text="ENVIARME SMS"

        }

        binding.masInformacion.setOnClickListener{
            binding.masInformacion.isGone=true
            binding.informacionExtra.isGone=false
        }
    }
}
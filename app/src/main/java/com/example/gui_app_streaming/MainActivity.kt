package com.example.gui_app_streaming

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.gui_app_streaming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var pulsado = false
        binding.informacion.isGone=false
        binding.texto.isInvisible = true

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

        }
    }
}
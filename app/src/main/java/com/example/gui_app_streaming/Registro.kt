package com.example.gui_app_streaming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gui_app_streaming.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }
}
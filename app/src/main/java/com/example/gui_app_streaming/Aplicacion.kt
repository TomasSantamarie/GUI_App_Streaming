package com.example.gui_app_streaming

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gui_app_streaming.databinding.ActivityAplicacionBinding
import com.example.gui_app_streaming.databinding.ActivityInformacionBinding

class Aplicacion : AppCompatActivity() {
    private lateinit var binding: ActivityAplicacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAplicacionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // Lo que hace este código es:

        // Al clicar en las peliculas seleccionadas, te llevarán fuera de la app hasta
        // youtube y dirigirte al trailer de dicha película

        binding.imageButton3.setOnClickListener{
            var url = "https://www.youtube.com/watch?v=8UwxL-Zheqk";
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        binding.imageButton7.setOnClickListener{
            var url = "https://www.youtube.com/watch?v=1k7o3GUDsiQ";
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
        binding.imageButton11.setOnClickListener{
            var url = "https://www.youtube.com/watch?v=u7h4v79F0L4";
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
        binding.imageButton15.setOnClickListener{
            var url = "https://www.youtube.com/watch?v=9-5lG4mNVWU";
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}
package com.example.gui_app_streaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import com.example.gui_app_streaming.databinding.ActivityRegistroBinding
import com.example.gui_app_streaming.databinding.ActivitySuscribirseBinding

class Suscribirse : AppCompatActivity() {
    private lateinit var binding: ActivitySuscribirseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuscribirseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.textAparecer1.isGone= true
        binding.textAparecer2.isGone= true
        binding.textAparecer3.isGone= true
        binding.textAparecer4.isGone= true
        binding.textAparecer5.isGone= true
        binding.textAparecer6.isGone= true
        binding.textAparecer7.isGone= true

        binding.sesion.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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
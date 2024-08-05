package com.example.gorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorjeta.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalConta = intent.getFloatExtra("totalCont", 0.0f)
        val totalPeople = intent.getIntExtra("totalPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val total = intent.getFloatExtra("total",0.0f)

       binding.tvTotal.text = total.toString()
        binding.tvTotalResult.text = totalConta.toString()
        binding.tvPessoasResult.text = totalPeople.toString()
        binding.tvPorcentagemResult.text = "$percentage %"
    }
}
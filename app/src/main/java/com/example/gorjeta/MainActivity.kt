package com.example.gorjeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ResultReceiver
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.gorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
         binding.rdOne.setOnCheckedChangeListener(){_, isChecked ->
             if (isChecked) {
                 percentage = 10
             }
         }

        binding.rdTwo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 15
            }
        }

        binding.rdTree.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 20
            }
        }

        binding.rdFour.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 25
            }
        }



        binding.btnCalcular.setOnClickListener(){
            val totalContTemp = binding.tieTotal.text
            val totalPeopleTemp = binding.tiePeople.text



            if(totalContTemp?.isEmpty() == true ||
                totalPeopleTemp?.isEmpty() == true
                ){
                Snackbar.make(binding.tieTotal,"Preencha todos os campos", Snackbar.LENGTH_LONG).show()
            } else {
                val totalCont= totalContTemp.toString().toFloat()
                val  totalPeople = totalPeopleTemp.toString().toInt()

                val totalResult = totalCont / totalPeople
                val percent = totalResult * percentage / 100
                val totalPercent =  totalResult + percent


                val intent = Intent (this, ResultActivity::class.java)
                intent.apply{
                    putExtra("totalCont", totalCont)
                    putExtra("totalPeople", totalPeople)
                    putExtra("percentage", percentage)
                    putExtra("total",totalPercent)
                }
                startActivity(intent)
            }


                binding.btnClean.setOnClickListener(){
                binding.tvResult.text = ""
                binding.tieTotal.setText("")
                binding.tiePeople.setText("")
                binding.rdOne.isChecked = false
                binding.rdTwo.isChecked = false
                binding.rdTree.isChecked = false
                binding.rdFour.isChecked = false
            }

            }
        }

    }
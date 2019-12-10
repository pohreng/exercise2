package com.example.labexercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculate()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clear()
        }
    }

    private fun calculate() {
        val h = findViewById<EditText>(R.id.editTextHeight)
        val w = findViewById<EditText>(R.id.editTextWeight)
        val bmi = findViewById<TextView>(R.id.textViewBMI)

        if (h.text.isBlank() || w.text.isBlank()){
            h.setText(R.string.input_error)
            w.setText(R.string.input_error)
        }else{
            val bmiResult = w.text.toString().toInt() / ((h.text.toString().toDouble()/100)*(h.text.toString().toDouble()/100))
            val twoDecimalBmi:Double = Math.round(bmiResult * 100.0) / 100.0

            bmi.setText(bmi.text.toString().plus(twoDecimalBmi.toString()))
            if(bmiResult<18.5)
                imageViewProfile.setImageResource(R.drawable.under)
            if (bmiResult>=18.5 && bmiResult < 25)
                imageViewProfile.setImageResource(R.drawable.normal)
            if(bmiResult>=25)
                imageViewProfile.setImageResource(R.drawable.over)


        }
    }
    private fun clear(){
        editTextWeight.setText("")
        editTextHeight.setText("")
        imageViewProfile.setImageResource(R.drawable.empty)
        textViewBMI.setText(R.string.bmi)
    }

}

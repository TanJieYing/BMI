package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

//variableName : Type
//val = value, var = variable
//e.g. val pi : Double = 3.14159 or val pi = 3.14159
//e.g. var number : Float

class MainActivity : AppCompatActivity() { //MainActivity is a subclass of AppCompatActivity
    //declare global variables here

    override fun onCreate(savedInstanceState: Bundle?) { //first method to be executed
        super.onCreate(savedInstanceState) //inherit everything from AppCompatActivity
        setContentView(R.layout.activity_main) //display UI

        //link UI to program
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)

        buttonCalculate.setOnClickListener {
            //to retrieve value from a View
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height: Float = editTextHeight.text.toString().toFloat()

            val bmi = weight/(height/100).pow(2)
            //val bmi = weight / Math.pow(height/100, 2.0)

            //TODO: Determine status of BMI and present the result to the user
            //underweight <= 18.5
            //normal = 18.5 - 24.9
            //overweight >= 25

            if (bmi <= 18.5) {
                textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.underweight))
                //textViewBMI.text = "BMI : ${bmi.toString()}, Status : ${getString(R.string.underweight)}"
                imageViewBMI.setImageResource(R.drawable.under)
            } else if (bmi <= 24.9 ) {
                textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.normal))
                imageViewBMI.setImageResource(R.drawable.normal)
            } else {
                textViewBMI.text = String.format("%1.2f, %s", bmi, getString(R.string.overweight))
                imageViewBMI.setImageResource(R.drawable.over)
            }

        }

        buttonReset.setOnClickListener {
            editTextWeight.text.clear() // = null
            editTextHeight.text.clear()
            textViewBMI.text = ""
            imageViewBMI.setImageResource(R.drawable.empty)
        }

    }
}
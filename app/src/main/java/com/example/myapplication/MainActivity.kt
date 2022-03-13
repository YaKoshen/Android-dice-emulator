package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import diceemu.*
import kotlin.text.toIntOrNull


class MainActivity : AppCompatActivity() {
    private lateinit var maxNumber: EditText
    private lateinit var randomNumber: TextView

    private lateinit var buttonGenerate: Button
    private lateinit var buttonMultiRandom: Button

    private var infoToast = InfoToast(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maxNumber = findViewById<EditText>(R.id.editTextMaximumNumber)
        randomNumber = findViewById<TextView>(R.id.textViewRusult)

        buttonMultiRandom = findViewById<Button>(R.id.buttonMultiRandom)
        buttonGenerate = findViewById<Button>(R.id.buttonGenerate)

        buttonMultiRandom.setOnClickListener {
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            startActivity(secondActivityIntent)
        }

        buttonGenerate.setOnClickListener {
            var strMaxNum = maxNumber.text.toString()
            var maxNum = strMaxNum.toIntOrNull()

            when {
                maxNum == null -> {
                    infoToast.error("Please fill Maximum number")
                }
                else -> {
                    randomNumber.text = Calc().randomNumber(maxNum).toString()
                }
            }
        }

    }
}
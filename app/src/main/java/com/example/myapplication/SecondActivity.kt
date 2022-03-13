package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import diceemu.*


class SecondActivity : AppCompatActivity() {
    private lateinit var diceNumber: EditText
    private lateinit var maxNumber: TextView
    private lateinit var buttonGenerate: Button
    private lateinit var diceLayout: FrameLayout


    private var infoToast = InfoToast(this)

    private fun generateDiceTable(diceCount: Int, diceMaxNumber: Int): ArrayList<TextView> {
        var textViewArray = ArrayList<TextView>()

        val dicePerLine = 8

        var diceCounter = 0
        var lineCounter = 0

        for (i in 1..diceCount) {
            var diceValue = Calc().randomNumber(diceMaxNumber)
            var newTextView = Dice(diceValue).toTextView(this, diceCounter, lineCounter)

            textViewArray.add(newTextView)

            diceCounter++
            if (diceCounter == dicePerLine) {
                diceCounter = 0
                lineCounter++
            }
        }

        return textViewArray
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        diceNumber = findViewById<EditText>(R.id.editTextDiceNumber)
        maxNumber = findViewById<EditText>(R.id.editTextDiceMaximumNumber)

        diceLayout = findViewById<FrameLayout>(R.id.diceLayout)

        buttonGenerate = findViewById<Button>(R.id.buttonGenerateDice)

        val dicePerLine = 8

        var diceCounter = 0
        var lineCounter = 0

        buttonGenerate.setOnClickListener {
            var strDiceNum = diceNumber.text.toString()
            var diceNum = strDiceNum.toIntOrNull()

            var strMaxNum = maxNumber.text.toString()
            var maxNum = strMaxNum.toIntOrNull()

            when {
                diceNum == null -> {
                    infoToast.error("Please fill correct dice number")
                }
                diceNum > DICE_MAX_COUNT -> {
                    infoToast.error("Dice number may be less then 20")
                }
                maxNum == null -> {
                    infoToast.error("Please fill Maximum number")
                }
                else -> {
                    diceLayout.removeAllViews()
                    var textViewDiceArray = generateDiceTable(diceNum, maxNum)
                    textViewDiceArray.forEach { diceLayout.addView(it) }
                }
            }
        }
    }
}
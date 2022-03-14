package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import diceemu.*

class SecondActivity : AppCompatActivity() {
    private lateinit var diceNumber: EditText
    private lateinit var maxNumber: TextView

    private lateinit var buttonGenerate: Button
    private lateinit var buttonDiceCountPlus: Button
    private lateinit var buttonDiceCountMinus: Button

    private lateinit var diceLayout: FrameLayout

    private var infoToast = InfoToast(this)
    private val minDiceCount = 1

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

    private fun addDice() {
        var strDiceNum = diceNumber.text.toString()
        var diceNum = strDiceNum.toIntOrNull()

        when (diceNum) {
            null -> {
                diceNumber.setText(minDiceCount.toString())
            }
            else -> {
                diceNum++
                diceNumber.setText(diceNum.toString())
            }
        }
    }

    private fun removeDice() {
        var strDiceNum = diceNumber.text.toString()
        var diceNum = strDiceNum.toIntOrNull()

        when {
            diceNum == null -> {
                diceNumber.setText(minDiceCount.toString())
            }
            diceNum > minDiceCount -> {
                diceNum--
                diceNumber.setText(diceNum.toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Init GUI elements
        diceNumber = findViewById<EditText>(R.id.editTextDiceNumber)
        maxNumber = findViewById<EditText>(R.id.editTextDiceMaximumNumber)

        diceLayout = findViewById<FrameLayout>(R.id.diceLayout)

        buttonGenerate = findViewById<Button>(R.id.buttonGenerateDice)
        buttonDiceCountPlus = findViewById<Button>(R.id.buttonDiceCountPlus)
        buttonDiceCountMinus = findViewById<Button>(R.id.buttonDiceCountMinus)

        // Set defaults
        diceNumber.setText(DEFAULT_MAX_VALUE.toString())
        maxNumber.setText(DEFAULT_MAX_COUNT.toString())

        // Buttons
        buttonGenerate.setOnClickListener {
            var strDiceNum = diceNumber.text.toString()
            var diceNum = strDiceNum.toIntOrNull()

            var strMaxNum = maxNumber.text.toString()
            var maxNum = strMaxNum.toIntOrNull()

            when {
                diceNum == null -> {
                    infoToast.error("Please fill correct dice number")
                }
                diceNum > MAX_DICE_COUNT -> {
                    infoToast.error("Dice number must be less then " + (MAX_DICE_COUNT+1))
                }
                maxNum == null -> {
                    infoToast.error("Please fill Maximum number")
                }
                maxNum > MAX_DICE_VALUE -> {
                    infoToast.error("Value must be less then " + (MAX_DICE_VALUE+1))
                }

                else -> {
                    diceLayout.removeAllViews()
                    var textViewDiceArray = generateDiceTable(diceNum, maxNum)
                    textViewDiceArray.forEach { diceLayout.addView(it) }
                }
            }
        }

        buttonDiceCountPlus.setOnClickListener { addDice() }
        buttonDiceCountMinus.setOnClickListener { removeDice() }

    }
}
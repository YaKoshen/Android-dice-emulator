package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import java.util.*
import infotoast.*


class SecondActivity : AppCompatActivity() {
    private lateinit var diceNumber: EditText
    private lateinit var maxNumber: TextView
    private lateinit var buttonGenerate: Button
    private lateinit var diceLayout: FrameLayout


    private var infoToast = InfoToast(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        diceNumber = findViewById<EditText>(R.id.editTextDiceNumber)
        maxNumber = findViewById<EditText>(R.id.editTextDiceMaximumNumber)

        diceLayout = findViewById<FrameLayout>(R.id.diceLayout)

        buttonGenerate = findViewById<Button>(R.id.buttonGenerateDice)


        buttonGenerate.setOnClickListener {
            var strDiceNum = diceNumber.text.toString()
            var diceNum = strDiceNum.toIntOrNull()

            var strMaxNum = maxNumber.text.toString()
            var maxNum = strMaxNum.toIntOrNull()

            when {
                diceNum == null -> {
                    infoToast.error("Please fill correct dice number")
                }
                diceNum > 20 -> {
                    infoToast.error("Dice number may be less then 20")
                }
                maxNum == null -> {
                    infoToast.error("Please fill Maximum number")
                }
                else -> {
                    diceLayout.removeAllViews()

                    val newTextView = TextView(this)

                    newTextView.textSize = 20f
                    newTextView.text = (Random().nextInt(maxNum) + 1).toString()

                    diceLayout.addView(newTextView)

                    // var newLayoutArray = arrayOfNulls<TextView>(diceNum)

                    // for (i in 1..diceNum) newLayoutArray[i] = newTextViewDice(maxNum)
                    //for (i in 1..diceNum) diceLayout.addView(newLayoutArray[i])
                }
            }
        }
    }
}
package com.example.myapplication

import android.os.Bundle
import android.widget.*
import android.widget.LinearLayout.LayoutParams
import androidx.appcompat.app.AppCompatActivity

import diceemu.*


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
                    // diceLayout.removeAllViews()

                    val newTextView = TextView(this)

                    var params: LayoutParams = LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT
                    )
                    params.setMargins(
                        10 + (diceCounter * 120),
                        60 + (lineCounter * 120),
                        10,
                        10
                    )

                    newTextView.layoutParams = params
                    newTextView.textSize = 30f
                    newTextView.text = Dice(Calc().randomNumber(maxNum)).draw()


                    diceLayout.addView(newTextView)

                    diceCounter++
                    if (diceCounter == dicePerLine) {
                        diceCounter = 0
                        lineCounter++
                    }

                    /*
                    val newTextView2 = TextView(this)

                    newTextView2.textSize = 30f
                    newTextView2.text = "newTextView2"

                    diceLayout.addView(newTextView2)
                    */

                    /* var newLayoutArray = arrayOfNulls<TextView>(diceNum)
                    for (i in 1..diceNum) newLayoutArray[i] = newTextView
                    for (i in 1..diceNum) diceLayout.addView(newTextView)
                     */
                }
            }
        }
    }
}
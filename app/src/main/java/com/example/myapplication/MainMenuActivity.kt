package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenuActivity : AppCompatActivity() {
    private lateinit var buttonMenuDiceGenerator: Button
    private lateinit var buttonMenuRules: Button
    private lateinit var buttonMenuUnits: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // Init GUI elements
        buttonMenuDiceGenerator = findViewById<Button>(R.id.buttonMenuDiceGenerator)
        buttonMenuRules = findViewById<Button>(R.id.buttonMenuRules)
        buttonMenuUnits = findViewById<Button>(R.id.buttonMenuUnits)

        // Buttons logic
        buttonMenuDiceGenerator.setOnClickListener {
            val diceGeneratorActivity = Intent(this, DiceGeneratorActivity::class.java)
            startActivity(diceGeneratorActivity)
        }

    }
}
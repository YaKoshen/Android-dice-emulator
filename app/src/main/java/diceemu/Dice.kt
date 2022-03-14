package diceemu

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView

class Dice(value: Int = 1) {
    private val value = value

    fun draw(): String {
        if (value < 10) return "[ $value ]"
        return "[$value]"
    }

    fun toTextView(context: Context, leftPos: Int, topPos: Int): TextView {
        val newTextView = TextView(context)

        var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(
            10 + (leftPos * 120),
            topPos * 120,
            10,
            10
        )

        newTextView.layoutParams = params
        newTextView.textSize = 30f
        newTextView.text = Dice(value).draw()

        return newTextView
    }
}
package diceemu

class Dice(value: Int = 1) {
    private val value = value

    fun draw(): String {
        if (value < 10) return "[ $value ]"
        return "[$value]"
    }
}
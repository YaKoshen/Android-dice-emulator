package diceemu

import java.util.*

class Calc {
    private val maxNumber = MAX_DICE_VALUE
    private val minNumber = 1

    fun randomNumber(maximumNumber: Int = 1): Int {
        assert(maximumNumber <= maxNumber)
        assert(maximumNumber > minNumber)

        return Random().nextInt(maximumNumber) + 1
    }
}
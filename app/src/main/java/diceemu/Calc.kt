package diceemu

import java.util.*

const val DICE_MAX_COUNT = 54

class Calc {
    private val maxNumber = 100
    private val minNumber = 1

    fun randomNumber(maximumNumber: Int = 1): Int {
        assert(maximumNumber <= maxNumber)
        assert(maximumNumber > minNumber)

        return Random().nextInt(maximumNumber) + 1
    }
}
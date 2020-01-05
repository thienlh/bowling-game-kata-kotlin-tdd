package org.sample

class BowlingGame {
    private var rolls: IntArray = IntArray(21)
    private var currentRoll: Int = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    fun score(): Int {
        var score = 0
        var frameIndex = 0
        for (frame in 0..9) {
            when {
                isStrike(frameIndex) -> {
                    score += 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2]
                    frameIndex++
                }
                isSpare(frameIndex) -> {
                    score += 10 + rolls[frameIndex + 2]
                    frameIndex += 2
                }
                else -> {
                    score += rolls[frameIndex] + rolls[frameIndex + 1]
                    frameIndex += 2
                }
            }
        }
        return score
    }

    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == 10

    private fun isSpare(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1] == 10
}
package org.sample

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BowlingGameTest {
    private lateinit var game: BowlingGame

    @Before
    fun setUp() {
        game = BowlingGame()
    }

    private fun rollMany(n: Int, pins: Int) {
        for (i in 1..n) {
            game.roll(pins)
        }
    }

    private fun rollStrike() {
        game.roll(10)
    }

    private fun rollSpare() {
        game.roll(5)
        game.roll(5)
    }

    @Test
    fun testGutterGame() {
        rollMany(20, 0)
        assertEquals(0, game.score())
    }

    @Test
    fun testAllOnes() {
        rollMany(20, 1)
        assertEquals(game.score(), 20)
    }

    @Test
    fun testOneSpare() {
        rollSpare()
        game.roll(3)
        rollMany(17, 0)
        assertEquals(16, game.score())
    }

    @Test
    fun testOneStrike() {
        rollStrike()
        game.roll(3)
        game.roll(4)
        rollMany(12, 0)
        assertEquals(24, game.score())
    }

    @Test
    fun testPerfectGame() {
        rollMany(12, 10)
        assertEquals(300, game.score())
    }
}
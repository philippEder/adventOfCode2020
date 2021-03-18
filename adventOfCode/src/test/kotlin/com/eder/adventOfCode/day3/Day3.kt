package com.eder.adventOfCode.day3

import org.junit.jupiter.api.Test

class day3 {


    @Test
    fun partOne() {
        print(countTrees(3, 1))
    }

    @Test
    fun partTwo() {

        val one = countTrees(1,1)
        val two = countTrees(3, 1)
        val three = countTrees(5, 1)
        val four = countTrees(7, 1)
        val five = countTrees(1, 2)

        val product = one * two * three * four * five

        print(product)
    }

    private fun countTrees(xIncrement : Int, yIncrement : Int) : Int {
        val field = ReaderDay3.readDay3Input("/dayThreeInput.txt")
        val length = field.size
        val width = field[0].size

        var currentX = 0
        var currentY = 0
        var treeCount = 0

        while (currentY < length) {
            if (field[currentY][currentX]) {
                treeCount++
            }

            currentX += xIncrement
            currentY += yIncrement
            if (currentX >= width) {
                val difference = currentX - width
                currentX = difference
            }
        }

        return treeCount;
    }

}
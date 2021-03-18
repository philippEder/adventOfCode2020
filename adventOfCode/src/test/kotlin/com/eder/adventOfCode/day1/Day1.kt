package com.eder.adventOfCode.day1

import com.eder.adventOfCode.reader.ReaderUtils
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class day1 {

    @Test
    fun partOne() {

        val expenses = ReaderUtils.readLinesAsInteger("/dayOneInput.txt")
        val twoTwentySummands = getSummandPairAddingTo2020(expenses)

        val result = twoTwentySummands.first * twoTwentySummands.second
    }

    @Test
    fun partTwo() {

        val expenses = ReaderUtils.readLinesAsInteger("/dayOneInput.txt")
        val twoTwentySummands = getSummandTripleAddingTo2020(expenses)

        val result = twoTwentySummands.first * twoTwentySummands.second * twoTwentySummands.third
    }


    private fun getSummandPairAddingTo2020(expenses : List<Int>) : Pair<Int, Int> {

        val twoTwenty = 2020

        for (summand1 in expenses) {
            for (summand2 in expenses) {
                if (summand1 + summand2 == twoTwenty) {
                    return Pair(summand1, summand2)
                }
            }
        }

        throw IllegalArgumentException("No 2 summands adding up to 2020 found");
    }

    private fun getSummandTripleAddingTo2020(expenses : List<Int>) : Triple<Int, Int, Int> {

        val twoTwenty = 2020

        for (summand1 in expenses) {
            for (summand2 in expenses) {
                for (summand3 in expenses) {
                    if (summand1 + summand2 + summand3 == twoTwenty) {
                        return Triple(summand1, summand2, summand3)
                    }
                }
            }
        }

        throw IllegalArgumentException("No 2 summands adding up to 2020 found");
    }

}
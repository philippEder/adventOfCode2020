package com.eder.adventOfCode.day4

import org.junit.jupiter.api.Test

class day4 {

    @Test
    fun day4() {
        val passports = ReaderDay4.readPassportInput("/dayFourInput.txt")
        val validCount = passports.count { it.isValid() }
        print(validCount)
    }

}
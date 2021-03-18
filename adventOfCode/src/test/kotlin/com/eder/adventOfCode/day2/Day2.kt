package com.eder.adventOfCode.day2

import org.junit.jupiter.api.Test

class day2 {

    @Test
    fun partOne() {
        val passwords = PasswordReader.readPasswordInput("/dayTwoInput.txt")

        val result = passwords.count { it.isValid() }
    }

    @Test
    fun partTwo() {
        val passwords = PasswordReader.readPasswordInput("/dayTwoInput.txt")

        val result = passwords.count { it.isValidDay2() }
    }



}
package com.eder.adventOfCode.day2

class Password(val minimalAmount : Int, val maximalAmount : Int, val character : String, val password : String) {

    fun isValid() : Boolean {
        val characterCount = password.filter{ it.toString() == character}.count()

        return characterCount in minimalAmount..maximalAmount
    }

    fun isValidDay2() : Boolean {
        val firstCharacter = password[minimalAmount-1].toString()
        val secondCharacter = password[maximalAmount-1].toString()

        if (firstCharacter != secondCharacter) {
            if (firstCharacter == character || secondCharacter == character) {
                return true
            }
        }

        return false
    }

}
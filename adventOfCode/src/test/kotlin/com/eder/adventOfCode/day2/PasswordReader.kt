package com.eder.adventOfCode.day2

import com.eder.adventOfCode.reader.ReaderUtils

object PasswordReader {

    fun readPasswordInput(path : String) : List<Password> {
        val lines = ReaderUtils.readLines(path)
        return lines.map { getPasswordFromLine(it) }
    }

    private fun getPasswordFromLine(line : String) : Password {
        val minimal = line.substringBefore('-').toInt();
        val maximum = line.substring(line.indexOf('-')+1, line.indexOf(' ')).toInt()
        val character = line.substring(line.indexOf(' ')+1, line.indexOf(':'))
        val password = line.substringAfterLast(' ')

        return Password(minimal, maximum, character, password)
    }

}
package com.eder.adventOfCode.day3

import com.eder.adventOfCode.reader.ReaderUtils

object ReaderDay3 {

    fun readDay3Input(path: String): List<List<Boolean>> {

        val field: MutableList<List<Boolean>> = mutableListOf()

        val lines = ReaderUtils.readLines(path);
        lines.forEach {
            val booleanLine = it.map { xChar -> xChar == '#' }
            field.add(booleanLine)
        }

        return field
    }
}
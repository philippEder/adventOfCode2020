package com.eder.adventOfCode.day4

import com.eder.adventOfCode.reader.LineBundle
import com.eder.adventOfCode.reader.ReaderUtils
import com.eder.adventOfCode.reader.ReaderUtils.bundle
import com.eder.adventOfCode.reader.ReaderUtils.splitAt

object ReaderDay4 {

    fun readPassportInput(path : String) : List<Passport> {
        val lines = ReaderUtils.readLines(path)
        val lineBundles = bundle(lines)
        return convertLineBundlesToPassports(lineBundles)
    }

    private fun convertLineBundlesToPassports(bundles: List<LineBundle>) = bundles.map { convertLineBundleToPassport(it)}

    private fun convertLineBundleToPassport(bundle: LineBundle) : Passport {
        val passport = Passport()
        for (line in bundle.lines) {
            val pairs = lineToPairs(line)
            for (pair in pairs) {
               passport.withProperty(pair.first, pair.second)
            }
        }
        return passport
    }

    private fun lineToPairs(line : String): List<Pair<String, String>> {
        val pairs = splitAt(line," ")
        return pairs.map { Pair(it.substringBefore(':').trim(), it.substringAfter(':').trim()) }
    }
}
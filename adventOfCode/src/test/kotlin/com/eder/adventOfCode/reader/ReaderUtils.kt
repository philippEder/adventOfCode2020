package com.eder.adventOfCode.reader

object ReaderUtils {


    fun readLines(path: String): List<String> = javaClass.getResource(path).readText().split("\r\n")
    fun readLinesAsInteger(path: String): List<Int> = readLines(path).map { it.toInt() }
    fun isEmptyLine(line: String): Boolean = line == ""
    fun splitAt(line: String, splitRegex: String): List<String> = line.split(splitRegex)
    fun isLastInLine(line: String, lines: List<String>): Boolean = lines.last() == line

    fun bundle(lines: List<String>): List<LineBundle> {
        val bundles = mutableListOf<LineBundle>()
        var bundle = LineBundle()
        for (line in lines)
            if (isEmptyLine(line)) {
                bundles.add(bundle)
                bundle = LineBundle()
            } else {
                bundle.lines.add(line)
                if (isLastInLine(line, lines))
                    bundles.add(bundle)
            }
        return bundles
    }

}

package com.eder.adventOfCode.day4


enum class PassportProperty(val code: String, val validate : (String) -> Boolean) {
    BIRTH_YEAR("byr",      { it.length == 4 && it.toInt() >= 1920 && it.toInt() <= 2002 }),
    ISSUE_YEAR("iyr",      { it.length == 4 && it.toInt() >= 2010 && it.toInt() <= 2020 }),
    EXPIRATION_YEAR("eyr", { it.length == 4 && it.toInt() >= 2020 && it.toInt() <= 2030 }),
    HAIR_COLOR("hcl",      { it.startsWith("#") && it.length == 7 && "[a-z0-9]+".toRegex().matches(it.substringAfter("#")) }),
    EYE_COLOR("ecl",       { validHairColors.contains(it) }),
    PASSPORT_ID("pid",     { "[0-9]+".toRegex().matches(it) && it.length == 9 }),
    COUNTRY_ID("cid",      { true }),
    HEIGHT("hgt",{
        (it.endsWith("cm") && it.substringBefore("cm").toInt() >= 150 && it.substringBefore("cm").toInt() <= 193) ||
        (it.endsWith("in") && it.substringBefore("in").toInt() >= 59  && it.substringBefore("in").toInt() <= 76)
    });

    companion object {
        val validHairColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        private val CACHE = values().associateBy(PassportProperty::code)
        fun fromCode(code: String) : PassportProperty = CACHE[code]!!
    }

}
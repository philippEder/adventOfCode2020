package com.eder.adventOfCode.day4

class Passport {

    private val properties : MutableMap<PassportProperty, String> = mutableMapOf()


    fun withProperty(property: String, value: String) : Passport = withProperty(PassportProperty.fromCode(property), value)
    fun withProperty(property: PassportProperty, value: String) : Passport {
        properties[property] = value
        return this
    }

    fun isValid() : Boolean = (areAllPropertiesPresent() || isOnlyCountryPropertyMissing()) && allPropertiesAreValid()

    private fun allPropertiesAreValid(): Boolean = properties.all { isPropertyValid(it.key, it.value) }
    private fun isPropertyValid(property: PassportProperty, value: String) = property.validator(value)
    private fun areAllPropertiesPresent() = PassportProperty.values().size == properties.size
    private fun isOnlyCountryPropertyMissing(): Boolean {
        val isMissingOneProperty = (PassportProperty.values().size - properties.size) == 1
        val isCountryPropertyMissing = properties[PassportProperty.COUNTRY_ID] == null
        return isMissingOneProperty && isCountryPropertyMissing
    }


}
package com.eder.adventOfCode.day4

class Passport {

    private val properties : MutableMap<PassportProperty, String> = mutableMapOf()


    fun withProperty(property: String, value: String) : Passport {
        return withProperty(PassportProperty.fromCode(property), value)
    }

    fun withProperty(property: PassportProperty, value: String) : Passport {
        properties[property] = value
        return this
    }

    fun getPropertyValue(property: PassportProperty) = properties[property]

    fun isValid() : Boolean = (areAllPropertiesPresent() || isOnlyCountryPropertyMissing()) && allPropertiesAreValid()

    private fun allPropertiesAreValid(): Boolean {
        var isOverallValid = true
        for (property in properties) {
            val prop = property.key
            val value = property.value

            val isValid = prop.validator.invoke(value)
            println("${prop} -> ${value} = ${isValid}")
            if (!isValid)  {
                isOverallValid = false
            }
        }
        return isOverallValid
     }

    private fun areAllPropertiesPresent() = PassportProperty.values().size == properties.size

    private fun isOnlyCountryPropertyMissing(): Boolean {
        val isMissingOneProperty = (PassportProperty.values().size - properties.size) == 1
        val isCountryPropertyMissing = properties[PassportProperty.COUNTRY_ID] == null
        return isMissingOneProperty && isCountryPropertyMissing
    }


}
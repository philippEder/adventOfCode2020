package com.eder.famtree.dto

import com.eder.famtree.jpa.Human
import java.time.LocalDate

data class HumanDto(

    val name : String?,
    val dateOfBirth : LocalDate?,
    val dateOfDeath : LocalDate?,
    val children : MutableSet<HumanDto>
) {
  companion object {
      fun fromHuman(human : Human) : HumanDto = HumanDto(human.name, human.dateOfBirth, human.dateOfDeath, mutableSetOf())
  }
}

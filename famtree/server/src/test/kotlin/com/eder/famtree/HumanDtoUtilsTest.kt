package com.eder.famtree

import com.eder.famtree.dto.HumanDtoUtils.transformToDtos
import com.eder.famtree.jpa.Human
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class HumanDtoUtilsTest {

    @Test
    fun nestedHumanDtosTest() {
        val humans = prepareNestedHumanDtosTestData()
        val humanDtos = transformToDtos(humans)
        val root = humanDtos.get(0)
        val level1 = root.children
        val level2 = level1.flatMap { it.children }
        val level3 = level2.flatMap { it.children }
        Assertions.assertEquals(level1.size, 1)
        Assertions.assertEquals(level2.size, 2)
        Assertions.assertEquals(level3.size, 1)
    }

    private fun prepareNestedHumanDtosTestData(): List<Human> {
        val human1 = Human(1, "Irmgard Eder", LocalDate.of(1950, 1, 25), null, null, null)
        val human2 = Human(2, "Michaela Eder", LocalDate.of(1971, 11, 21), null, human1, null)
        val human3 = Human(3, "Philipp Eder", LocalDate.of(1992, 12, 7), null, human2, null)
        val human4 = Human(4, "Marlene Winkler", LocalDate.of(1998, 5, 18), null, human2, null)
        val human5 = Human(5, "Buddy Winkler", LocalDate.of(2019, 1, 1), null, human4, null)

        return listOf(human1, human2, human3, human4, human5)
    }

}
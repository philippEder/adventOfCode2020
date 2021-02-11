package com.eder.famtree

import com.eder.famtree.jpa.Human
import com.eder.famtree.service.HumanService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class FamtreeApplicationTests {

	@Autowired
	lateinit var humanService : HumanService

	@Test
	fun createHumanTest() {
		humanService.saveHuman(Human( "Jon Doe", LocalDate.of(1992, 7, 1), LocalDate.of(2070, 12, 1), null ,null))
		Assertions.assertEquals(humanService.findAllHumans().size, 1)
	}

}

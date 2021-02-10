package com.eder.famtree.rest

import com.eder.famtree.jpa.Human
import com.eder.famtree.service.HumanService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController()
class HumanRestController(val humanService: HumanService) {

    @GetMapping("/api/all")
    fun getAllHumans() = humanService.getAllHumans()

    @GetMapping("/api/human")
    fun getHumanById(@RequestParam(name = "id") id: Int) = humanService.getHumanById(id)

    @GetMapping("/api/testdata")
    fun getTestdata(): Set<Human> {
        return setOf(
            Human(1, "Irmgard Eder", LocalDate.of(1950, 1, 25), null, null, null),
            Human(2, "Alexandra Kussbauer", LocalDate.of(1970, 1, 1), null, null, null),
            Human(3, "Michaela Eder", LocalDate.of(1971, 11, 21), null,null, null),
            Human(4, "Philipp Eder", LocalDate.of(1992, 12, 7), null,null, null),
            Human(5, "Marlene Winkler",  LocalDate.of(1998,5, 18), null,null, null),
            Human(6, "Buddy Winkler",  LocalDate.of(2019,1, 1), null,null, null)
        )
    }

    @PostMapping("/add")
    fun addHuman(@RequestBody human: Human) = humanService.createHuman(human)
}
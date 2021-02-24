package com.eder.famtree.rest

import com.eder.famtree.dto.HumanDtoUtils
import com.eder.famtree.jpa.Human
import com.eder.famtree.service.HumanService
import org.springframework.web.bind.annotation.*

@RestController
class HumanRestController(val humanService: HumanService) {

    @GetMapping("/api/treedata")
    fun getAllHumans() = HumanDtoUtils.transformToDtos(humanService.findAllHumans())

    @GetMapping("/api/human")
    fun getHumanById(@RequestParam(name = "id") id: Int) = humanService.findHumanById(id)

    @PostMapping("/api/add")
    fun addHuman(@RequestBody human: Human) = humanService.saveHuman(human)

    @GetMapping("/api/generatetestdata")
    fun generateTestData() = humanService.generateTestdata()

}
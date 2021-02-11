package com.eder.famtree.rest

import com.eder.famtree.dto.HumanDtoUtils
import com.eder.famtree.jpa.Human
import com.eder.famtree.service.HumanService
import org.springframework.web.bind.annotation.*

@RestController("/api")
class HumanRestController(val humanService: HumanService) {

    @GetMapping("/all")
    fun getAllHumans() = HumanDtoUtils.transformToDtos(humanService.findAllHumans())

    @GetMapping("/human")
    fun getHumanById(@RequestParam(name = "id") id: Int) = humanService.findHumanById(id)

    @PostMapping("/add")
    fun addHuman(@RequestBody human: Human) = humanService.saveHuman(human)
}
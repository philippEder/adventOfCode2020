package com.eder.famtree.rest

import com.eder.famtree.repo.HumanRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HumanRestService {

    @Autowired
    lateinit var humanRepo : HumanRepo

    @GetMapping("/all")
    fun getAllHumans() = humanRepo.findAll();

    @GetMapping("/all")
    fun getHumanById(@RequestParam(value = "id") id : Int) = humanRepo.findById(id);



}
package com.eder.famtree.service

import com.eder.famtree.jpa.Human
import com.eder.famtree.repo.HumanRepo
import org.springframework.stereotype.Service

interface HumanService {

    fun getHumanById(id : Int) : Human
    fun getAllHumans() : List<Human>

    fun createHuman(human : Human) : Human

}

@Service
private class HumanServiceImpl(val humanRepo : HumanRepo) : HumanService {

    override fun getHumanById(id: Int) = humanRepo.findById(id).get()

    override fun getAllHumans() = humanRepo.findAll()

    override fun createHuman(human: Human) = humanRepo.save(human)

}
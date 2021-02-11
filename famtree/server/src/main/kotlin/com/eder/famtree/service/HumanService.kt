package com.eder.famtree.service

import com.eder.famtree.jpa.Human
import com.eder.famtree.repo.HumanRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface HumanService {

    fun findHumanById(id : Int) : Human
    fun findAllHumans() : List<Human>
    fun saveHuman(human : Human) : Human

}

@Service
private class HumanServiceImpl(val humanRepo : HumanRepo) : HumanService {

    @Transactional(readOnly = true)
    override fun findHumanById(id: Int) = humanRepo.findById(id).get()

    @Transactional(readOnly = true)
    override fun findAllHumans() = humanRepo.findAll()

    @Transactional
    override fun saveHuman(human: Human) = humanRepo.save(human)

}
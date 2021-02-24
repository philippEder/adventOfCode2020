package com.eder.famtree.service

import com.eder.famtree.jpa.Human
import com.eder.famtree.repo.HumanRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

interface HumanService {

    fun findHumanById(id : Int) : Human
    fun findAllHumans() : List<Human>
    fun saveHuman(human : Human) : Human
    fun generateTestdata()

}

@Service
private class HumanServiceImpl(val humanRepo : HumanRepo) : HumanService {

    @Transactional(readOnly = true)
    override fun findHumanById(id: Int) = humanRepo.findById(id).get()

    @Transactional(readOnly = true)
    override fun findAllHumans() = humanRepo.findAll()

    @Transactional
    override fun saveHuman(human: Human) = humanRepo.save(human)

    @Transactional
    override fun generateTestdata() {
        val human1 = Human(1, "Irmgard Eder", LocalDate.of(1950, 1, 25), null, null, null)
        val human2 = Human(2, "Michaela Eder", LocalDate.of(1971, 11, 21), null, human1, null)
        val human3 = Human(3, "Philipp Eder", LocalDate.of(1992, 12, 7), null, human2, null)
        val human4 = Human(4, "Marlene Winkler", LocalDate.of(1998, 5, 18), null, human2, null)
        val human5 = Human(5, "Buddy Winkler", LocalDate.of(2019, 1, 1), null, human4, null)

        humanRepo.save(human1)
        humanRepo.save(human2)
        humanRepo.save(human3)
        humanRepo.save(human4)
        humanRepo.save(human5)
    }

}
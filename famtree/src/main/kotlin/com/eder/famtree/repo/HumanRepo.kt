package com.eder.famtree.repo

import com.eder.famtree.jpa.Human
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HumanRepo : CrudRepository<Human, Int> {


}
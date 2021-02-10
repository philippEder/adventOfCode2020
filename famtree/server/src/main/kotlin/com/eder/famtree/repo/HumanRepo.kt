package com.eder.famtree.repo

import com.eder.famtree.jpa.Human
import org.springframework.data.jpa.repository.JpaRepository


interface HumanRepo : JpaRepository<Human, Int> {


}
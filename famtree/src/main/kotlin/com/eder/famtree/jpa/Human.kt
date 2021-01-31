package com.eder.famtree.jpa

import java.time.LocalTime
import javax.persistence.*

@Entity
data class Human(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id : Int,

    @Column
    var name : String?,

    @Column
    val dateOfBirth : LocalTime?,

    @Column
    var dateOfDeath : LocalTime?,

    @Column
    var mother : Human?,

    @Column
    var father : Human?

)
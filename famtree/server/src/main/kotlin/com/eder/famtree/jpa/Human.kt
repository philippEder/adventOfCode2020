package com.eder.famtree.jpa

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table
data class Human(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id : Int?,

    @Column
    var name : String?,

    @Column
    val dateOfBirth : LocalDate?,

    @Column
    var dateOfDeath : LocalDate?,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mother", referencedColumnName = "id")
    var mother : Human?,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "father", referencedColumnName = "id")
    var father : Human?,

) {
    constructor(name: String?, dateOfBirth: LocalDate?, dateOfDeath: LocalDate?, mother: Human?, father: Human?) : this(null, name, dateOfBirth ,dateOfDeath, mother, father)
}
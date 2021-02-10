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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mother", referencedColumnName = "id", insertable = false, updatable = false)
    var mother : Human?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mother", referencedColumnName = "id", insertable = false, updatable = false)
    var father : Human?,

)
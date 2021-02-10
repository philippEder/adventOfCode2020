package com.eder.famtree.jpa

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ParentsChildRelationId(
    val father : Int,
    val mother : Int,
    val child : Int
) : Serializable
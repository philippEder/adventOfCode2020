package com.eder.famtree.jpa

import javax.persistence.*

@Entity
@Table
class ParentsChildRelation (

    @EmbeddedId
    val id : ParentsChildRelationId,


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "father", referencedColumnName = "id", insertable = false, updatable = false)
    val father : Human,


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mother", referencedColumnName = "id", insertable = false, updatable = false)
    val mother : Human,


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "child", referencedColumnName = "id", insertable = false, updatable = false)
    val child : Human


)
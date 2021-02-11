package com.eder.famtree.dto

import com.eder.famtree.jpa.Human

object HumanDtoUtils {

    fun transformToDtos(humans: List<Human>) : List<HumanDto> {

        val rootHumanDtos = mutableListOf<HumanDto>()
        val rootHumans = getRootHumans(humans)

        rootHumans.forEach { visitHuman(it, HumanDto.fromHuman(it), humans, rootHumanDtos) }

        return rootHumanDtos
    }

    private fun getRootHumans(humans : List<Human>) : List<Human> = humans.filter { isRootHuman(it) }

    private fun getChildrenForHuman(human : Human, humans : List<Human>) : List<Human> = humans.filter { it.mother == human || it.father == human }

    private fun isRootHuman(human : Human) : Boolean = human.father == null && human.mother == null

    private fun visitHuman(parent : Human, parentDto : HumanDto, allHumans : List<Human>, rootHumanDtos : MutableList<HumanDto>) {
        val children = getChildrenForHuman(parent, allHumans)

        if (isRootHuman(parent)) {
            rootHumanDtos.add(parentDto)
        }

        for (child in children) {
            val childDto = HumanDto.fromHuman(child)
            parentDto.children.add(childDto)
            visitHuman(child, childDto, allHumans, rootHumanDtos)
        }
    }

}
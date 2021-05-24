package com.scrummaster.arboretocarmelopalma.retrofit

import javax.inject.Inject
import com.scrummaster.arboretocarmelopalma.model.Tree
import com.scrummaster.arboretocarmelopalma.utils.EntityMapper

class NetworkMapper
@Inject
constructor() : EntityMapper<TreeNetworkEntity, Tree> {
    override fun mapFromEntity(entity: TreeNetworkEntity): Tree {
        return Tree(
            id = entity.id,
            name = entity.name,
            scientific_name = entity.scientific_name,
            family = entity.family,
            distribution = entity.distribution,
            description = entity.description,
            utility = entity.utility,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Tree): TreeNetworkEntity {
        return  TreeNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            scientific_name = domainModel.scientific_name,
            family = domainModel.family,
            distribution = domainModel.distribution,
            description = domainModel.description,
            utility = domainModel.utility,
            image = domainModel.image
        )
    }

    fun mapFromEntityList(entities: List<TreeNetworkEntity>): List<Tree>{
        return entities.map { mapFromEntity(it) }
    }
}
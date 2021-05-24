package com.scrummaster.arboretocarmelopalma.room

import com.scrummaster.arboretocarmelopalma.model.Tree
import com.scrummaster.arboretocarmelopalma.utils.EntityMapper
import javax.inject.Inject


class CacheMapper
@Inject
constructor():
    EntityMapper<TreeCacheEntity, Tree> {

        override fun mapFromEntity(entity: TreeCacheEntity): Tree {
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

        override fun mapToEntity(domainModel: Tree): TreeCacheEntity {
            return TreeCacheEntity(
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

        fun mapFromEntityList(entities: List<TreeCacheEntity>): List<Tree>{
            return entities.map { mapFromEntity(it) }
        }
    }
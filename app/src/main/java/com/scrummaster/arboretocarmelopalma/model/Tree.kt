package com.scrummaster.arboretocarmelopalma.model

data class Tree(
    var id: Int,
    var name: String,
    var scientific_name: String,
    var family: String,
    var distribution: String,
    var description: String,
    var utility: String,
    var image: String,
)

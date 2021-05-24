package com.scrummaster.arboretocarmelopalma.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TreeNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("scientific_name")
    @Expose
    var scientific_name: String,

    @SerializedName("family")
    @Expose
    var family: String,

    @SerializedName("distribution")
    @Expose
    var distribution: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("utility")
    @Expose
    var utility: String,

    @SerializedName("image")
    @Expose
    var image: String,
)
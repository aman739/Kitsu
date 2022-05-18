package com.example.data.remote.dtos.anime


import com.google.gson.annotations.SerializedName
import com.example.domain.models.anime.LinksXXXXXXXXXXXModel

data class LinksXXXXXXXXXXX(
    @SerializedName("self")
    val self: String,
    @SerializedName("related")
    val related: String
)

fun LinksXXXXXXXXXXX.toDomain() = LinksXXXXXXXXXXXModel(
    self, related
)
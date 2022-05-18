package com.example.data.remote.dtos.anime.genres


import com.example.domain.models.anime.genres.LinksModel
import com.google.gson.annotations.SerializedName

data class LinksDto(
    @SerializedName("self")
    val self: String?
)

fun LinksDto.toDomain() = LinksModel(self)
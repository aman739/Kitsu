package com.example.data.remote.dtos.anime.genres


import com.example.domain.models.anime.genres.LinksXModel
import com.google.gson.annotations.SerializedName

data class LinksXDto(
    @SerializedName("first")
    val first: String?,
    @SerializedName("last")
    val last: String?
)

fun LinksXDto.toDomain() = LinksXModel(first, last)
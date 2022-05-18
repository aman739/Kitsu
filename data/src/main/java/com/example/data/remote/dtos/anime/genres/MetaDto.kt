package com.example.data.remote.dtos.anime.genres


import com.example.domain.models.anime.genres.MetaModel
import com.google.gson.annotations.SerializedName

data class MetaDto(
    @SerializedName("count")
    val count: Int?
)

fun MetaDto.toDomain() = MetaModel(count)
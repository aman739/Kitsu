package com.example.data.remote.dtos.anime.genres


import com.example.domain.models.anime.genres.AnimeGenresModel
import com.google.gson.annotations.SerializedName

data class AnimeGenresDto(
    @SerializedName("data")
    val data: List<GenresDataDto>?,
    @SerializedName("meta")
    val meta: MetaDto?,
    @SerializedName("links")
    val links: LinksXDto?
)

fun AnimeGenresDto.toDomain() = AnimeGenresModel(
    data?.map { it.toDomain() }, meta?.toDomain(), links?.toDomain()
)
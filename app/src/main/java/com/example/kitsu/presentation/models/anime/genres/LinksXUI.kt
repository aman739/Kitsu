package com.example.kitsu.presentation.models.anime.genres

data class LinksXUI(
    val first: String?,
    val last: String?
)

fun com.example.domain.models.anime.genres.LinksXModel.toUI() = LinksXUI(first, last)
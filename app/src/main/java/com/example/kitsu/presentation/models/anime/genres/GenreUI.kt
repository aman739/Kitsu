package com.example.kitsu.presentation.models.anime.genres

import com.example.domain.models.anime.genres.GenreModel

data class GenreUI(
    val createdAt: String?,
    val updatedAt: String?,
    val name: String?,
    val slug: String?,
    val description: String?
)

fun GenreModel.toUI() = GenreUI(createdAt, updatedAt, name, slug, description)

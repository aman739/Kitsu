package com.example.kitsu.presentation.models.anime.genres

import com.example.domain.models.anime.genres.GenresDataModel
import com.example.domain.models.anime.genres.LinksModel

data class GenresDataUI(
    val id: String?,
    val type: String?,
    val links: LinksUI?,
    val genres: GenreUI?
)

fun GenresDataModel.toUI() = GenresDataUI(id, type, links?.toUI(), genres?.toUI())
fun LinksModel.toUI() = LinksUI(self)
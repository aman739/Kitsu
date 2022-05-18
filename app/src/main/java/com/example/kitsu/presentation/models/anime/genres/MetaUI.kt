package com.example.kitsu.presentation.models.anime.genres

import com.example.domain.models.anime.genres.MetaModel

data class MetaUI(
    val count: Int?
)
fun MetaModel.toUI() = MetaUI(count)

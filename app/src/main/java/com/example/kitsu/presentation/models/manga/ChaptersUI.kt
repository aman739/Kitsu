package com.example.kitsu.presentation.models.manga

import com.example.domain.models.manga.ChaptersModel

data class ChaptersUI(
    val links: LinksXXXXXXXXUI
)

fun ChaptersModel.toUI() = ChaptersUI(links.toUI())
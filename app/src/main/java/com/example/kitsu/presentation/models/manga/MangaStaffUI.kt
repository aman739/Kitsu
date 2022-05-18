package com.example.kitsu.presentation.models.manga

import com.example.domain.models.manga.MangaStaffModel

data class MangaStaffUI(
    val links: LinksXXXXXXXXXXUI
)

fun MangaStaffModel.toUI() = MangaStaffUI(links.toUI())

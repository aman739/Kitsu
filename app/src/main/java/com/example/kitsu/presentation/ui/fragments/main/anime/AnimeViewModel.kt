package com.example.kitsu.presentation.ui.fragments.main.anime

import com.example.data.repositories.AnimeRepositoryImpl
import com.example.kitsu.presentation.base.BaseViewModel
import com.example.kitsu.presentation.models.anime.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepositoryImpl: AnimeRepositoryImpl
) : BaseViewModel() {

    fun fetchAnime() =
        animeRepositoryImpl.fetchPagedAnime().gatherPagingRequest {
            it.toUI()
        }
}
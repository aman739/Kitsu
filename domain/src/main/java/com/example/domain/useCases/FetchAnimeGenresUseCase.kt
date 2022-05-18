package com.example.domain.useCases

import com.example.domain.repositories.AnimeRepository
import javax.inject.Inject

class FetchAnimeGenresUseCase @Inject constructor(
    private val animeRepository: AnimeRepository
) {
    operator fun invoke(id: String) = animeRepository.fetchAnimeGenres(id)
}
package com.example.domain.useCases

import com.example.domain.repositories.AnimeRepository
import javax.inject.Inject

class FetchDetailedAnimeUseCase @Inject constructor(
    private val animeRepository: AnimeRepository
) {
    operator fun invoke(id: String) = animeRepository.fetchAnimeDetails(id)
}
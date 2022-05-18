package com.example.domain.repositories

import com.example.domain.either.Either
import com.example.domain.models.anime.SingleAnimeModel
import com.example.domain.models.anime.genres.AnimeGenresModel
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun fetchAnimeDetails(id: String): Flow<Either<String, SingleAnimeModel>>
    fun fetchAnimeGenres(id: String): Flow<Either<String, AnimeGenresModel>>
}
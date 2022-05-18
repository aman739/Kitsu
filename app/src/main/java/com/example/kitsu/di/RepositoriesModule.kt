package com.example.kitsu.di

import com.example.data.repositories.AuthenticationRepositoryImpl
import com.example.data.repositories.AnimeRepositoryImpl
import com.example.data.repositories.MangaRepositoryImpl
import com.example.domain.repositories.AnimeRepository
import com.example.domain.repositories.AuthenticationRepository
import com.example.domain.repositories.MangaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindAnimeRepository(
        animeRepositoryImpl: AnimeRepositoryImpl
    ): AnimeRepository

    @Binds
    abstract fun bindMangaRepository(mangaRepositoryImpl: MangaRepositoryImpl): MangaRepository

    @Binds
    abstract fun bindAuthenticationRepository(authenticationRepositoryImpl: AuthenticationRepositoryImpl): AuthenticationRepository
}
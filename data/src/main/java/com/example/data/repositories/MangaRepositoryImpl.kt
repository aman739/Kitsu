package com.example.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.example.data.repositories.base.BaseRepository
import com.example.data.remote.apiservices.MangaApiService
import com.example.data.remote.pagingsources.MangaPagingSource
import com.example.kitsu.data.remote.dtos.manga.toDomain
import com.example.domain.repositories.MangaRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository(), MangaRepository {

    fun fetchPagedManga() = Pager(
        PagingConfig(
            pageSize = 20,
            initialLoadSize = 10
        )
    ) { MangaPagingSource(mangaApiService) }.flow.map { data -> data.map { it.toDomain() } }

    override fun fetchDetailedManga(id: String) = sendRequest {
        mangaApiService.fetchDetailedManga(id).toDomain()
    }
}
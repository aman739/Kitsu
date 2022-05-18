package com.example.kitsu.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kitsu.databinding.ItemAnimeBinding
import com.example.kitsu.presentation.base.BaseDiffUtil
import com.example.kitsu.presentation.extensions.loadImageWithGlide
import com.example.kitsu.presentation.models.anime.AnimeDataUI

class AnimeAdapter(
    private val onItemClick: (id: String, AnimeVideoId: String?) -> Unit
) : PagingDataAdapter<AnimeDataUI, AnimeAdapter.AnimeViewHolder>(BaseDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(animeDataDto: AnimeDataUI) {
            binding.imAnime.loadImageWithGlide(animeDataDto.animeDto.posterImage?.original)
            binding.root.setOnClickListener {
                if (animeDataDto.animeDto.youtubeVideoId != null)
                    onItemClick(animeDataDto.id, animeDataDto.animeDto.youtubeVideoId)
                else {
                    onItemClick(animeDataDto.id, null)
                }
            }
        }
    }
}
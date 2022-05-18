package com.example.kitsu.presentation.ui.fragments.main.anime.detailed

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.databinding.FragmentAnimeDetailedBinding
import com.example.kitsu.presentation.base.BaseFragment
import com.example.kitsu.presentation.extensions.loadImageWithGlide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnimeDetailedFragment :
    BaseFragment<FragmentAnimeDetailedBinding, DetailedAnimeViewModel>(R.layout.fragment_anime_detailed) {
    override val binding by viewBinding(FragmentAnimeDetailedBinding::bind)
    override val viewModel: DetailedAnimeViewModel by viewModels()
    private val args: AnimeDetailedFragmentArgs by navArgs()


    override fun establishRequest() {
        viewModel.fetchSingleAnime(args.animeId)
    }

    override fun launchObservers() {
        subscribeToSingleAnime()
    }

    override fun setupListeners() {
        openAnimeTriler()
    }

    private fun openAnimeTriler() {
        binding.btnAnimeTrailer.setOnClickListener {
            this.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("vnd.youtube:${args.animeVideoId}")
                )
            )
        }

    }

    private fun subscribeToSingleAnime() {
        viewModel.singleAnimeState.spectateUiState(success = {
            binding.apply {

                it.apply {
                    imHorisont.loadImageWithGlide(data.animeDto.coverImage?.original)
                    imVertic.loadImageWithGlide(data.animeDto.posterImage?.medium)
                    tvType.text = data.animeDto.subtype?.uppercase()
                    tvYear.text = data.animeDto.createdAt
                    tvTitle.text = data.animeDto.titles?.en
                    tvDescrip.text = data.animeDto.synopsis
                    tvAverageRating.text = "${data.animeDto.averageRating}%"
                    tvRating.text = "popular #${data.animeDto.ratingRank}"
                    tvPopular.text = "popular #${data.animeDto.popularityRank}"
                    args.animeVideoId?.let {
                        binding.btnAnimeTrailer.isVisible = true
                    }
                }
            }
        }, error = { Log.e("bankai", it) }
        )
    }


}
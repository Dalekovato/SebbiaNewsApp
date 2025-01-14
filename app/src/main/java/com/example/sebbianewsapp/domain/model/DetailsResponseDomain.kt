package com.example.sebbianewsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailsResponseDomain(

    val code: Int,
    val news: DetailsDomain,

    ) : Parcelable
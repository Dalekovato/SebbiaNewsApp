package com.example.sebbianewsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailsDomain (

    val id: Int,
    val title: String,
    val date: String,
    val shortDescription: String,
    val fullDescription: String,

): Parcelable
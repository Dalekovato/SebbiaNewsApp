package com.example.sebbianewsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoriesDomain (

    val id : Int,
    val name: String,

): Parcelable
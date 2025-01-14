package com.example.sebbianewsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BriefResponseNewsDomain(

    val code: Int,
    val list: List<BriefNewsDomain>,

    ) : Parcelable